@regression
Feature: Ebay Cart Functionality

  Scenario: Add product to cart using drop down options
		Given Open Ebay Homepage
		When Search for shirt
		And Select first shirt on item list
		And Select size
		And Select men size
		And Select shade
		And Shirt Quantity
		Then Add to shopping cart