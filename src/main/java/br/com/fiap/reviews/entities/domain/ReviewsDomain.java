package br.com.fiap.reviews.entities.domain;

import br.com.fiap.reviews.entities.models.CoursesModel;
import br.com.fiap.reviews.entities.models.StudentsModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewsDomain {

    private UUID id;
    private StudentsModel student;
    private CoursesModel course;
    private String comment;
    private int rating;
    private boolean urgent = false;
    private LocalDateTime createdOn = LocalDateTime.now();
}
