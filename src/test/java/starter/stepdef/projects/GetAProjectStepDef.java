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

public class GetAProjectStepDef {
    @Steps
    TodoistAPI todoistAPI;

//    Positive Case
    @Given("Get a project with available path ID")
    public void getAProjectWithAvailablePathID() {
        todoistAPI.getAProject(Constants.AVAILABLE_ID_PATH);
    }

    @When("Send get a project")
    public void sendGetAProject() {
        SerenityRest.when().get(Constants.GET_PROJECT_URL + Constants.ID_PATH);
    }

    @And("Response get a project body contain as available id path")
    public void responseGetAProjectBodyContain() {
        SerenityRest.and().body(TodoistResponses.ID, equalTo(Constants.AVAILABLE_ID_PATH));
    }

    @And("Validate valid get a project JSON schema {string}")
    public void validateValidGetAProjectJSONSchema(String jsonFile) {
        File json = new File(Constants.PROJECT_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
