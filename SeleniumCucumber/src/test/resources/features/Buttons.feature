Feature: Clicking the third button using XPath on DemoQA Buttons page

  Scenario: Successfully click the third button and verify the message
    Given the user navigates to the DemoQA Buttons page
    When the user clicks on the third button
    Then the user should see a confirmation message indicating the click
