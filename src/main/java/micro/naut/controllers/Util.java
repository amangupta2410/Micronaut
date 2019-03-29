package micro.naut.controllers;

import io.micronaut.http.HttpRequest;
import micro.naut.dtos.Request;

/**
 * Created by Karanbir Singh on 2/10/2019.
 **/
public class Util {

    public static void handleRequestObject(Request request,
                                    HttpRequest httpRequest){
        if(request == null){
            request = new Request();
        }
        request.setHttpRequest(httpRequest);
        request.setParams(httpRequest.getParameters().asMap());
    }

    public static Request handleRequestObject(HttpRequest httpRequest){
        Request request = new Request();
        request.setHttpRequest(httpRequest);
        request.setParams(httpRequest.getParameters().asMap());
        return request;
    }

    public static String getMessage(String message){
        return message!=null ? message.trim().length() != 0 ? message : "Hello World" : "Hello World";
    }

}
