@Project
Feature: check Project feature

  Background:
    Given Browser is started and home page is opened


  Scenario: check Project can be created/deleted on My Projects page
    Given login to web site
    And open My Account page
    And check that My Account page opens
    And open My Projects page
    And check that My Projects page opens
    Then click + Create New Project button
    And check Create New Project pop up appears
    And click Cancel button
    And check Create New Project pop up disappears
    Then click + Create New Project button
    And check Create New Project pop up appears
    And enter Project Name New Test Project1
    And click Save button
    Then check new project created with name New Test Project1
    And open project New Test Project1
    Then check created project New Test Project1 page opens
    And click Delete link
    And check Confirmation pop up appears
    And click Delete button
    And check Delete pop up disappears
    Then check project with name New Test Project1 deleted

  @AddToProject
  Scenario: add products to Project and check they are displayed in the Project
    Given login to web site
    And open page for product Sinuosa Gold
    And check that product page opens for Sinuosa Gold
    And click Add to Project button
    Then check Save to Project pop up appears
    And enter Project Name Test Project
    And click Save button
    Then check The item Sinuosa Gold has been saved to Test Project pop up appears
    And continue shopping
    And open page for product Daisy
    And check that product page opens for Daisy
    And select product Daisy configuration
    And click Add to Project button
    Then check Save to Project pop up appears
    And select Project Name Test Project in drop down
    Then check The item Daisy has been saved to Test Project pop up appears
    And continue shopping
    And open My Account page
    And check that My Account page opens
    And open My Projects page
    And check that My Projects page opens
    And open project Test Project
    Then check created project Test Project page opens
    And check products Sinuosa Go1ld and Daisy is added to the project

