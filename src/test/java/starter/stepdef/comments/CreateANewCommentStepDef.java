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

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateANewCommentStepDef {
    @Steps
    TodoistAPI todoistAPI;

    //Positive Case
    @Given("Post create new comment with valid request body {string}")
    public void getAllCommentsWithValidIdPath(String jsonFile) {
        File json = new File(Constants.COMMENTS_REQ_BODY+jsonFile);
        todoistAPI.postCreateANewComment(json);
    }
    @When("Send post create a new comment")
    public void sendPostCreateANewComment() {
        SerenityRest.when().post(Constants.CREATE_COMMENT_URL);
    }
    @Then("Should return status code {int} OK")
    public void returnStatusCodeOK(int respondCode) {
        SerenityRest.then().statusCode(respondCode);
    }
    @And("Create new comment response body contain {string}")
    public void createNewCommentResponseBodyContain(String id) {
        SerenityRest.and().body(TodoistResponses.PROJECT_ID,equalTo(id));
    }

    //Negative Case 1
    @Given("Post create new comment with blank id request body {string}")
    public void postCreateNewCommentWithBlankIdRequestBodyAnd(String jsonFile) {
        File json = new File(Constants.COMMENTS_REQ_BODY+jsonFile);
        todoistAPI.postCreateANewComment(json);
    }
    @Then("Create new comment should return status code {int} Bad Request")
    public void createNewCommentShouldReturnStatusCodeBadRequest(int respondCode) {
        SerenityRest.then().statusCode(respondCode);
    }

    //Negative Case 2
    @Given("Post create new comment with content filled integer request body {string}")
    public void postCreateNewCommentWithContentFilledIntegerRequestBody(String jsonFile) {
        File json = new File(Constants.COMMENTS_REQ_BODY+jsonFile);
        todoistAPI.postCreateANewComment(json);
    }

    //Negative Case 3
    @Given("Post create new comment with content filled special char request body {string}")
    public void postCreateNewCommentWithContentFilledSpecialCharRequestBody(String jsonFile) {
        File json = new File(Constants.COMMENTS_REQ_BODY+jsonFile);
        todoistAPI.postCreateANewComment(json);
    }

    //Negative Case 4
    @Given("Post create new comment with blank request body {string}")
    public void postCreateNewCommentWithBlankRequestBody(String jsonFile) {
        File json = new File(Constants.COMMENTS_REQ_BODY+jsonFile);
        todoistAPI.postCreateANewComment(json);
    }
}
