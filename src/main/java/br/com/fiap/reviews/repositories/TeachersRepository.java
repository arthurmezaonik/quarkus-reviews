package br.com.fiap.reviews.repositories;

import br.com.fiap.reviews.entities.models.TeachersModel;
import br.com.fiap.reviews.repositories.interfaces.ITeachersRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class TeachersRepository implements ITeachersRepository, PanacheRepositoryBase<TeachersModel, UUID> {
    @Override
    public Optional<TeachersModel> findTeachersById(UUID teacherId) {
        return findByIdOptional(teacherId);
    }

    @Override
    public List<TeachersModel> findAllTeachers() {
        return findAll().list();
    }

    @Override
    public void saveTeacher(TeachersModel teacher) {
        persist(teacher);
    }

    @Override
    public void deleteTeacher(TeachersModel teacher) {
        delete(teacher);
    }
}
