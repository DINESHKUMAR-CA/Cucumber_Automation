Feature: Search Product On The Products Page

  Scenario: Search Product
  
    And The user clicks on Products option in the homepage
    Then The user should be navigated to the ALL PRODUCTS page and the page title should be 'Automation Exercise - All Products'
    And The user enters 'Cotton Mull Embroidered Dress' in the search box
    And The user clicks on search icon
    Then The searched product 'Cotton Mull Embroidered Dress' should be visible
    And The user clears the searchbox and searches with 'T-Shirt'
    And The user clicks on search icon
    Then All the products related to T-shirt should be visible
    
		