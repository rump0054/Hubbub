package com.grailsinaction

class PostController {
  static defaultAction = 'home'
  static scaffold = true

  static navigation = [
    [group:'tabs', action: 'personal', title: 'My Timeline', order: 0],
    [action: 'global', title: 'Global Timeline', order: 1]
  ]

  def postService

  def home() {
    if (!params.id) {
      params.id = "chuck_norris"
    }

    redirect(action: 'timeline', params: params)
  }

  def global() {
    [ posts: Post.list(params), postCount: Post.count() ]
  }

  def timeline(String id) {
    def user = User.findByLoginId(id)
    if (!user) {
      response.sendError(404)
    } else {
      [ user: user ]
    }
  }

  def personal() {
    if (!session.user) {
        redirect controller: "login", action: "form"
        return
    } else {
        // Need to reattach the user domain object to the session using
        // the refresh() method.
        render view: "timeline", model: [ user : session.user.refresh() ]
    }
  }

  def addPost(String id, String content) {
    try {
      def newPost = postService.createPost(id, content)
      flash.message = "Added new post: ${newPost.content}"
    } catch (PostException pe) {
      flash.message = pe.message
    }

    redirect(action: 'timeline', id: id)
  }    
}