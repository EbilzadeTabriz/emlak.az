package TK.example.emlak.az.exception.globalResolver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class EmlakExceptionHandler {

    @ExceptionHandler(value = {EmlakExceptionRequest.class})
    public ResponseEntity<Object> handleEmlakException(EmlakExceptionRequest e) {
        HttpStatus status = e.getStatusCode();
        EmlakException emlakException = new EmlakException(
                e.getMessage(),
                status,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(emlakException, status);
    }

    private HttpStatus resolveHttpStatus(String statusCode) {
        switch (statusCode) {
            case "BAD_REQUEST":
                return HttpStatus.BAD_REQUEST;
            case "FORBIDDEN":
                return HttpStatus.FORBIDDEN;
            case "NO_CONTENT":
                return HttpStatus.NO_CONTENT;
            case "CONFLICT":
                return HttpStatus.CONFLICT;
            case "NOT_FOUND":
                return HttpStatus.NOT_FOUND;
            case "NOT_ACCEPTABLE":
                return HttpStatus.NOT_ACCEPTABLE;
            default:
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

}
