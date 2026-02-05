package uz.stajirovka.jclient.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ClientResponseDto(
    Long id,
    String firstName,
    String lastName,
    String phoneNumber,
    Integer age,
    String email,
    String passportNumber,
    String birthDate,
    String adress,
    String PINFL,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
