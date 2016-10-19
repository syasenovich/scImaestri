@TaggedAgain
Feature: check pagination

  Background:
    Given Browser is started and home page is opened


  Scenario Outline: check pagination for Makers and Designers
    Given login to web site
    And open <sitePage> page
    When User clicks <pageNumber> page on current page
    And Spinner should be displayed
    And wait until spinner disappears
    Then check <pageNumber> page is opened
    When User clicks <pageNumberPrev> page on current page
    And Spinner should be displayed
    And wait until spinner disappears
    Then check <pageNumberPrev> page is opened


  Examples:
    |sitePage             |pageNumber|pageNumberPrev|
    |Seating              |3         |1             |
    |Outdoor              |2         |1             |
    |Office Tables & Desks|2         |1             |
    |Makers               |2         |1             |
    |Designers            |2         |1             |

