Feature: Get a Project

  @Project @Todoist
    @Positive-Case
    Scenario Outline: Get a project with available ID path should success then return 200 response code
    Given Get a project with available path ID "2319923692"
    When Send get a project
    Then Should return 200 OK status code
    And Response get a project body contain as available id path "<id>"
    Examples:
      | id         |
      | 2319923692 |
#    And Validate valid get a project JSON schema "GetAProjectSchema.json"

  @Project @Todoist
    @Negative-Case
    Scenario Outline: Get a project with unavailable ID path should fail then return 404 response code
    Given Get a project with unavailable path ID "<id>"
    When Send get a project
    Then Should return 404 Not Found status code
    Examples:
      | id          |
      | 23199236232 |


  @Project @Todoist
    @Negative-Case
    Scenario Outline: Get a project with ID path filled by string should fail then return 404 response code
    Given Get a project with ID path filled by string "<id>"
    When Send get a project
    Then Should return 404 Not Found status code
    Examples:
        | id           |
        | asfjkewknsaf |

  @Project @Todoist
    @Negative-Case
    Scenario Outline: Get a project with ID path filled by special char should fail then return 400 response code
    Given Get a project with ID path filled by special char "<id>"
    When Send get a project
    Then Should return 404 Not Found status code
    Examples:
      | id       |
      | #^!^%^&! |

  @Project @Todoist
    @Negative-Case
    Scenario Outline: Get a project with blank ID should fail then return 400 response code
    Given Get a project with blank ID path "<id>"
    When Send get a project
    Then Should return 404 Not Found status code
    Examples:
      | id |
      |    |