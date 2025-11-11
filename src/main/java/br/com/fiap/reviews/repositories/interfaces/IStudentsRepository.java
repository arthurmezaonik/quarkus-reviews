package br.com.fiap.reviews.repositories.interfaces;

import br.com.fiap.reviews.entities.models.StudentsModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IStudentsRepository {
    Optional<StudentsModel> findStudentById(UUID studentId);
    List<StudentsModel> findAllStudents();
    void saveStudent(StudentsModel student);
    void deleteStudent(StudentsModel student);
}
