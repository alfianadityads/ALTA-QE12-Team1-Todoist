Feature: Update A Comment

  @Comments @Todoist
  @Positive-Case
  Scenario: Update a comment should success then return 200 response code
    Given Update a comment with available ID path "3367948940" and filled request body "UpdateComment.json"
    When Send update a comment
    Then Update comment should return 200 OK status code
    And Update comment response body contain "3367948940"