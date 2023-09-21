Feature: Delete A Comment

  @Comments @Todoist
  @Positive-Case
  Scenario: Delete a comment should success then return 204 response code
    Given Delete a comment with available ID path "3368117912"
    When Send delete a comment
    Then Delete a comment should return 204 No Content status code