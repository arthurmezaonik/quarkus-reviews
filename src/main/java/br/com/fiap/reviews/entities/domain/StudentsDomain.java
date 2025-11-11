package br.com.fiap.reviews.entities.domain;

import br.com.fiap.reviews.entities.models.CoursesModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StudentsDomain extends UsersDomain {

    private LocalDateTime enrollmentDate;
    private List<CoursesModel> courses;
}
