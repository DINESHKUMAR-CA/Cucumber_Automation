Feature: Product Category

Scenario: View Category Products

Then The user scrolls to CATEGORY section
When The user clicks on WOMEN under CATEGORY section and select SAREE
Then The user should navigate to category page and able to see 'WOMEN - SAREE PRODUCTS'
And The user clicks on MEN under CATEGORY section and select Tshirt
Then The user should be navigate to sub category page and able to see 'MEN - TSHIRTS PRODUCTS' 


