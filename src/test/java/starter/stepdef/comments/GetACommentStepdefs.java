package starter.stepdef.comments;

import groovyjarjarantlr4.runtime.tree.CommonTreeNodeStream;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.TodoistResponses;
import starter.utils.Constants;

import static org.hamcrest.Matchers.equalTo;

public class GetACommentStepdefs {
    @Steps
    TodoistAPI todoistAPI;

    //Positive Case
    @Given("Get a comment with available path ID {string}")
    public void getACommentWithAvailablePathID(String id) {
        todoistAPI.getAComment(id);
    }
    @When("Send get a comment")
    public void sendGetAComment() {
        SerenityRest.when().get(Constants.GET_COMMENT_URL);
    }
    @Then("Get comment should return {int} OK status code")
    public void getCommentShouldReturnOKStatusCode(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }
    @And("Get comment response body contain {string}")
    public void getCommentResponseBodyContain(String id) {
        SerenityRest.and().body(TodoistResponses.ID, equalTo((id)));
    }

    //Negative Case 1
    @Given("Get a comment with unavailable path ID {string}")
    public void getACommentWithUnavailablePathID(String id) {
        todoistAPI.getAComment(id);
    }
    @Then("Get comment should return status code {int} Not Found")
    public void getCommentShouldReturnStatusCodeNotFound(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }

    //Negative Case 2
    @Given("Get a comment with blank path ID {string}")
    public void getACommentWithBlankPathID(String id) {
        todoistAPI.getAComment(id);
    }
    @Then("Get a comment should return status code {int} Bad Request")
    public void getACommentShouldReturnStatusCodeBadRequest(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }

    //Negative Case 3
    @Given("Get a comment with ith ID path filled by special char {string}")
    public void getACommentWithIthIDPathFilledBySpecialChar$(String id) {
        todoistAPI.getAComment(id);
    }
    @Then("Get a comment should return status code {int} Not Found")
    public void getACommentShouldReturnStatusCodeNotFound(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }

    @Given("Get a comment with ith ID path filled by integer {string}")
    public void getACommentWithIthIDPathFilledByInteger(String id) {
        todoistAPI.getAComment(id);
    }
}
