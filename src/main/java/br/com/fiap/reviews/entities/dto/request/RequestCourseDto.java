package br.com.fiap.reviews.entities.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RequestCourseDto(@NotBlank String title, @NotNull UUID teacherId) {
}
