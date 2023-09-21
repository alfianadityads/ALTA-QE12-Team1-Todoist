Feature: Get All Comments

  @Comments @Todoist
  @Positive-Case
  Scenario: Get all comments should success then return 200 response code
    Given Get all comments with valid id path
    When Send get all comments
    Then Should return 200 OK status code
    And Response body string contain "Ousia"