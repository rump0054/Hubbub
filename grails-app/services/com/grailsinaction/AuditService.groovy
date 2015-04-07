package com.grailsinaction

class AuditService {
  static transactional = false

  @grails.events.Listener
	def onNewPost(Post newPost) {
    log.error "New Post from: ${newPost.user.loginId} : ${newPost.shortContent}"
	}
}
