package br.com.fiap.reviews.entities.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoursesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @ManyToOne(optional = true)
    @JoinColumn(name = "teacher_id")
    private TeachersModel teacher;

    @ManyToMany(mappedBy = "courses")
    private List<StudentsModel> students = new ArrayList<>();

    public CoursesModel(String title, TeachersModel teacher) {
        this.title = title;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "CoursesModel{" +
            "id=" + id +
            ", title='" + title + '\'' +
            '}';
    }
}
