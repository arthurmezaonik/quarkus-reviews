package br.com.fiap.reviews.repositories.interfaces;

import br.com.fiap.reviews.entities.models.CoursesModel;
import br.com.fiap.reviews.entities.models.CoursesModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICoursesRepository {
    Optional<CoursesModel> findCourseById(UUID courseId);
    List<CoursesModel> findAllCourses();
    void saveCourse(CoursesModel course);
    void deleteCourse(CoursesModel course);
}
