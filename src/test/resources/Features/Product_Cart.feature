Feature: Add to cart

  Scenario: Add Products in Cart
  
    And The user clicks on Products option in the homepage
    When The user hover over on first product and clicks on Add to cart
    Then Product added pop-up should pop-up and the user click on 'Continue Shopping'
    And The user hover over on second product and clicks on Add to cart
    Then Product added pop-up should pop-up and the user click on 'Continue Shopping'
    And The user clicks on cart option
    Then The user should able to see both the products along with prices, quantity and total price
    
    
