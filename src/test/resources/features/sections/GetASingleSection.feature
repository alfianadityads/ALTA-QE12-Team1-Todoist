Feature: Get A Single Projects

  @Project @Todoist
  @Positive-Case
  Scenario: get a single section  should success then return 200 response code
    Given get a single section "134889260"
    When Send get a single sections
    Then Should return 200 OK status code
    And Section Response body contain "134889260"
#    And Validate valid get a single sections JSON schema "GetASingleSectionSchema.json"