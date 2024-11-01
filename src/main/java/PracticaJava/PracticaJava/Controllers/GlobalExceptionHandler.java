package PracticaJava.PracticaJava.Controllers;
import PracticaJava.PracticaJava.Excepcion.FleteNotFoundException;
import PracticaJava.PracticaJava.Excepcion.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FleteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleFleteNotFound(FleteNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

    }
}
