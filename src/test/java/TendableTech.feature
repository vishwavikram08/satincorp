Feature: Tendable Tech
  Registered user should be able to navigate through the various functionality of the tendable tech website

  Scenario: User should be a valid user to use the tendable tech website features
    Given user launches the Tendable tech URL on compatible browser
    When user navigates through the top level menus and request a demo button is present and active
    And user clicks the Contact us button
    And user click on the Marketing option
    Then user fills up the form excluding the Message field and confirms the error message after submission