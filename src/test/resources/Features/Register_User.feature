Feature: Register User

  Scenario: Register a new user
  	
  	When The user clicks on Signup Login option
    Then 'New User Signup!' should be visible
    And The user enters the name as "Lucas Scott" and email address as "scott.lucas@maildfence.com"
    And The user clicks the 'Signup' button
    Then 'ENTER ACCOUNT INFORMATION' should be visible on the page
    And The user selects Tittle as Mr
    And The user provide the password as "IiThMaPbIiS1!"
    And The user selects the Date of Birth
    Then The user selects the 'Sign up for our newsletter!' and 'Receive special offers from our partners!'checkboxs
    And The user provides the first name as "Lucas" and last name as "Scott" and company as "Lockheed Martin"
    And The user provides the address as "1355 Sage Creek Drive, Springfield" Selects the country and enters the mobile number as '61101-1102'
    And The user provides the state as "Illinois" and "Rockford" as city and "Il62RF02" as zipcode
    And The user clicks on 'Create Account' button
    Then 'ACCOUNT CREATED!' message should be visible to user
    When The user clicks 'Continue' button
    Then 'Logged in as Lucas Scott' should be visible in the homepage
    When The user clicks the 'Delete Account' option
    Then 'ACCOUNT DELETED!' mesaage should be visible
    And The user clicks the Continue button in Account Deleted page
