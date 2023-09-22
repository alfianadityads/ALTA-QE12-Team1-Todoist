Feature: Get All Comments

  @Comments @Todoist
  @Positive-Case
  Scenario: Get all comments should success then return 200 response code
    Given Get all comments with valid id path "2320066922"
    When Send get all comments
    Then Get all comment should return status code 200 OK
    And Get all comment response body contain "hello bre"

  @Comments @Todoist
  @Negative-Case
  Scenario: Get all comments with invalid ID path should return 400 response codee
    Given Get all comment with invalid id path "2320066922aa"
    When Send get all comments
    Then Get all comments should return status code 400 Bad Request
    And Get all comment response body contain "hello bre"

  @Comments @Todoist
  @Negative-Case
  Scenario: Get all comments with blank ID path should return 400 response codee
    Given Get all comment with blank id path " "
    When Send get all comments
    Then Get all comments should return status code 400 Bad Request
    And Get all comment response body contain "hello bre"
