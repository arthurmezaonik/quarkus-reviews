package br.com.fiap.reviews.entities.dto.response;

import java.util.UUID;

public record ResponseReviewDto(UUID id, String comment, ResponseCourseDto course, ResponseStudentDto student, int rating, boolean urgent) {
}
