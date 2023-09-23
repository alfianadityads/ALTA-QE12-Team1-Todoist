Feature: Delete a Project

  @Project @Todoist
    @Positive-Case
    Scenario: Delete a project with available ID path should success then return 204 response code
    Given Delete a project with available ID path "2319923692"
    When Send delete a project
    Then Should return 204 No Content status code

  @Project @Todoist
    @Positive-Case
    Scenario: Delete a project with unavailable ID path should fail then return 404 response code
    Given Delete a project with unavailable ID path "23199236232"
    When Send delete a project
    Then Should return 404 Not Found status code

  @Project @Todoist
    @Positive-Case
    Scenario: Delete a project with ID path filled by string should fail then return 400 response code
    Given Delete a project with ID path filled by string "dfqwrerrq"
    When Send delete a project
    Then Should return 400 Bad Request status code

  @Project @Todoist
    @Positive-Case
    Scenario: Delete a project with ID path filled by special char should fail then return 400 response code
    Given Delete a project with ID path filled by special char "#^!^%^&!"
    When Send delete a project
    Then Should return 400 Bad Request status code

  @Project @Todoist
    @Positive-Case
    Scenario: Delete a project with blank ID path should fail then return 405 response code
    Given Delete a project with blank ID path ""
    When Send delete a project
    Then Should return 400 Bad Request status code