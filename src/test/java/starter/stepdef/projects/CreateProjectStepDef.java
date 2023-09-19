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

public class CreateProjectStepDef {
    @Steps
    TodoistAPI todoistAPI;

    @Given("Post create new project with valid request body {string}")
    public void postCreateNewProjectWithValidRequestBody(String jsonFile) {
        File json = new File(Constants.PROJECT_REQ_BODY + jsonFile);
        todoistAPI.postCreateNewProject(json);
    }

    @When("Send post create a new project")
    public void sendPostCreateANewProject() {
        SerenityRest.when().post(Constants.CREATE_PROJECT_URL);

    }

    @Then("Should return {int} OK status code")
    public void shouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body contain {string}")
    public void responseBodyContain(String name) {
        SerenityRest.and().body(TodoistResponses.NAME, equalTo(name));
    }

    @And("Validate valid create a new project JSON schema {string}")
    public void validateValidCreateANewProjectJSONSchema(String jsonFile) {
        File json = new File(Constants.PROJECT_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
