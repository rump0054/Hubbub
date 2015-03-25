package com.grailsinaction

class AuthController {

    def form(String id) {
      [ loginId: id ]
    }

    def signIn(String loginId, String password) {
      def user = User.findByLoginId(loginId)
      if (user && user.password == password) {
        // This loses the original request
        session.user = user
        redirect uri: '/'
      } else {
        flash.error = "An error occured.  Please try again"
        redirect action: form
      }
    }
}
