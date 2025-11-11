package br.com.fiap.reviews.repositories;

import br.com.fiap.reviews.entities.models.StudentsModel;
import br.com.fiap.reviews.repositories.interfaces.IStudentsRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class StudentsRepository implements IStudentsRepository, PanacheRepositoryBase<StudentsModel, UUID> {

    @Override
    public Optional<StudentsModel> findStudentById(UUID studentId) {
        return findByIdOptional(studentId);
    }

    @Override
    public List<StudentsModel> findAllStudents() {
        return findAll().list();
    }

    @Override
    public void saveStudent(StudentsModel student) {
        persist(student);
    }

    @Override
    public void deleteStudent(StudentsModel student) {
        delete(student);
    }
}
