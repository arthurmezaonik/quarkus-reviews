package br.com.fiap.reviews.mappers;

import br.com.fiap.reviews.entities.dto.request.RequestTeacherDto;
import br.com.fiap.reviews.entities.dto.response.ResponseTeacherDto;
import br.com.fiap.reviews.entities.models.TeachersModel;

public class TeachersMapper {

    // model -> dto
    public static ResponseTeacherDto fromModelToDto(TeachersModel teacher){
        return new ResponseTeacherDto(
            teacher.getId(),
            teacher.getFirstName(),
            teacher.getLastName(),
            teacher.getEmail(),
            teacher.getHireDate()
        );
    }

    // dto -> model
    public static TeachersModel fromDtoToModel (RequestTeacherDto teacher) {
        return new TeachersModel(teacher.firstName(), teacher.lastName(), teacher.email());
    }
}
