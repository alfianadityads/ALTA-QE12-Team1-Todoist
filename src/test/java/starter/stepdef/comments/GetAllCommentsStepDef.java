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

    //Positive Case
    @Given("Get all comments with valid id path {string}")
    public void getAllCommentsWithValidIdPath(String id) {
        todoistAPI.getAllComments(id);
    }
    @When("Send get all comments")
    public void sendGetCreateANewComment() {
        SerenityRest.when().get(Constants.GET_ALL_COMMENTS_URL);
    }
    @Then("Get all comment should return status code {int} OK")
    public void getAllCommentShouldReturnStatusCodeOK(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }
    @And("Get all comment response body contain {string}")
    public void responseBodyStringGetAllComment(String name) {
        SerenityRest.and().body(TodoistResponses.NAME, equalTo(name));
    }

    //Negative Case 1
    @Given("Get all comment with invalid id path {string}")
    public void getAllCommentWithInvalidIdPath(String id) {
        todoistAPI.getAllComments(id);
    }
    @Then("Get all comments should return status code {int} Bad Request")
    public void getAllCommentsShouldReturnStatusCodeBadRequest(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }

    //Negative Case 2
    @Given("Get all comment with blank id path {string}")
    public void getAllCommentWithBlankIdPath(String id) {
        todoistAPI.getAllComments(id);
    }


}
