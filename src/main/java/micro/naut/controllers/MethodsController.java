package micro.naut.controllers;

import io.micrometer.core.instrument.util.StringEscapeUtils;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.*;
import micro.naut.dtos.Request;
import micro.naut.dtos.Response;

import static micro.naut.controllers.Routes.BASE_PATH_URI;
import static micro.naut.controllers.Util.getMessage;
import static micro.naut.controllers.Util.handleRequestObject;

/**
 * Created by Karanbir Singh on 2/10/2019.
 **/
@Controller(value = BASE_PATH_URI)
public class MethodsController {

    @Get("get")
    public Response get(@QueryValue(defaultValue = "Hello World") String message, HttpRequest httpRequest){
        Request request = handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(message);
        return response;
    }

    @Post("post")
    public Response post(@QueryValue(defaultValue = "Hello World") String message, @Body Request request, HttpRequest httpRequest){
        handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(message);
        return response;
    }

    @Put("put")
    public Response put(@QueryValue(defaultValue = "Hello World") String message, @Body Request request, HttpRequest httpRequest){
        handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(message);
        return response;
    }

    @Delete("delete")
    public Response delete(@QueryValue(defaultValue = "Hello World") String message, HttpRequest httpRequest){
        Request request = handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(message);
        return response;
    }

    @Patch("patch")
    public Response patch(@QueryValue(defaultValue = "Hello World") String message, HttpRequest httpRequest){
        Request request = handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(message);
        return response;
    }

    @Trace("trace")
    public Response trace(@QueryValue(defaultValue = "Hello World") String message, HttpRequest httpRequest){
        Request request = handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(message);
        return response;
    }

    @Head("head")
    public Response head(HttpRequest httpRequest){
        Request request = handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(getMessage(null));
        return response;
    }

    @Options("options")
    public Response options(@QueryValue String message, HttpRequest httpRequest){
        Request request = handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(message);
        return response;
    }

}
