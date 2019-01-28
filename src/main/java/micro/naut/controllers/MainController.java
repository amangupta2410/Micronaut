package micro.naut.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import micro.naut.dtos.Test;
import micro.naut.services.DemoService;
import micro.naut.util.BcryptPasswordEncoderService;
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

    @Inject
    BcryptPasswordEncoderService encoderService;

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

    @Post(value = TEST_OBJ_URI)
    public Test testObjPost(@Body Test test){
        return demoService.testObject();
    }

    @Post(value = PASSWORD_ENCODE_URI, consumes = MediaType.TEXT_PLAIN)
    public String encodePost(@Body String password){
        return encoderService.encode(password);
    }

    @Get(value = PASSWORD_ENCODE_URI_GET)
    public String encodeGet(String password){
        return encoderService.encode(password);
    }

}
