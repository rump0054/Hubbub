package com.grailsinaction

import grails.transaction.Transactional

@Transactional
class PostService {

  Post createPost(String loginId, String content) {
    def user = User.findByLoginId(loginId)
    if (user) {
      def post = new Post(content: content)
      user.addToPosts(post)
      if (post.validate() && user.save()) {
        return post
      } else {
        throw new PostException(message: "Invalid or empty post",
          post: post)
      }
    }
    throw new PostException(message: "Invalid User Id")
  }
}

class PostException extends RuntimeException {
  String message
  Post post
}