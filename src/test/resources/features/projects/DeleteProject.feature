Feature: Delete a Project

  @Project @Todoist
    @Positive-Case
    Scenario Outline: Delete a project with available ID path should success then return 204 response code
    Given Delete a project with available ID path "<id>"
    When Send delete a project
    Then Should return 204 No Content status code
    Examples:
      | id         |
      | 2319923692 |

  @Project @Todoist
    @Positive-Case
    Scenario Outline: Delete a project with unavailable ID path should fail then return 404 response code
    Given Delete a project with unavailable ID path "<id>"
    When Send delete a project
    Then Should return 404 Not Found status code
    Examples:
      | id          |
      | 23199236232 |