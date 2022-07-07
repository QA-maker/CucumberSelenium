Feature: Search and Place the order for products

Scenario: Search Experiencie for product searxh in both home page

Given User is on GreenCart Landing page
When user searched with Shortname "Tom" abnd extract actual name of prodcut
Then user search for "Tom" shortname in offers page to check if product exist with same name