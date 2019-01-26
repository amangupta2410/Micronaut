package micro.naut.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import micro.naut.dtos.Test;
import micro.naut.services.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import static micro.naut.controllers.Routes.*;

/**
 * Created by Karanbir Singh on 1/13/2019.
 **/
@Controller(value = BASE_PATH_URI)
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Inject
    DemoService demoService;

    @Get(value = HOME_URI)
    public String home(){
        logger.info("log from the home path");
        return "test";
    }

    @Get(value = TEST_URI)
    public String test(){
        return demoService.test();
    }

    @Get(value = TEST_OBJ_URI)
    public Test testObj(){
        return demoService.testObject();
    }

}
