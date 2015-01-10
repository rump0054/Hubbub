package com.grailsinaction

import grails.test.mixin.TestFor
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(DateTagLib)
class DateTagLibSpec extends Specification {
  @Unroll
  void "Conversion of #testName matches #expectedNiceDate"() {
    // The last two tests fail on days when the clocks go backwards
    // or forwards!

    expect:
    applyTemplate('<hub:dateFromNow date="${date}" />',
                  [date: testDate]) == expectedNiceDate

    where:
    testName       |    testDate      |   expectedNiceDate
    "Current Time" | new Date()       | "Right now"
    "Now - 1 day"  | new Date() - 1   | "1 day ago"
    "Now - 2 days" | new Date() - 2   | "2 days ago"
  }
}