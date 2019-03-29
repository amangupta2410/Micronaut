package micro.naut.exception.handlers;

import io.micronaut.context.annotation.Primary;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.hateos.JsonError;
import io.micronaut.http.hateos.Link;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.micronaut.web.router.exceptions.UnsatisfiedRouteException;
import micro.naut.dtos.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
@Produces
public class RouteHandler implements ExceptionHandler<UnsatisfiedRouteException, HttpResponse> {
    private static final Logger LOG = LoggerFactory.getLogger(io.micronaut.http.server.netty.converters.UnsatisfiedRouteHandler.class);

    @Override
    public HttpResponse handle(HttpRequest request, UnsatisfiedRouteException exception) {
        if (LOG.isErrorEnabled()) {
            LOG.error("{} (Bad Request): {}", request, exception.getMessage());
        }
        ErrorDto error = new ErrorDto();
        error.setCode(HttpStatus.BAD_REQUEST.getCode());
        error.setError("Arguments Error");
        error.setField(exception.getArgument().getName());
        error.setMessage("Argument(s) not provided correctly ["+exception.getArgument().getName()+"]");
        /*System.out.println(exception.getClass().getCanonicalName());
        JsonError error = new JsonError(exception.getMessage());
        error.path('/' + exception.getArgument().getName());
        error.link(Link.SELF, Link.of(request.getUri()));*/
        return HttpResponse.badRequest(error);
    }
}