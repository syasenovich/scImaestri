
Feature: check Makers page

  Background:
    Given Browser is started and home page is opened

  @PreviewMakers
  Scenario: check All Makers detail pages and check page is opened and product titles are displayed
    And open "Preview Makers" page
    And check that "Makers" page opens
    Then open All Makers detail pages and check page is opened and product titles are displayed

  @LoggedMakers
  Scenario: check All Makers detail pages opens for logged in user
    Given login to web site
    And open "Makers" page
    And check that "Makers" page opens
    When check that All Makers detail pages opens