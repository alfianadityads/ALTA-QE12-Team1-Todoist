package starter.stepdef.sections;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.utils.Constants;

public class DeleteASectionStepDef {
    @Steps
    TodoistAPI todoistAPI;

    //    Positive case
    @Given("Delete delete a section with available ID path {string}")
    public void deleteDeleteASectionWithAvailableIDPath(String idPath) {
            todoistAPI.deleteASection(idPath);
    }

    @When("Send delete delete a section")
    public void sendDeleteDeleteASection() {
        SerenityRest.when().delete(Constants.DELETE_SECTION_URL);
    }

    @Then("Should return {int} No Content status code")
    public void shouldReturnNoContentStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    //    Negative case 1
    @Given("Delete delete a section with unavailable ID path {string}")
    public void deleteDeleteASectionWithUnavailableIDPath(String idPath) {
        todoistAPI.deleteASection(idPath);
    }

    //    Negative case 2
    @Given("Delete delete a section with ID path filled by string {string}")
    public void deleteDeleteASectionWithIDPathFilledByString(String idPath) {
        todoistAPI.deleteASection(idPath);
    }

    //    Negative case 3
    @Given("Delete delete a section with ID path filled by special char {string}")
    public void deleteDeleteASectionWithIDPathFilledBySpecialChar(String idPath) {
        todoistAPI.deleteASection(idPath);
    }

    //    Negative case 4
    @Given("Delete delete a section with blank ID path {string}")
    public void deleteDeleteASectionWithBlankIDPath(String idPath) {
        todoistAPI.deleteASection(idPath);
    }


}
