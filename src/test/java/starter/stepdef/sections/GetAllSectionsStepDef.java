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

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetAllSectionsStepDef {
    @Steps
    TodoistAPI todoistAPI;

    @Given("Get all sections with valid id path {string}")
    public void getAllSectionsWithValidPath(String id) {
        todoistAPI.getAllSections(id);
    }

    @When("Send get all sections")
    public void sendGetAllSections() {
        SerenityRest.when().get(Constants.GET_ALL_SECTIONS_URL);
    }
    @And("Section Response body array contain {string}")
    public void sectionResponseBodyArrayContain(String arrayName) {
        SerenityRest.and().body(TodoistResponses.ARRAY_NAME_SECTION, equalTo(arrayName));
    }

    @And("Validate valid get all sections JSON schema {string}")
    public void validateValidGetAllSectionsJSONSchema(String jsonFile) {
        File json = new File(Constants.SECTION_JSON_SCHEMA+ jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


}
