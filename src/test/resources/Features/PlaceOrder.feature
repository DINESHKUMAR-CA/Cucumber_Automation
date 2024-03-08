Feature: Placing an Order

  Scenario: Place Order Register while Checkout
  
    When The user clicks on 'View Product' of the first product under FEATURES ITEMS
    Then The user should be landed to the product detail page
    And The user clicks on Add To Cart button and clicks on view cart link in the pop-up
    And The user clicks on Proceed To Checkout button in the cart page
    Then The user clicks on Register_Login link on checkout pop-up
    And The user enters the name as "Lucas Scott" and email address as "scott.lucas@maildfence.com"
    And The user clicks the 'Signup' button
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
    When The user clicks on cart option
    And The user clicks on Proceed To Checkout button in the cart page
    And The user should able to see the Delivey and Billing Address Details
    Then The user should able to see both the products along with prices, quantity and total price
    And The user enters description 'Terrific effort! Keep pushing forward' in comment text area and clicks Place Order
    And The user enters card Detail name as 'Lucas Muller' number as '6011000990099818' cvv as '371' expiry month and year as '01' and '2026'
    And The user clicks on Pay and Confirm order and 'Your order has been placed successfully!' should display after placing an order
    When The user clicks the 'Delete Account' option
    Then 'ACCOUNT DELETED!' mesaage should be visible
    And The user clicks the Continue button in Account Deleted page


