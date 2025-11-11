package br.com.fiap.reviews.services.interfaces;

import br.com.fiap.reviews.entities.dto.request.RequestTeacherDto;
import br.com.fiap.reviews.entities.dto.response.ResponseTeacherDto;
import br.com.fiap.reviews.entities.models.TeachersModel;

import java.util.List;
import java.util.UUID;

public interface ITeachersService {

    ResponseTeacherDto getTeacherById(UUID id);
    TeachersModel getTeacherModelById(UUID id);
    List<ResponseTeacherDto> getAllTeachers();
    ResponseTeacherDto createTeacher(RequestTeacherDto teacherDto);
    ResponseTeacherDto updateTeacher(UUID id, RequestTeacherDto teacherDto);
    void deleteTeacher(UUID id);
}
