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
        SerenityRest.and().body(TodoistResponses.ID,equalTo(id));
    }
}
