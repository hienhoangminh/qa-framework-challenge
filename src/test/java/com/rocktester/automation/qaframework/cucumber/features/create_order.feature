Feature: Create order

  @order @api
  Scenario: Shipper create an order via API
    Given shipper authenticate to Ninja Van system
    Then QA verifies that the HTTP response code is 200
    When shipper retrieves its access token
    And shipper send order create request
    And shipper provides the access token in the request header
    Then QA verifies that the HTTP response code is 200
    And QA verifies that the HTTP response body is {"status": "OK"}