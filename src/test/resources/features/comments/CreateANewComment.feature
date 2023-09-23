Feature: Create a New Comment

  @Comments @Todoist
  @Positive-Case
  Scenario: Create new comment with valid request body should success then return 200 response code
    Given Post create new comment with valid request body "CreateANewComment.json"
    When Send post create a new comment
    Then Should return status code 200 OK
    And Create new comment response body contain "2320066922"


  @Comments @Todoist
  @Negative-Case
  Scenario: Create a new comment with blank id should fail then return 400 response code
    Given Post create new comment with blank id request body "CreateANewCommentBlankId.json"
    When Send post create a new comment
    Then Create new comment should return status code 400 Bad Request

  @Comments @Todoist
  @Negative-Case
  Scenario: Create a new comment with content filled integer should fail then return 400 response code
    Given Post create new comment with content filled integer request body "CreateANewCommentInteger.json"
    When Send post create a new comment
    Then Create new comment should return status code 400 Bad Request

  @Comments @Todoist
  @Negative-Case
  Scenario: Create a new comment with content filled special char should fail then return 400 response code
    Given Post create new comment with content filled special char request body "CreateANewCommentSpecialChar"
    When Send post create a new comment
    Then  Create new comment should return status code 400 Bad Request

  @Comments @Todoist
  @Negative-Case
  Scenario: Create a new comment with blank request body should fail then return 400 response code
    Given Post create new comment with blank request body "CreateANewCommentBlankContent.json"
    When Send post create a new comment
    Then  Create new comment should return status code 400 Bad Request