Feature: Cart Functionality

  Scenario: Verify Subscription in Cart page
    
    When The user clicks on cart option
    And The user scroll down to the footer
    Then The user should able to view the 'SUBSCRIPTION'
    And The user enters their email 'fabian.lehmann@tuta.com' and clicks the right arrow button
    Then The success message 'You have been successfully subscribed!' should be visible
