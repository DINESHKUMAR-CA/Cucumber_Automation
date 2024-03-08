Feature: Product Quantity

Scenario: Verify Product quantity in Cart

When The user clicks on 'View Product' of the first product under FEATURES ITEMS
Then The user should be landed to the product detail page
And The user is increasing the product quantity to '4'
And The user clicks on Add To Cart button and clicks on view cart link in the pop-up
Then The user should land on cart page and able to view the product with exact quantity
