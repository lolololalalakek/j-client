package uz.stajirovka.jclient.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.stajirovka.jclient.constant.enums.Error;
import uz.stajirovka.jclient.constant.enums.ErrorType;
import uz.stajirovka.jclient.dto.ErrorDto;
import uz.stajirovka.jclient.exception.ClientNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorDto> handleClientNotFoundException(ClientNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new ErrorDto(ex.getError().code, ex.getMessage(), ex.getErrorType())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
            .map(field -> field.getField() + ": " + field.getDefaultMessage())
            .findFirst()
            .orElse(Error.VALIDATION_ERROR_CODE.message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            new ErrorDto(Error.VALIDATION_ERROR_CODE.code, message, ErrorType.VALIDATION)
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            new ErrorDto(Error.INTERNAL_SERVICE_ERROR_CODE.code, ex.getMessage(), ErrorType.INTERNAL)
        );
    }
}
