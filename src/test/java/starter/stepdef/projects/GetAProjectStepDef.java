package starter.stepdef.projects;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.TodoistResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetAProjectStepDef {
    @Steps
    TodoistAPI todoistAPI;

//    Positive Case
    @Given("Get a project with available path ID {string}")
    public void getAProjectWithAvailablePathID(String idPath) {
        todoistAPI.getAProject(idPath);
    }

    @When("Send get a project")
    public void sendGetAProject() {
        SerenityRest.when().get(Constants.GET_PROJECT_URL + Constants.ID_PATH);
    }

    @And("Response get a project body contain as available id path {string}")
    public void responseGetAProjectBodyContain(String idPath) {
        SerenityRest.and().body(TodoistResponses.ID, equalTo(idPath));
    }

    @And("Validate valid get a project JSON schema {string}")
    public void validateValidGetAProjectJSONSchema(String jsonFile) {
        File json = new File(Constants.PROJECT_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


//  Negative Case 1
    @Given("Get a project with unavailable path ID {string}")
    public void getAProjectWithUnavailablePathID(String id) {
        todoistAPI.getAProject(id);
    }

    @Then("Should return {int} Not Found status code")
    public void shouldReturnNotFoundStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

//    Negative Case 2
    @Given("Get a project with ID path filled by string {string}")
    public void getAProjectWithIDPathFilledByString(String id) {
        todoistAPI.getAProject(id);
    }

//    Negative Case 3
    @Given("Get a project with ID path filled by special char {string}")
    public void getAProjectWithIDPathFilledBySpecialChar(String id) {
        todoistAPI.getAProject(id);
    }

//    Negative Case 4
    @Given("Get a project with blank ID path {string}")
    public void getAProjectWithBlankIDPath(String id) {
        todoistAPI.getAProject(id);
    }
}
