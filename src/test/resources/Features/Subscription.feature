Feature: Subscription Feature

  Scenario: Verify Subscription in home page
  
    When The user scroll down to the footer
    Then The user should able to view the 'SUBSCRIPTION'
    And The user enters their email 'fabian.lehmann@tuta.com' and clicks the right arrow button
    Then The success message 'You have been successfully subscribed!' should be visible
