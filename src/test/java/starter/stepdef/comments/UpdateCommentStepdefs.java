package starter.stepdef.comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jnr.constants.Constant;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.TodoistResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateCommentStepdefs {
    @Steps
    TodoistAPI todoistAPI;
    @Given("Update a comment with available ID path {string} and filled request body {string}")
    public void updateACommentWithAvailableIDPathAndFilledRequestBody(String id, String jsonFile) {
        File json = new File(Constants.COMMENTS_REQ_BODY+jsonFile);
        todoistAPI.updateAComment(id, json);
    }

    @When("Send update a comment")
    public void sendUpdateAComment() {
        SerenityRest.when().post(Constants.UPDATE_COMMENT_URL);
    }

    @Then("Update comment should return {int} OK status code")
    public void updateCommentShouldReturnOKStatusCode(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }

    @And("Update comment response body contain {string}")
    public void updateCommentResponseBodyContain(String id) {
        SerenityRest.and().body(TodoistResponses.COMMENT_ID,equalTo(id));
    }
}
