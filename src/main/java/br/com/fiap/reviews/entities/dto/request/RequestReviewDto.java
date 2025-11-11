package br.com.fiap.reviews.entities.dto.request;

import jakarta.validation.constraints.*;

import java.util.UUID;

public record RequestReviewDto(
    @NotNull(message = "Course ID is required.")
    UUID courseId,

    @NotNull(message = "Student ID is required.")
    UUID studentId,

    @NotBlank(message = "Comment is required.")
    @Size(min = 1, max = 100, message = "Comment must be between 1 and 100 characters.")
    String comment,

    @NotNull(message = "Rating is required.")
    @Min(value = 1, message = "Rating must be at least 1.")
    @Max(value = 5, message = "Rating must be at most 5.")
    Integer rating
) {}
