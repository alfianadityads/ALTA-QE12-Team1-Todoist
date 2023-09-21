package starter.utils;

public class Constants {

    public static String BEARER_TOKEN = "fbdb830f5fbb77eabcd758d187c4e96602e1314e";
    public static String BASE_URL = "https://api.todoist.com/rest/v2";
    public static String DIR = System.getProperty("user.dir");
    public static String ID_PATH = "";
    public static String AVAILABLE_ID_PATH = "";



//    PROJECT FEATURE
    public static String CREATE_PROJECT_URL = BASE_URL + "/projects";
    public static String GET_PROJECT_URL = BASE_URL + "/projects/{id}";
    public static String UPDATE_PROJECT_URL = BASE_URL + "/projects/";
    public static String DELETE_PROJECT_URL = BASE_URL + "/projects/";
    public static String PROJECT_REQ_BODY = DIR + "/src/test/resources/JSON/ReqBody/projects/";
    public static String PROJECT_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JSONSchema/projects/";


//    COMMENTS FEATURE
    public static String CREATE_COMMENT_URL = BASE_URL + "/comments/{id}";
    public static String GET_COMMENT_URL = BASE_URL + "/comments/{id}";
    public static String GET_ALL_COMMENTS_URL = BASE_URL + "/comments?project_id={id}";
    public static String UPDATE_COMMENT_URL = BASE_URL + "/comments/{id}";
    public static String DELETE_COMMENT_URL = BASE_URL + "/comments/";
    public static String COMMENTS_REQ_BODY = DIR + "/src/test/resources/JSON/ReqBody/comments/";
    public static String COMMENTS_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JSONSchema/comments/";

}

