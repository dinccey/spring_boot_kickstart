package ibmix.kickstart.bikeshop.rest.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;
import java.sql.SQLException;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler({InvalidFormatException.class, MismatchedInputException.class})
    public void handlerIllegalArgumentException(JsonProcessingException exception,
                                                ServletWebRequest webRequest) throws IOException {
        if(exception instanceof InvalidFormatException) {
            LOGGER.error(exception.getMessage(), exception);
            webRequest.getResponse().sendError(HttpStatus.CONFLICT.value(), exception.getMessage());
        } else if (exception instanceof MismatchedInputException) {
            LOGGER.error(exception.getMessage(), exception);
            webRequest.getResponse().sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        }

    }

    @ExceptionHandler({SQLException.class})
    public void handlerSqlException(SQLException exception, ServletWebRequest webRequest) throws IOException{
        webRequest.getResponse().sendError(HttpStatus.NOT_MODIFIED.value(),exception.getMessage());
    }


}
