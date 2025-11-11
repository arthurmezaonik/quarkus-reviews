package br.com.fiap.reviews.entities.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private StudentsModel student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id")
    private CoursesModel course;

    @Column(length = 1000)
    private String comment;

    @Column(nullable = false)
    private int rating;

    @Column(name = "is_urgent", nullable = false)
    private boolean urgent = false;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdOn = LocalDateTime.now();

    public ReviewsModel(StudentsModel student, CoursesModel course, String comment, int rating) {
        this.student = student;
        this.course = course;
        this.comment = comment;
        this.rating = rating;
        this.urgent = rating <= 2;
    }
}
