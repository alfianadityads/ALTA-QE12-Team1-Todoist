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
    @Given("Delete a comment with available ID path {string}")
    public void deleteACommentWithAvailableIDPath(String id) {
        todoistAPI.deleteAComment(id);
    }

    @When("Send delete a comment")
    public void sendDeleteAComment() {
        SerenityRest.when().delete(Constants.DELETE_COMMENT_URL);
    }

    @Then("Delete a comment should return {int} No Content status code")
    public void deleteACommentShouldReturnNoContentStatusCode(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }
}
