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
}
