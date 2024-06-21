

@Test_SimpliLearn_Project
Feature: Test Cart Page
  This feature file is about the testing of Cart Page

  @Funcational_Test_CartPage
  Scenario: Test the AddToCart Page
    Given The application URL
    And Navigate to Cart Page
    When Click on CheckOutButton
    And Navigate to Checkout Page
    And Enter Billing Details
    When Click on PlaceOrder
    Then Check whether order is placed



