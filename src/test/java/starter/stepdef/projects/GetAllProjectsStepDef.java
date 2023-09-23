package starter.stepdef.projects;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.TodoistResponses;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class GetAllProjectsStepDef {
    @Steps
    TodoistAPI todoistAPI;
    @Given("Get all projects with valid path")
    public void getAllProjectsWithValidPath() {
        todoistAPI.getAllProjects();
    }

    @When("Send get all projects")
    public void sendGetAllProjects() {
        SerenityRest.when().get(Constants.GET_ALL_PROJECTS);
    }
    @And("Response body array contain {string}")
    public void responseBodyArrayContain(String arrayName) {
        SerenityRest.and().body(TodoistResponses.ARRAY_NAME, equalTo(arrayName));
    }

    @And("Validate valid get all projects JSON schema {string}")
    public void validateValidGetAllProjectsJSONSchema(String jsonFile) {
        File json = new File(Constants.PROJECT_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
