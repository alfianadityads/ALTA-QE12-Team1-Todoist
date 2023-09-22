Feature: Create a New Project

  @Project @Todoist
    @Positive-Case
    Scenario: Create new project with valid request body should success then return 200 response code
    Given Post create new project with valid request body "CreateProject.json"
    When Send post create a new project
    Then Should return 200 OK status code
    And Response body contain "Project 1"
#    And Validate valid create a new project JSON schema "CreateProjectSchema.json"

  @Project @Todoist
    @Negative-Case
    Scenario: Create new project with blank name should fail then return 400 response code
    Given Post create new project with blank name request body "CreateProjectBlankName.json"
    When Send post create a new project
    Then Should return 400 Bad Request status code

  @Project @Todoist
    @Negative-Case
    Scenario: Create new project with name filled integer should fail then return 400 response code
    Given Post create new project with name filled integer request body "CreateProjectNameInt.json"
    When Send post create a new project
    Then Should return 400 Bad Request status code

  @Project @Todoist
    @Negative-Case
    Scenario: Create new project with name filled special char should fail then return 400 response code
    Given Post create new project with name filled special char request body "CreateProjectNameSpecialChar.json"
    When Send post create a new project
    Then Should return 400 Bad Request status code

  @Project @Todoist
    @Negative-Case
    Scenario: Create new project with blank request body should fail then return 400 response code
    Given Post create new project with blank request body "CreateProjectBlankReqBody.json"
    When Send post create a new project
    Then Should return 400 Bad Request status code