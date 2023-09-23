Feature: Update A Sections

  @Project @Todoist
    @Positive-Case
    Scenario: Update a section with available ID path and valid request body should success then return 200 response code
    Given Post update a section with available ID path "134852766" and filled request body "UpdateASection.json"
    When Send post update a section
    Then Should return 200 OK status code
    And Update section response body contain "Section 1"

  @Project @Todoist
    @Negative-Case
    Scenario: Update a section with unavailable ID path and valid request body should fail then return 404 response code
    Given Post update a section with unavailable ID path "" and valid request body "UpdateSectionInvalidId.json"
    When Send post update a section
    Then Should return 404 No Content status code

  @Project @Todoist
    @Negative-Case
    Scenario: Update a section with available ID path and invalid request body should fail then return 400 response code
    Given Post  update a section with available ID path "134852766" and invalid request body "UpdateSectionInvalidReBody.json"
    When Send post update a section
    Then Should return 400 Bad Request status code

  @Project@Todoist
    @Negative-Case
    Scenario: Update a section with available ID path and blank request body should fail then return 400 response code
    Given Post update a section with available ID path "134852766" and blank request body "UpdateSectionBlankReqBody.json"
    When Send post update a section
    Then Should return 400 Bad Request status code