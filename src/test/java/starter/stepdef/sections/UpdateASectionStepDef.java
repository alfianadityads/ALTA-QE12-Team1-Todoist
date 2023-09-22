package starter.stepdef.sections;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.TodoistResponses;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class UpdateASectionStepDef {
    @Steps
    TodoistAPI todoistAPI;

    //    Positive case
    @Given("Post update a section with available ID path {string} and filled request body {string}")
    public void postUpdateASectionWithAvailableIDPathAndFilledRequestBody(String id, String jsonFile) {
        File json = new File(Constants.SECTION_REQ_BODY + jsonFile);
        todoistAPI.updateASection(id, json);
    }

    @When("Send post update a section")
    public void sendPostUpdateASection() {
        SerenityRest.when().post(Constants.UPDATE_SECTION_URL);
    }
    @And("Update section response body contain {string}")
    public void updateSectionResponseBodyContain(String name) {
        SerenityRest.and().body(TodoistResponses.NAME,equalTo(name));
    }

    //    Negative case 1
    @Given("Post update a section with unavailable ID path {string} and valid request body {string}")
    public void postUpdateASectionWithUnavailableIDPathAndValidRequestBody(String id, String jsonFile) {
        File json = new File(Constants.SECTION_REQ_BODY + jsonFile);
        todoistAPI.updateASection(id, json);
    }

    //    Negative case 2
    @Given("Post  update a section with available ID path {string} and invalid request body {string}")
    public void postUpdateASectionWithAvailableIDPathAndInvalidRequestBody(String id, String jsonFile) {
        File json = new File(Constants.SECTION_REQ_BODY + jsonFile);
        todoistAPI.updateASection(id, json);
    }

    //    Negative case 3
    @Given("Post update a section with available ID path {string} and blank request body {string}")
    public void postUpdateASectionWithAvailableIDPathAndBlankRequestBody(String id, String jsonFile) {
        File json = new File(Constants.SECTION_REQ_BODY + jsonFile);
        todoistAPI.updateASection(id, json);
    }



}
