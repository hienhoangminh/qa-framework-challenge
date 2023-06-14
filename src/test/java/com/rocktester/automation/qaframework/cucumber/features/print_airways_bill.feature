Feature: Print airway bill

  @bill @ui
  Scenario Outline: Shipper print airway bill from their dashboard
    Given shipper opens Ninja dashboard login page
    When shipper login by using credentials "<email>" and "<password>"
    Then shipper arrives at landing page
    When shipper goes to the tracking page
    And shipper clicks on Search button
    And shipper selects the first tracking ID in the table
    Then QA verify that Order details page is shown
    When shipper clicks Print Airway Bill button
    And shipper selects 1 bills per page in Print Airway Bills dialog
    And shipper clicks Print button in Print Airways Bills dialog
    Then QA verify that the tracking ID text in the PDF file is correct
    Examples:
      | email                  | password     |
      | challenge2@ninjavan.co | Ninjavan1234 |