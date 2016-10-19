@PlaceOrder
Feature: check Place Order feature

  Background:
    Given Browser is started and home page is opened


  Scenario: check Order can be placed
    Given login to web site
    And open page for product Sin
    And check that product page opens for Sin
    And add product to cart
    Then check confirmation msg that product Sin added to cart
    And continue shopping
    And open page for product Daisy
    And check that product page opens for Daisy
    And select product Daisy configuration
    And add product to cart
    Then check confirmation msg that product Daisy added to cart
    And continue shopping
    And open page for product Yume
    And check that product page opens for Yume
    And select product Yume configuration
    And add product to cart
    Then check confirmation msg that product Yume added to cart
    And go to shopping cart
    Then check shopping cart page opens
    And click Checkout
    And check that Checkout page opens