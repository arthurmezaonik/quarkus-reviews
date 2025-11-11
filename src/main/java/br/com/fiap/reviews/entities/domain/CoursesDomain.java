package br.com.fiap.reviews.entities.domain;


import br.com.fiap.reviews.entities.models.StudentsModel;
import br.com.fiap.reviews.entities.models.TeachersModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoursesDomain {

    private UUID id;
    private String title;
    private TeachersModel teacher;
    private List<StudentsModel> students;
}
