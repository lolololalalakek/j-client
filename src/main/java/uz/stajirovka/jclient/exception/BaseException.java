package uz.stajirovka.jclient.exception;

import lombok.Getter;
import uz.stajirovka.jclient.constant.enums.Error;
import uz.stajirovka.jclient.constant.enums.ErrorType;

@Getter
public class BaseException extends RuntimeException {

    private final Error error;
    private final ErrorType errorType;

    public BaseException(String message, Error error, ErrorType errorType) {
        super(message);
        this.error = error;
        this.errorType = errorType;
    }
}
