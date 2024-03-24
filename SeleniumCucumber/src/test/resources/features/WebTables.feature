Feature: Adding and editing the last web table record using XPath on DemoQA WebTables page

  Scenario: Successfully add and edit a record in the web table
    Given the user navigates to the DemoQA WebTables page
    When the user adds a new record with specific details
    And the user edits the last record with new details
    Then the editing should be successful
