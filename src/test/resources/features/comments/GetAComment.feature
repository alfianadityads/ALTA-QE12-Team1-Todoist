Feature: Get A Comment

@Comments @Todoist
@Positive-Case
Scenario: Get a comment should success then return 200 response code
  Given Get a comment with available path ID "3367948940"
  When Send get a comment
  Then Get comment should return 200 OK status code
  And Get comment response body contain "3367948940"