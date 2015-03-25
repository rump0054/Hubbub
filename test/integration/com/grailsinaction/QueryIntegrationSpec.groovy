package com.grailsinaction

import spock.lang.*

class QueryIntegrationSpec extends Specification {

    void "Query on association"() {
        when: "The 'following' collection is queried"
        def users = User.where {
            following.loginId == "sara"
        }.list(sort: "loginId")

        then: "A list of the followers of the given user is returned"
        users*.loginId == ["phil"] 
    }

    void "Query against a range value"() {
        given: "The current date & time"
        def now = new Date()

        when: "The 'dateCreated' property is queried"
        def users = User.where {
            dateCreated in (now - 1)..now
        }.list(sort: "loginId", order: "desc")

        then: "The users created within the specified date range are returned"
        users*.loginId == ["phil", "peter", "glen", "frankie", "chuck_norris", "admin"]
    }

    void "Retrieve a single instance"() {
        when: "A specific user is queried with get()"
        def user = User.where {
            loginId == "phil"
        }.get()

        then: "A single instance is returned"
        user.loginId == "phil"
    }
}
