Feature: Search and Place the order for products

Scenario: Search Experiencie for product search in both home page
Given User is on GreenCart Landing page
When user searched with Shortname "To" abnd extract actual name of prodcut
Then user search for "To" shortname in offers page
And Validate product name in offers page matches with Landing Page