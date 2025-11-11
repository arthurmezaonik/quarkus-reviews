package br.com.fiap.reviews.services.interfaces;

import br.com.fiap.reviews.entities.dto.request.RequestStudentDto;
import br.com.fiap.reviews.entities.dto.response.ResponseStudentDto;
import br.com.fiap.reviews.entities.models.StudentsModel;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

public interface IStudentsService {

    ResponseStudentDto createStudent(RequestStudentDto request);
    ResponseStudentDto updateStudent(UUID studentId, RequestStudentDto request);
    void deleteStudent(UUID studentId);
    StudentsModel getStudentModelById(UUID studentId);
    ResponseStudentDto getStudentById(UUID studentId);
    List<ResponseStudentDto> getAllStudents();
    ResponseStudentDto addCourseToStudent(UUID studentId, UUID courseId);
    ResponseStudentDto removeCourseFromStudent(UUID studentId, UUID courseId);
}
