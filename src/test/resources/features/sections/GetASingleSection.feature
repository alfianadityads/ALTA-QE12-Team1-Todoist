Feature: Get A Single Projects

  @Project @Todoist
  @Positive-Case
  Scenario: get a single scetion  should success then return 200 response code
    Given get a single section "134852766"
    When Send get a single sections
    Then Should return 200 OK status code
    And Response body contain "Section 1"
    And Validate valid get a single sections JSON schema "GetASingleSectionSchema.json"