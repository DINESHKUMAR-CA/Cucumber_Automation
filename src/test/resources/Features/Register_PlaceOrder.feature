Feature: Placing order through Registering

  Scenario: Place Order Register before Checkout
  
    When The user clicks on Signup Login option
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
    And The user clicks on Products option in the homepage
    When The user hover over on first product and clicks on Add to cart
    Then Product added pop-up should pop-up and the user click on 'Continue Shopping'
    When The user clicks on cart option
    Then The cart page title should be 'Automation Exercise - Checkout'
    And The user clicks on Proceed To Checkout button in the cart page
    And The user should able to see the Delivey and Billing Address Details
    And The user enters description 'Terrific effort! Keep pushing forward' in comment text area and clicks Place Order
    And The user enters card Detail name as 'Lucas Muller' number as '6011000990099818' cvv as '371' expiry month and year as '01' and '2026'
    And The user clicks on Pay and Confirm order and 'Your order has been placed successfully!' should display after placing an order
    When The user clicks the 'Delete Account' option
    Then 'ACCOUNT DELETED!' mesaage should be visible
    And The user clicks the Continue button in Account Deleted page
