Feature: Get All Comments

  @Comments @Todoist
  @Positive-Case
  Scenario: Get all comments should success then return 200 response code
    Given Get all comments with valid id path "2320066922"
    When Send get all comments
    Then Get all comment should return status code 200 OK
    And Get all comment response body contain "hello bre"
#    Examples:
#      | id         |
#      | 2319923744 |
