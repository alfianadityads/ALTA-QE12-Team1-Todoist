Feature: Delete A Sections

  @Project @Todoist
    @Positive-Case
    Scenario: Delete a section with available ID path should success then return 204 response code
    Given Delete delete a section with available ID path "134852766"
    When Send delete delete a section
    Then Delete section should return 204 No Content status code

  @Project @Todoist
    @Negative-Case
    Scenario: Delete a section with unavailable ID path should fail then return 404 response code
    Given Delete delete a section with unavailable ID path "1234321"
    When Send delete delete a section
    Then Delete section should return 404 Not Found status code

  @Project @Todoist
    @Negative-Case
    Scenario: Delete a section with ID path filled by string should fail then return 400 response code
    Given Delete delete a section with ID path filled by string "asdfghjkl"
    When Send delete delete a section
    Then Delete section should return 400 Bad Request status code

  @Project @Todoist
    @Negative-Case
    Scenario: delete a section with ID path filled by special char should fail then return 400 response code
    Given Delete delete a section with ID path filled by special char "@#$%^&*"
    When Send delete delete a section
    Then Delete section should return 400 Bad Request status code

  @Project @Todoist
    @Negative-Case
    Scenario: delete a section with blank ID path should fail then return 400 response code
    Given Delete delete a section with blank ID path ""
    When Send delete delete a section
    Then Delete section should return 400 Bad Request status code