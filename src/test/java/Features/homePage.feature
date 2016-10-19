@HomePage
Feature: check Homepage elements

  Background:
    Given Browser is started and home page is opened


  Scenario: check Header
    Then check Header for Homepage and open each link
    Then check Footer for Homepage