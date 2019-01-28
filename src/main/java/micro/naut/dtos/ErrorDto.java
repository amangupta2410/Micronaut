package micro.naut.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Karanbir Singh on 11/23/2016.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDto {

    private String field;

    private String message;

    private String error;

    private Integer code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}