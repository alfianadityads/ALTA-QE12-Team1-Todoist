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

    //Positive Case
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


    //Negative Case 1
    @Given("Update a comment with available ID path {string} and filled by integer value {string}")
    public void updateACommentWithAvailableIDPathAndFilledByIntegerValue(String id, String jsonFile) {
        File json = new File(Constants.COMMENTS_REQ_BODY+jsonFile);
        todoistAPI.updateAComment(id, json);
    }
    @Then("Update comment should return status code {int} Bad Request")
    public void updateCommentShouldReturnStatusCodeBadRequest(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }

    //Negative Case 2
    @Given("Update a comment with unavailable ID path {string} and filled by integer value {string}")
    public void updateACommentWithUnavailableIDPathAndFilledByIntegerValue(String id, String jsonFile) {
        File json = new File(Constants.COMMENTS_REQ_BODY+jsonFile);
        todoistAPI.updateAComment(id, json);
    }

    //Negative Case 3
    @Given("Update a comment with available ID path {string} and filled by special char value {string}")
    public void updateACommentWithAvailableIDPathAndFilledBySpecialCharValue(String id, String jsonFile) {
        File json = new File(Constants.COMMENTS_REQ_BODY+jsonFile);
        todoistAPI.updateAComment(id, json);
    }

    //Negative Case 4
    @Given("Update a comment with unavailable ID path {string} and filled by special char value {string}")
    public void updateACommentWithUnavailableIDPathAndFilledBySpecialCharValue(String id, String jsonFile) {
        File json = new File(Constants.COMMENTS_REQ_BODY+jsonFile);
        todoistAPI.updateAComment(id, json);
    }

}
