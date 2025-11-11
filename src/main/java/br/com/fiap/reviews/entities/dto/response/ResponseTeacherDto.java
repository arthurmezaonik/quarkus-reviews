package br.com.fiap.reviews.entities.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResponseTeacherDto(UUID id, String first_name, String last_name, String email, LocalDateTime hireDate) {
}
