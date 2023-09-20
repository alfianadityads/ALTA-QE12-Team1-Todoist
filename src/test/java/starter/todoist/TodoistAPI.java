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
        Constants.ID_PATH = idPath;
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step("Update a Project")
    public void updateAProject(String idPath, File jsonFile) {
        Constants.ID_PATH = idPath;
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }
}
