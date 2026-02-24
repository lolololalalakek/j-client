package uz.stajirovka.jclient.exception;

import uz.stajirovka.jclient.constant.enums.Error;
import uz.stajirovka.jclient.constant.enums.ErrorType;

public class ClientNotFoundException extends BaseException {

    public ClientNotFoundException(Long id) {
        super("Client not found: " + id, Error.INTERNAL_SERVICE_ERROR_CODE, ErrorType.INTERNAL);
    }
}
