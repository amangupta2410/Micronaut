package micro.naut.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static micro.naut.controllers.Routes.*;

/**
 * Created by Karanbir Singh on 1/13/2019.
 **/
@Controller(value = BASE_PATH_URI)
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Get(value = HOME_URI)
    public String home(){
        logger.info("log from the home path");
        return "test";
    }

}
