package uz.stajirovka.jclient.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ClientRequestDto(
    @NotBlank(message = "First name is required")
    String firstName,

    @NotBlank(message = "Second name is required")
    String lastName,

    @NotBlank(message = "e-mail is required")
    @Email(message = "e-mail must be valid")
    String email,

    @NotBlank(message = "Passport number is required")
    String passportNumber,

    @NotBlank(message = "Adress is required")
    String adress,

    @NotBlank(message = "Phones number is required")
    String phoneNumber,

    @NotBlank(message = "Births date is required")
    String birthDate,

    @NotBlank(message = "PINFL  is required")
    String PINFL,

    @NotNull
    @Min(18)
    Integer age
) {
}
