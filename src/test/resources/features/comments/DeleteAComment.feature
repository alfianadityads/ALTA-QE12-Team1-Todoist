Feature: Delete A Comment

  @Comments @Todoist
  @Positive-Case
  Scenario: Delete a comment should success then return 204 response code
    Given Delete a comment with available ID path "3368117912"
    When Send delete a comment
    Then Delete a comment should return status code 204 No Content

  @Comments @Todoist
  @Negative-Case
  Scenario: Delete a comment with unavailable ID path should fail then return 204 response code
    Given Delete a comment with unavailable ID path "3368117111"
    When Send delete a comment
    Then Delete a comment should return status code 204 No Content

  @Comments @Todoist
  @Negative-Case
  Scenario: Delete a comment with blank ID path should fail then return 204 response code
    Given Delete a comment with blank ID path ""
    When Send delete a comment
    Then Delete a comment should return status code 400 Bad Request

  @Comments @Todoist
  @Negative-Case
  Scenario Outline: Delete a comment with ID path filled by string should fail then return 400 response code
    Given Delete a comment with ID path string "<id>"
    When Send delete a comment
    Then Delete a comment should return status code 204 No Content
    Examples:
      | id   |
      | link |

  @Comments @Todoist
    @Negative-Case
  Scenario Outline: Delete a comment with ID path filled by special char should fail then return 400 response code
    Given Delete a comment with ID path special char "<id>"
    When Send delete a comment
    Then Delete a comment should return status code 204 No Content
    Examples:
      | id   |
      | !@#$ |

