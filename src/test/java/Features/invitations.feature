@Invitations @TaggedAgain
Feature: check Invitations flow

  Background:
    Given Browser is started and home page is opened


  Scenario: check Send Invitations flow
    Given login to web site
    And open My Account page
    And check that My Account page opens
    And open Invitations page
    And check that Invitations page opens
    Then click Send Invitations button
    And check that Send Invitations page opens
    Then enter email address
    Then enter message
    Then click Send Invitations button
    And check Invitation was sent
    Then check Invitation status should be Sent

  Scenario: check Registration with Invitations Reference Code flow
    And open Registration page
    And enter valid email and select Consumer Invitations  with 2 type and click join us button
    Then check that Step 2 registration page opens for <customerType>
    And enter additional details for Consumer Invitations  and click submit button
    Then check confirmation message appears
    And close confirmation pop up

  Scenario: check Invitation status changed
    Given login to web site
    And open My Account page
    And check that My Account page opens
    And open Invitations page
    And check that Invitations page opens
    Then check Invitation status should be Accepted