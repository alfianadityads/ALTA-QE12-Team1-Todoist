Feature: Get A Single Projects

  @Project @Todoist
  @Positive-Case
  Scenario: get a single scetion  should success then return 200 response code
    Given get a single scetion
    When Send get a single sections
    Then Should return 200 OK status code
    And Response body contain "Tia"
    And Validate valid get a single sections JSON schema "GetASingleSectionSchema.json"