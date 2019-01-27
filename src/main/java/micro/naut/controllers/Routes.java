package micro.naut.controllers;

import io.micronaut.context.annotation.Value;

/**
 * Created by Karanbir Singh on 1/13/2019.
 **/
public class Routes {

    private static final String HOME = "home";

    private static final String TEST = "test";

    private static final String TEST_OBJ = "test-obj";

    private static final String PASSWORD_ENCODE = "password-encode";

    private static final String VERSION = "v1";

    private static final String SLASH = "/";

    @Value("${micronaut.application.name}")
    public static String SERVICE_NAME;

    public static final String VERSION_URI = VERSION+SLASH;

    public static final String BASE_PATH = VERSION_URI+"${micronaut.application.name}";

    public static final String BASE_PATH_URI = SLASH+BASE_PATH+SLASH;

    public static final String HOME_URI = HOME+SLASH;

    public static final String TEST_URI = TEST+SLASH;

    public static final String TEST_OBJ_URI = TEST_OBJ+SLASH;

    public static final String PASSWORD_ENCODE_URI = PASSWORD_ENCODE+SLASH;

    private static final String PATH_VARIABLE_PASSWORD = "{password}";

    public static final String PASSWORD_ENCODE_URI_GET = PASSWORD_ENCODE+SLASH+PATH_VARIABLE_PASSWORD;



}
