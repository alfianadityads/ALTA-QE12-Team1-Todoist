Feature: Get a Project

  @Project @Todoist
    @Positive-Case
    Scenario: Get a project with available ID path should success then return 200 response code
    Given Get a project with available path ID
    When Send get a project
    Then Should return 200 OK status code
    And Response get a project body contain as available id path
    And Validate valid get a project JSON schema "GetAProjectSchema.json"
