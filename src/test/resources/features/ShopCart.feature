@ui
Feature: Prestashop. Cart feature

  Background:
    Given user open PrestaShop main page from any browser

  Scenario: Add to cart button is displayed
    When user clicks random item on PrestaShop main Page
    Then checks that "Buy" button is "not displayed" on Item Page
    Then checks that "Add to cart" button is "displayed" on Item Page

  Scenario: User can add multiple items to cart
    Then user sees "(0)" items in cart on PrestaShop main Page
    When user clicks random item on PrestaShop main Page
    And user clicks "Add to cart" button on Item Page
    Then user sees message "Product successfully added to your shopping cart" on Item pop up Page
    Then user sees "(1)" items in cart on PrestaShop main Page
    When user open previous page in browser
    And user clicks random item on PrestaShop main Page
    And user clicks "Add to cart" button on Item Page
    Then user sees message "Product successfully added to your shopping cart" on Item pop up Page
    Then user sees "(2)" items in cart on PrestaShop main Page
    When user clicks Cart icon on PrestaShop main Page
    Then user sees added products on Cart Page

  Scenario: User can place order from cart
    When user clicks random item on PrestaShop main Page
    And user clicks "Add to cart" button on Item Page
    And user clicks 'PROCEED TO CHECKOUT' button on Item pop up Page
    And user clicks 'PROCEED TO CHECKOUT' button on Cart Page
    Then user sees "Personal information" section title on Order Page
