package com.grailsinaction

import grails.plugin.cache.*

class PostController {
  static defaultAction = 'home'
  static scaffold = true

  static navigation = [
    [group:'tabs', action: 'personal', title: 'My Timeline', order: 0],
    [action: 'global', title: 'Global Timeline', order: 1]
  ]

  def postService
  def springSecurityService

  def home() {
    if (!params.id) {
      params.id = "chuck_norris"
    }

    redirect(action: 'timeline', params: params)
  }

  //@Cacheable('globalTimeline')
  def global() {
    if (springSecurityService.isLoggedIn()) {
      def user = springSecurityService.currentUser
      [ posts: Post.list(params), postCount: Post.count(), user : user ]
    } else {
      [ posts: Post.list(params), postCount: Post.count() ]
    }
  }

  def timeline(String id) {
    def user = User.findByLoginId(id)
    if (!user) {
      response.sendError(404)
    } else {
      [ user: user ]
    }
  }

  //@CachePut(value='userTimeline',key='#session.user.loginId')
  def personal() {
    def user = springSecurityService.currentUser
    render view: "timeline", model: [ user : user ]
  }

  def addPost(String content) {
    def user = springSecurityService.currentUser
    try {
      def newPost = postService.createPost(user.loginId, content)
      flash.message = "Added new post: ${newPost.content}"
    } catch (PostException pe) {
      flash.message = pe.message
    }

    redirect(action: 'timeline', id: user.loginId)
  }   

  //@CacheEvict(value='userTimeline',key='#session.user.loginId')
  //Todo: does not work right when used on the global timeline page properly
  def addPostAjax(String content) {
    def user = springSecurityService.currentUser
    try {
      def newPost = postService.createPost(user.loginId, content)
      def recentPosts = Post.findAllByUser(user,
        [sort: 'dateCreated', order: 'desc', max: 20])
      render template: 'postEntry', collection: recentPosts, var: 'post'
    } catch (PostException pe) {
      render {
        div(class: 'errors', pe.message)
      }
    }
  } 

  def tinyUrl(String fullUrl) {
    def origUrl = fullUrl?.encodeAsURL()
    def tinyUrl = 
      new URL("http://tinyurl.com/api-create.php?url=${origUrl}").text
    render(contentType:"application/json") {
      urls(small: tinyUrl, full:fullUrl)
    }
  }
}