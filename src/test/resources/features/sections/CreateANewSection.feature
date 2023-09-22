Feature: Create a New Sections

  @Project @Todoist
    @Positive-Case
    Scenario: Create a new section with valid request body should success then return 200 response code
    Given Post create new section with valid request body "CreateANewSection.json"
    When Send post create a new section
    Then Should return 200 OK status code
    And Response body contain "Section 1"

  @Project @Todoist
    @Negative-Case
    Scenario: Create a new section with valid name and invalid project id should fail then return 400 response code
    Given Post create a new section with valid name and invalid project id "CreateSectionInvalidId.json"
    When Send post create a new section
    Then Should return 400 Bad Request status code

  @Project @Todoist
    @Negative-Case
    Scenario: Create a new section with blank name and valid project id filled integer should fail then return 400 response code
    Given Post create a new section with blank name and valid project id filled integer "CreateSectionBlankName.json"
    When Send post create a new section
    Then Should return 400 Bad Request status code

  @Project @Todoist
    @Negative-Case
    Scenario: Create a new section with name filled special char and valid project id should fail then return 400 response code
    Given Post create a new section with name filled special char and valid project id "CreateSectionNameSpecialChar.json"
    When Send post create a new section
    Then Should return 400 Bad Request status code

@Project @Todoist
  @Negative-Case
  Scenario: Create a new section with blank request body should fail then return 400 response code
  Given Post  create a new section with blank request "CreateSectionBlankReqBody.json"
  When Send post create a new section
  Then Should return 400 Bad Request status code