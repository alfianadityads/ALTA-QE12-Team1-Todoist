package starter.stepdef.comments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.utils.Constants;

import javax.naming.directory.SearchResult;

public class DeleteCommentStepdefs {
    @Steps
    TodoistAPI todoistAPI;

    //Positive Case
    @Given("Delete a comment with available ID path {string}")
    public void deleteACommentWithAvailableIDPath(String id) {
        todoistAPI.deleteAComment(id);
    }

    @When("Send delete a comment")
    public void sendDeleteAComment() {
        SerenityRest.when().delete(Constants.DELETE_COMMENT_URL);
    }

    @Then("Delete a comment should return status code {int} No Content")
    public void deleteACommentShouldReturnStatusCodeNoContent(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }

    //Negative Case 1
    @Given("Delete a comment with unavailable ID path {string}")
    public void deleteACommentWithUnavailableIDPath(String id) {
        todoistAPI.deleteAComment(id);
    }

    //Negative Case 2
    @Given("Delete a comment with blank ID path {string}")
    public void deleteACommentWithBlankIDPath(String id) {
        todoistAPI.deleteAComment(id);
    }

    @Then("Delete a comment should return status code {int} Bad Request")
    public void deleteACommentShouldReturnStatusCodeBadRequest(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }
}
