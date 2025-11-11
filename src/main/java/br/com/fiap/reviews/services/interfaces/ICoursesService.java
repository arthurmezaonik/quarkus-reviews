package br.com.fiap.reviews.services.interfaces;

import br.com.fiap.reviews.entities.dto.request.RequestCourseDto;
import br.com.fiap.reviews.entities.dto.response.ResponseCourseDto;
import br.com.fiap.reviews.entities.models.CoursesModel;

import java.util.List;
import java.util.UUID;

public interface ICoursesService {
    CoursesModel getCoursesModelById(UUID courseId);
    ResponseCourseDto getCourseById(UUID id);
    List<ResponseCourseDto> getAllCourses();
    ResponseCourseDto createCourse(RequestCourseDto courseDto);
    ResponseCourseDto updateCourse(UUID id, RequestCourseDto courseDto);
    void deleteCourse(UUID id);
}
