package br.com.fiap.reviews.entities.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestStudentDto(
    @NotBlank(message = "First name is required.")
    @Size(min = 3, max = 100, message = "First name needs to be between 3 and 100 characters")
    @JsonProperty("first_name")
    String firstName,

    @NotBlank(message = "Last name is required.")
    @Size(min = 3, max = 100, message = "Last name needs to be between 3 and 100 characters")
    @JsonProperty("last_name")
    String lastName,

    @NotBlank(message = "Email is required.")
    @Email(message = "Email format invalid.")
    String email
) {
}
