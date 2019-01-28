package micro.naut.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;
import micro.naut.dtos.Response;
import micro.naut.dtos.UserDto;
import micro.naut.services.UserService;

import javax.inject.Inject;

import static micro.naut.controllers.Routes.BASE_PATH_URI;
import static micro.naut.controllers.Routes.USER_URI;
import micro.naut.dtos.Request;

import java.io.IOException;

/**
 * Created by Karanbir Singh on 1/27/2019.
 **/
@Controller(value = BASE_PATH_URI)
public class UserController {

    @Inject
    UserService userService;

    @Inject
    ObjectMapper objectMapper;

    @Post(value = USER_URI)
    public Response createUser(@Body Request<UserDto> request, HttpRequest httpRequest) throws IOException {
        handleRequestObject(request, httpRequest);

        UserDto userDto = userService.saveUser(request.getData(UserDto.class));
        Response response = new Response(request);
        response.setData(userDto);
        return response;
    }

    /*@Post(value = USER_URI)
    public Single<Response> createUser(@Body Single<Request<UserDto>> request, HttpRequest httpRequest){

        return request.map(r -> {
            handleRequestObject(r, httpRequest);
            Response response = new Response(request);
            response.setData(userService.saveUser(r.getData()));
            return response;
        });
    }*/

    public void handleRequestObject(Request request,
                                       HttpRequest httpRequest){
        if(request == null){
            request = new Request();
        }
        request.setHttpRequest(httpRequest);
        request.setParams(httpRequest.getParameters().asMap());
    }

}
