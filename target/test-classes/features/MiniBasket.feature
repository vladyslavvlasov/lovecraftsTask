Feature: MiniBasket
  In order to review my current basket content
  As a customer I want to have an interface accessible on the whole site
  So it helps me plan my purchase


  Scenario: Customer has a last added product to basket in the minibasket view
    Given I am on "/paintbox-yarns-simply-aran"
    When I add 2 "Sky Blue" yarns to my basket
    Then I can see "Paintbox Yarns Simply Aran - Sky Blue" yarn in the minibasket
    When I use minibasket to follow to the basket page
    Then I can see "Paintbox Yarns Simply Aran - Sky Blue" on the basket page