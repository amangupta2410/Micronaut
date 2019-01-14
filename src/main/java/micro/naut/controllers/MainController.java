package micro.naut.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import static micro.naut.controllers.Routes.*;

/**
 * Created by Karanbir Singh on 1/13/2019.
 **/
@Controller(value = BASE_PATH_URI)
public class MainController {

    @Get(value = HOME_URI)
    public String home(){
        return "test";
    }

}
