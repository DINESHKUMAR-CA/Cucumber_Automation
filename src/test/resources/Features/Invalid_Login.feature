Feature: Logging into website with invalid crendentials

  Scenario: Login User with incorrect email and password
  
    Then 'Login to your account' should be visible in Login page
    And The user enters the Email as "scott.lucas@maildfence.com" and password as "it'swrongpassword"
    And The user clicks on Login button
    Then 'Your email or password is incorrect!' error message should be visible 
