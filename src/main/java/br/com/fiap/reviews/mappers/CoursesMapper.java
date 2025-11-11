package br.com.fiap.reviews.mappers;

import br.com.fiap.reviews.entities.dto.request.RequestCourseDto;
import br.com.fiap.reviews.entities.dto.response.ResponseCourseDto;
import br.com.fiap.reviews.entities.dto.response.ResponseStudentDto;
import br.com.fiap.reviews.entities.models.CoursesModel;
import br.com.fiap.reviews.entities.models.StudentsModel;
import br.com.fiap.reviews.entities.models.TeachersModel;

import java.util.List;

public class CoursesMapper {

    // model -> dto
    public static ResponseCourseDto fromModelToDto (CoursesModel course) {
        return new ResponseCourseDto(course.getId(), course.getTitle());
    }

    // dto -> model
    public static CoursesModel fromDtoToModel (String courseTitle, TeachersModel teacher) {
        return new CoursesModel(courseTitle, teacher);
    }
}
