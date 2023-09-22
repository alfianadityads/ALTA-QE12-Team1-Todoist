Feature: Get All Sections

  @Project @Todoist
  @Positive-Case
  Scenario: Get all sections should success then return 200 response code
    Given Get all sections with valid id path "2320066922"
    When Send get all sections
    Then Should return 200 OK status code
    And Response body array contain "Section 1"
    And Validate valid get all sections JSON schema "GetAllSectionSchema.json"