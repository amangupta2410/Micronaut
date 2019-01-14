package micro.naut.controllers;

import io.micronaut.context.annotation.Value;

/**
 * Created by Karanbir Singh on 1/13/2019.
 **/
public class Routes {

    public static final String VERSION = "v1";

    public static final String SLASH = "/";

    public static final String VERSION_URI = VERSION+SLASH;

    @Value("${micronaut.application.name}")
    public String SERVICE_NAME;

    public static final String HOME = "home";

    public static final String HOME_URI = HOME+SLASH;

    public static final String BASE_PATH = VERSION_URI+"${micronaut.application.name}";

    public static final String BASE_PATH_URI = SLASH+BASE_PATH+SLASH;

    public String HOME_URL = VERSION.concat("/").concat(SERVICE_NAME).concat("/").concat(HOME);

}
