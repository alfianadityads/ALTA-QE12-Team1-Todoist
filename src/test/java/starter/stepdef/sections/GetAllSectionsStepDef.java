package starter.stepdef.sections;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.TodoistResponses;
import starter.utils.Constants;

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

    @And("Validate valid get all sections JSON schema {string}")
    public void validateValidGetAllSectionsJSONSchema(String arrayId) {
        SerenityRest.and().body(TodoistResponses.ARRAY_ID,equalTo(arrayId));
    }
}
