package uz.stajirovka.jclient.dto;

import uz.stajirovka.jclient.constant.enums.ErrorType;

public record ErrorDto(
    int code,
    String message,
    ErrorType errorType
) {
}
