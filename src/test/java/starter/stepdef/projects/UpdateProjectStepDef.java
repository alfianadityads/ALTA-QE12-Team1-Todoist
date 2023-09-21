package starter.stepdef.projects;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateProjectStepDef {
    @Steps
    TodoistAPI todoistAPI;
    @Given("Update a project with available ID path {string} and valid request body {string}")
    public void getAProjectWithAvailableIDPathAndValidRequestBody(String idPath, String jsonFile) {
        File json = new File(Constants.PROJECT_REQ_BODY + jsonFile);
        todoistAPI.updateAProject(idPath, json);
    }

    @When("Send update a project")
    public void sendUpdateAProject() {
        SerenityRest.when().post(Constants.UPDATE_PROJECT_URL);
    }

    @And("Validate valid update a project JSON schema {string}")
    public void validateValidUpdateAProjectJSONSchema(String jsonFile) {
        File json = new File(Constants.PROJECT_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Negative Case 1
    @Given("Update a project with unavailable ID path {string} and valid request body {string}")
    public void getAProjectWithUnavailableIDPathAndValidRequestBody(String idPath, String jsonFile) {
        File json = new File(Constants.PROJECT_REQ_BODY + jsonFile);
        todoistAPI.updateAProject(idPath, json);
    }

//    Negative Case 2
    @Given("Update a project with available ID path {string} and invalid request body {string}")
    public void getAProjectWithAvailableIDPathAndInvalidRequestBody(String idPath, String jsonFile) {
        File json = new File(Constants.PROJECT_REQ_BODY + jsonFile);
        todoistAPI.updateAProject(idPath, json);
    }

    @Given("Update a project with available ID path {string} and blank request body {string}")
    public void getAProjectWithAvailableIDPathAndBlankRequestBody(String idPath, String jsonFile) {
        File json = new File(Constants.PROJECT_REQ_BODY + jsonFile);
        todoistAPI.updateAProject(idPath, json);
    }
}
