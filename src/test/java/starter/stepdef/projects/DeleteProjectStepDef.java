package starter.stepdef.projects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.utils.Constants;

public class DeleteProjectStepDef {

    @Steps
    TodoistAPI todoistAPI;
    @Given("Delete a project with available ID path {string}")
    public void deleteAProjectWithAvailableIDPath(String idPath) {
        todoistAPI.deleteAProject(idPath);
    }

    @When("Send delete a project")
    public void sendDeleteAProject() {
        SerenityRest.when().get(Constants.DELETE_PROJECT_URL);
    }

    @Then("Should return {int} No Content status code")
    public void shouldReturnNoContentStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

//    Negative Case 1
    @Given("Delete a project with unavailable ID path {string}")
    public void deleteAProjectWithUnavailableIDPath(String idPath) {
        todoistAPI.deleteAProject(idPath);
    }

//    Negative Case 2
    @Given("Delete a project with ID path filled by string {string}")
    public void deleteAProjectWithIDPathFilledByString(String idPath) {
        todoistAPI.deleteAProject(idPath);
    }

//    Negative Case 3
    @Given("Delete a project with ID path filled by special char {string}")
    public void deleteAProjectWithIDPathFilledBySpecialChar(String idPath) {
        todoistAPI.deleteAProject(idPath);
    }

//    Negative Case 4
    @Given("Delete a project with blank ID path {string}")
    public void deleteAProjectWithBlankIDPath(String idPath) {
        todoistAPI.deleteAProject(idPath);
    }
}
