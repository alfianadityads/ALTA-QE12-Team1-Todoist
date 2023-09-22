Feature: Create a New Comment

  @Comments @Todoist
  @Positive-Case
  Scenario: Create new comment with valid request body should success then return 200 response code
    Given Post create new comment with valid request body "CreateANewComment.json"
    When Send post create a new comment
    Then Should return status code 200 OK
    And Create new comment response body contain "2320066922"