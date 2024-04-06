package TK.example.emlak.az.exception.globalResolver;

import org.springframework.http.HttpStatus;

public class EmlakExceptionRequest extends RuntimeException {

    private final HttpStatus statusCode;


    public EmlakExceptionRequest(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
