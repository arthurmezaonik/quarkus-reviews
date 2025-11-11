package br.com.fiap.reviews.repositories;

import br.com.fiap.reviews.entities.models.CoursesModel;
import br.com.fiap.reviews.repositories.interfaces.ICoursesRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class CoursesRepository implements ICoursesRepository, PanacheRepositoryBase<CoursesModel, UUID> {

    @Override
    public Optional<CoursesModel> findCourseById(UUID courseId) {
        return findByIdOptional(courseId);
    }

    @Override
    public List<CoursesModel> findAllCourses() {
        return findAll().list();
    }

    @Override
    public void saveCourse(CoursesModel course) {
        persist(course);
    }

    @Override
    public void deleteCourse(CoursesModel course) {
        delete(course);
    }
}
