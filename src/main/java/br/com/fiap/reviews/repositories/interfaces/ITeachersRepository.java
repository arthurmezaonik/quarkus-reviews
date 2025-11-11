package br.com.fiap.reviews.repositories.interfaces;

import br.com.fiap.reviews.entities.models.TeachersModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ITeachersRepository {
    Optional<TeachersModel> findTeachersById(UUID teacherId);
    List<TeachersModel> findAllTeachers();
    void saveTeacher(TeachersModel teacher);
    void deleteTeacher(TeachersModel teacher);
}
