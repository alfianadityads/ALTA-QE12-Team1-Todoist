Feature: Update a Project

  @Project @Todoist
    @Positive-Case
    Scenario: Update a project with available ID path and valid request body should success then return 200 response code
    Given Get a project with available ID path and valid request body "UpdateValidProject.json"
    When Send update a project
    Then Should return 200 OK status code
    And Response body contain "hello"
#    And Validate valid update a project JSON schema "UpdateProjectSchema.json"

  @Project @Todoist
    @Negative-Case
    Scenario Outline: Update a project with unavailable ID path and valid request body should fail then return 404 response code
    Given Get a project with unavailable ID path "<id>" and valid request body "UpdateValidProject.json"
    When Send update a project
    Then Should return 404 Not Found status code
    Examples:
      | id          |
      | 23199236232 |