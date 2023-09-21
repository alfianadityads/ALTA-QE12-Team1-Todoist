Feature: Get All Projects

  @Project @Todoist
    @Positive-Case
    Scenario: Get all projects should success then return 200 response code
    Given Get all projects with valid path
    When Send get all projects
    Then Should return 200 OK status code
    And Response body array contain "Project 1"
#    And Validate valid get all projects JSON schema "GetAllProjectSchema.json"