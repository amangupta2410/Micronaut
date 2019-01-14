package micro.naut.controllers;

import io.micronaut.context.annotation.Value;

/**
 * Created by Karanbir Singh on 1/13/2019.
 **/
public class Routes {

    public static final String VERSION = "v1";

    @Value("${micronaut.application.name}")
    public String SERVICE_NAME;

    public static final String HOME = "home";

    public String HOME_URL = VERSION.concat("/").concat(SERVICE_NAME).concat("/").concat(HOME);

}
