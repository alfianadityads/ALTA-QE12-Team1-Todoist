package starter.todoist;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class TodoistAPI {

//    PROJECTS FEATURE
    @Step("Post create a New Project")
    public void postCreateNewProject(File jsonFile) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Step("Get all projects")
    public void getAllProjects() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step("Get a Project")
    public void getAProject(String idPath) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("id", idPath);
    }

    @Step("Update a Project")
    public void updateAProject(String idPath, File jsonFile) {
        SerenityRest.given()
                .pathParam("id", idPath)
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Step("Delete a Project")
    public void deleteAProject(String idPath) {
        SerenityRest.given()
                .pathParam("id", idPath)
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

//    COMMENTS FEATURE
    @Step("Get all comments")
    public void getAllComments(String id) {
    SerenityRest.given()
            .pathParam("id", id)
            .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN);
}
    @Step("Post create a New Comment")
    public void postCreateANewComment(File jsonFile) {
    SerenityRest.given()
            .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
            .contentType(ContentType.JSON)
            .body(jsonFile);
    }
    @Step("Get a Comment")
    public void getAComment(String idPath) {
        Constants.ID_PATH = idPath;
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step("Update a Comment")
    public void updateAComment(String idPath, File jsonFile) {
        Constants.ID_PATH = idPath;
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Step("Delete a Comment")
    public void deleteAComment(String idPath) {
        Constants.ID_PATH = idPath;
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
}
