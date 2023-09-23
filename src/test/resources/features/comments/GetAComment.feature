Feature: Get A Comment

@Comments @Todoist
@Positive-Case
Scenario: Get a comment should success then return 200 response code
  Given Get a comment with available path ID "3367948940"
  When Send get a comment
  Then Get comment should return 200 OK status code
  And Get comment response body contain "3367948940"


@Comments @Todoist
@Negative-Case
Scenario: Get a comment with invalid ID path should fail then return 404 response code
  Given Get a comment with unavailable path ID "123123"
  When Send get a comment
  Then Get comment should return status code 404 Not Found

@Comments @Todoist
@Negative-Case
Scenario: Get a comment with blank ID path should fail then return 400 response code
  Given Get a comment with blank path ID ""
  When Send get a comment
  Then Get a comment should return status code 400 Bad Request

  @Comments @Todoist
  @Negative-Case
  Scenario Outline: Get a comment with ID path filled by special char should fail then return 404 response code
    Given Get a comment with ith ID path filled by special char "<id>"
    When Send get a comment
    Then Get a comment should return status code 404 Not Found
    Examples:
      | id   |
      | !@#$ |

  @Comments @Todoist
    @Negative-Case
  Scenario Outline: Get a comment with ID path filled by integer should fail then return 404 response code
    Given Get a comment with ith ID path filled by integer "<id>"
    When Send get a comment
    Then Get a comment should return status code 404 Not Found
    Examples:
      | id   |
      | 1234 |