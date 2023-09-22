package starter.stepdef.sections;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.utils.Constants;

import java.io.File;

public class GetASingleSectionStepDef {
    @Steps
    TodoistAPI todoistAPI;

    @Given("get a single section{string}")
    public void getASingleSection(String idPath) {
        todoistAPI.getASingleSection(idPath);
    }
    @When("Send get a single sections")
    public void sendGetASingleSections() {
        SerenityRest.when().get(Constants.GET_SINGLE_SECTION_URL + Constants.ID_PATH);
    }
    @And("Validate valid get a single sections JSON schema {string}")
    public void validateValidGetASingleSectionsJSONSchema(String jsonFile) {
        File json = new File(Constants.SECTION_JSON_SCHEMA +jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

}
