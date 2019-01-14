package micro.naut.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * Created by Karanbir Singh on 1/13/2019.
 **/
@Controller(value = "/")
public class MainController {

    @Get(value = Routes.VERSION+"/${micronaut.application.name}/"+Routes.HOME+"/")
    public String home(){
        return "test";
    }

}
