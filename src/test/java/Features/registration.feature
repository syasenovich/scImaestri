@Registration @TaggedAgain
Feature: check Registration for all customer types

  Background:
    Given Browser is started and home page is opened

  @Consumer
  Scenario Outline: check Consumer registration
    And open Registration page
    And enter valid email and select <customerType>  with <index> type and click join us button
    Then check that Step 2 registration page opens for <customerType>
    And enter additional details for <customerType>  and click submit button
    Then check confirmation message appears
    And close confirmation pop up

  Examples:
    |customerType         |index|
    |Consumer              |2   |
  #  |Business              |3   |
  #  |Design Trade|1             |
