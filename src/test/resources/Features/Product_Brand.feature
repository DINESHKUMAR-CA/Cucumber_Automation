Feature: Product_Brand

Scenario: View & Cart Brand Products

And The user clicks on Products option in the homepage
When The user scrolls to Brands and selects BABYHUG
Then The page Title should be 'Automation Exercise - Babyhug Products'
And The user should see the products list
When The user clicks on KOOKIE KIDS brand
Then The user should land on KOOKIE KIDS PRODUCTS pages and the page title should be 'Automation Exercise - Kookie Kids Products'
And The user should see the products list