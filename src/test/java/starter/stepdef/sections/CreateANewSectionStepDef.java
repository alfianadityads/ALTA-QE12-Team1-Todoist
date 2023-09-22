package starter.stepdef.sections;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.utils.Constants;

import java.io.File;

public class CreateANewSectionStepDef {
    @Steps
    TodoistAPI todoistAPI;

   //    Positive case
    @Given("Post create new section with valid request body {string}")
    public void postCreateNewSectionWithValidRequestBody(String jsonFile) {
        File json = new File(Constants.SECTION_REQ_BODY + jsonFile);
        todoistAPI.postCreateNewSection(json);
    }

    @When("Send post create a new section")
    public void sendPostCreateANewSection() {
        SerenityRest.when().post(Constants.CREATE_SECTION_URL);

    }
    //    Negative case 1
    @Given("Post create a new section with valid name and invalid project id {string}")
    public void postCreateANewSectionWithValidNameAndInvalidProjectId(String jsonFile) {
        File json = new File(Constants.SECTION_REQ_BODY + jsonFile);
        todoistAPI.postCreateNewSection(json);

    }

    //    Negative case 2
    @Given("Post create a new section with blank name and valid project id filled integer {string}")
    public void postCreateANewSectionWithBlankNameAndValidProjectIdFilledInteger(String jsonFile) {
        File json = new File(Constants.SECTION_REQ_BODY + jsonFile);
        todoistAPI.postCreateNewSection(json);

    }

    //    Negative case 3
    @Given("Post create a new section with name filled special char and valid project id {string}")
    public void postCreateANewSectionWithNameFilledSpecialCharAndValidProjectId(String jsonFile) {
        File json = new File(Constants.SECTION_REQ_BODY + jsonFile);
        todoistAPI.postCreateNewSection(json);

    }

    //    Negative case 4
    @Given("Post  create a new section with blank request {string}")
    public void postCreateANewSectionWithBlankRequest(String jsonFile) {
        File json = new File(Constants.SECTION_REQ_BODY + jsonFile);
        todoistAPI.postCreateNewSection(json);

    }
}
