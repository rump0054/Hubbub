package com.grailsinaction



import spock.lang.*

/**
 *
 */
class UserIntegrationSpec extends Specification {

  def dumbster

    def "Saving our first user to the database"() {

      given: "A brand new user"
      def joe = new User(loginId: 'joe', password: 'secret')
                //homepage: 'http://www.google.com')

      when: "the user is saved"
      joe.save()

      then: "it saved successfully and can be found in the database"
      joe.errors.errorCount == 0
      joe.id != null
      User.get(joe.id).loginId == joe.loginId
    }

    def "Updating a saved user changes its properties"() {

      given: "An existing user"
      def existingUser = new User(loginId: 'joe', password: 'secret')
                //homepage: 'http://www.google.com')
      existingUser.save(failOnError: true)

      when: "A property is changed"
      def foundUser = User.get(existingUser.id)
      foundUser.password = 'sesame'
      foundUser.save(failOnError: true)

      then: "the change is reflected in the database"
      User.get(existingUser.id).password == 'sesame'
    }

    def "Deleting an existing user removes it from the databse"() {

      given: "An existing user"
      def user = new User(loginId: 'joe', password: 'secret')
                  //homepage: 'http://www.google.com')
      user.save(failOnError: true)

      when: "The user is deleted"
      def foundUser = User.get(user.id)
      foundUser.delete(flush: true)

      then: "The user is removed from the database"
      !User.exists(foundUser.id)
    }

    def "Saving a user with invalid properties causes an error"(){

      given: "A user which fails several field validations"
      def user = new User(loginId: 'joe', password: 'tiny')
                  //homepage: 'not-a-url')

      when: "The user is validated"
      user.validate()

      then: "The user has errors"
      user.hasErrors()
      !user.errors.getFieldError("loginId")
    }

    def "Recovering from a failed save by fixing invalid properties"() {

      given: "A user that has invalid properties"
      def chuck = new User(loginId: 'Chuck', password: 'tiny')
                  //homepage: 'not-a-url')
      assert chuck.save() == null
      assert chuck.hasErrors()

      when: "We fix the invalid properties"
      chuck.password = 'fistfist'
      //chuck.homepage = 'http://www.google.com'
      chuck.validate()

      then: "The user saves and validates fine"
      !chuck.hasErrors()
      chuck.save()
    }
    
    /* Removed test because Gmail won't do SMTP with this */
    /*def "Welcome email is generated and sent"() {

        given: "An empty inbox"
        dumbster.reset()

        and: "a user controller"
        def userController = new UserController()

        when: "A welcome email is sent"
        userController.welcomeEmail("tester@email.com")


        then: "It appears in their inbox"
        dumbster.messageCount == 1
        def msg = dumbster.getMessages().first()
        msg.subject ==  "Welcome to Hubbub!"
        msg.to == "tester@email.com"
        msg.body =~ /The Hubbub Team/

    }*/
}