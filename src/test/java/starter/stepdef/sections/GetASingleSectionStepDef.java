package starter.stepdef.sections;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.TodoistResponses;
import starter.utils.Constants;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class GetASingleSectionStepDef {
    @Steps
    TodoistAPI todoistAPI;

    @Given("get a single section {string}")
    public void getASingleSection(String id) {
        todoistAPI.getASingleSection(id);
    }
    @When("Send get a single sections")
    public void sendGetASingleSections() {
        SerenityRest.when().get(Constants.GET_SINGLE_SECTION_URL);
    }
    @And("Section Response body contain {string}")
    public void sectionResponseBodyContain(String id) {
        SerenityRest.and().body(TodoistResponses.ID, equalTo(id));
    }
}
