Feature: Update A Comment

  @Comments @Todoist
  @Positive-Case
  Scenario: Update a comment should success then return 200 response code
    Given Update a comment with available ID path "3367948940" and filled request body "UpdateComment.json"
    When Send update a comment
    Then Update comment should return 200 OK status code
    And Update comment response body contain "3367948940"

  @Comments @Todoist
  @Negative-Case
  Scenario: Update a comment with available ID path and filled by integer value should fail then return 400 response code
    Given Update a comment with available ID path "3367948940" and filled by integer value "UpdateCommentAvailableIdAndInteger.json"
    When Send update a comment
    Then Update comment should return status code 400 Bad Request

  @Comments @Todoist
  @Negative-Case
  Scenario: Update a comment with unavailable ID path and filled by integer value should fail then return 400 response code
    Given Update a comment with unavailable ID path "336794894000" and filled by integer value "UpdateCommentAvailableIdAndInteger.json"
    When Send update a comment
    Then Update comment should return status code 400 Bad Request

  @Comments @Todoist
  @Negative-Case
  Scenario: Update a comment with available ID path and filled by special char value should fail then return 400 response code
    Given Update a comment with available ID path "3367948940" and filled by special char value "UpdateCommentAvailableIdAndInteger.json"
    When Send update a comment
    Then Update comment should return status code 400 Bad Request

  @Comments @Todoist
  @Negative-Case
  Scenario: Update a comment with unavailable ID path and filled by special char value should fail then return 400 response code
    Given Update a comment with unavailable ID path "336794894000" and filled by special char value "UpdateCommentAvailableIdAndInteger.json"
    When Send update a comment
    Then Update comment should return status code 400 Bad Request


