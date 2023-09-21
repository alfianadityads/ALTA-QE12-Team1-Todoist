package starter.stepdef.comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.TodoistResponses;
import starter.utils.Constants;

import static org.hamcrest.Matchers.equalTo;

public class GetAllCommentsStepDef {
    @Steps
    TodoistAPI todoistAPI;
    @Given("Get all comments with valid id path")
    public void getAllCommentsWithValidIdPath() {
        todoistAPI.getAllComments();
    }
    @When("Send get all comments")
    public void sendPostCreateANewComment() {
        SerenityRest.when().post(Constants.CREATE_COMMENTS_URL);
    }
    @And("Response body array contain {string}")
    public void responseBodyArrayContain(String arrayName) {
        SerenityRest.and().body(TodoistResponses.ARRAY_NAME, equalTo(arrayName));
    }
    @Then("Should return {int} OK status code")
    public void shouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
    @And("Response body string contain {string}")
    public void responseBodyStringContain(String name) {
        SerenityRest.and().body(TodoistResponses.NAME, equalTo(name));
    }
}
