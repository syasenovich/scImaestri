@Designers
Feature: check Makers page

  Background:
    Given Browser is started and home page is opened


  Scenario: check All Designers detail pages opens for logged in user
    Given login to web site
    And open "Designers" page
    And check that Designers page opens
    Then check that All Designers detail pages opens