package br.com.fiap.reviews.entities.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="students")
@PrimaryKeyJoinColumn(name="id")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class StudentsModel extends UsersModel {

    @Column(nullable = false, name="enrollment_date")
    @ToString.Include
    private LocalDateTime enrollmentDate = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
        name="student_courses",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<CoursesModel> courses = new ArrayList<>();

    public StudentsModel(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }
}


