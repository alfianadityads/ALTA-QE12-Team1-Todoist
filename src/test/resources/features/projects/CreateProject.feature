Feature: Create a New Project

  @Project @Todoist
    Scenario: Create new project with valid request body should success then return 200 response code
    Given Post create new project with valid request body "CreateProject.json"
    When Send post create a new project
    Then Should return 200 OK status code
    And Response body contain "Project 1"
    And Validate valid create a new project JSON schema "CreateProjectSchema.json"