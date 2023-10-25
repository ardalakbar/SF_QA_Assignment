@ContactUs
Feature: ContactUs

  @Ardal
  Scenario: Happy Path
    Given user is on the Contact us page
    When user enters first name - "John"
    And user enters last name - "Smith"
    And user enters email - "abc123@email.com"
    And user enters comments - "Hello world!"
    And user click on submit button
    Then user should be on Thank you page

  @Ardal
  Scenario Outline: Unhappy Path
    Given user is on the Contact us page
    When user enters first name - "John"
    And user enters last name - "Smith"
    And user enters email - "<email>"
    And user enters comments - "Hello world!"
    And user click on submit button
    Then user should see "<error>" messages

    Examples: 
      | email       | error                                                       |
      |             | Error: Invalid email address,Error: all fields are required |
      | abc123      | Error: Invalid email address                                |
      | abc@        | Error: Invalid email address                                |
      | abc123@.com | Error: Invalid email address                                |
      | @ abc123com | Error: Invalid email address                                |
