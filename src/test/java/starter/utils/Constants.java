package starter.utils;

import org.hamcrest.Matcher;

import java.io.File;
import java.net.URI;

public class Constants {



    public static String BEARER_TOKEN = "fbdb830f5fbb77eabcd758d187c4e96602e1314e";
    public static String BASE_URL = "https://api.todoist.com/rest/v2";
    public static String DIR = System.getProperty("user.dir");
    public static String ID_PATH = "";
    public static String AVAILABLE_ID_PATH = "";



//    PROJECT FEATURE
    public static String CREATE_PROJECT_URL = BASE_URL + "/projects";
    public static String GET_PROJECT_URL = BASE_URL + "/projects";
    public static String PROJECT_REQ_BODY = DIR + "/src/test/resources/JSON/ReqBody/projects/";
    public static String PROJECT_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JSONSchema/projects/";

//  SECTIONS FEATURE


    public static String CREATE_SECTION_URL = BASE_URL + "/sections";
    public static String GET_SINGLE_SECTION_URL = BASE_URL + "/sections/{id}";
    public static String GET_ALL_SECTIONS_URL = BASE_URL + "/sections?project_id={id}";
    public static String UPDATE_SECTION_URL = BASE_URL + "/sections/{id}";
    public static String DELETE_SECTION_URL = BASE_URL + "/sections/{id}";
    public static String SECTION_REQ_BODY = DIR + "/src/test/resources/JSON/ReqBody/sections/";
    public static String SECTION_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JSONSchema/sections/";

}
