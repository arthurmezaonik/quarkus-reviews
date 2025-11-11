package br.com.fiap.reviews.mappers;

import br.com.fiap.reviews.entities.dto.request.RequestStudentDto;
import br.com.fiap.reviews.entities.dto.response.ResponseCourseDto;
import br.com.fiap.reviews.entities.dto.response.ResponseStudentDto;
import br.com.fiap.reviews.entities.models.CoursesModel;
import br.com.fiap.reviews.entities.models.StudentsModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsMapper {

    // model -> dto
    public static ResponseStudentDto fromModelToDto(StudentsModel student){
        List<ResponseCourseDto> courses = student.getCourses().stream().map(CoursesMapper::fromModelToDto).toList();
        return new ResponseStudentDto(
            student.getId(),
            student.getFirstName(),
            student.getLastName(),
            student.getEmail(),
            student.getEnrollmentDate(),
            courses
        );
    }

    // dto -> model
    public static StudentsModel fromDtoToModel (RequestStudentDto student) {
        return new StudentsModel(student.firstName(), student.lastName(), student.email());
    }
}
