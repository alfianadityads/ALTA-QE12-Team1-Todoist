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
    @Given("Get a project with available ID path and valid request body {string}")
    public void getAProjectWithAvailableIDPathAndValidRequestBody(String jsonFile) {
        File json = new File(Constants.PROJECT_REQ_BODY + jsonFile);
        todoistAPI.updateAProject(Constants.AVAILABLE_ID_PATH, json);
    }

    @When("Send update a project")
    public void sendUpdateAProject() {
        SerenityRest.when().post(Constants.UPDATE_PROJECT_URL + Constants.ID_PATH);
    }

    @And("Validate valid update a project JSON schema {string}")
    public void validateValidUpdateAProjectJSONSchema(String jsonFile) {
        File json = new File(Constants.PROJECT_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Negative Case 1
    @Given("Get a project with unavailable ID path {string} and valid request body {string}")
    public void getAProjectWithUnavailableIDPathAndValidRequestBody(String idPath, String jsonFile) {
        File json = new File(Constants.PROJECT_REQ_BODY + jsonFile);
        todoistAPI.updateAProject(Constants.AVAILABLE_ID_PATH, json);
    }
}
