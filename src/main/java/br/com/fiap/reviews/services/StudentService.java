package br.com.fiap.reviews.services;

import br.com.fiap.reviews.entities.dto.request.RequestStudentDto;
import br.com.fiap.reviews.entities.dto.response.ResponseStudentDto;
import br.com.fiap.reviews.entities.models.StudentsModel;
import br.com.fiap.reviews.exceptions.EmailAlreadyRegistered;
import br.com.fiap.reviews.exceptions.StudentAlreadyEnrolledException;
import br.com.fiap.reviews.exceptions.StudentNotEnrolledException;
import br.com.fiap.reviews.exceptions.StudentNotFoundException;
import br.com.fiap.reviews.mappers.StudentsMapper;
import br.com.fiap.reviews.repositories.interfaces.IStudentsRepository;
import br.com.fiap.reviews.services.interfaces.ICoursesService;
import br.com.fiap.reviews.services.interfaces.IStudentsService;
import br.com.fiap.reviews.services.interfaces.IUsersService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class StudentService implements IStudentsService {
    @Inject
    IStudentsRepository studentsRepository;
    @Inject
    IUsersService usersService;
    @Inject
    ICoursesService coursesService;

    @Override
    @Transactional
    public ResponseStudentDto createStudent(RequestStudentDto request) {
        if (usersService.emailAlreadyExists(request.email())){
            throw new EmailAlreadyRegistered("This email is already registered.");
        }

        var student = StudentsMapper.fromDtoToModel(request);
        studentsRepository.saveStudent(student);

        return StudentsMapper.fromModelToDto(student);
    }

    @Override
    @Transactional
    public ResponseStudentDto updateStudent(UUID studentId, RequestStudentDto request) {
        var student = studentsRepository.findStudentById(studentId)
            .orElseThrow(() -> new StudentNotFoundException("Student not found by id"));

        if (!student.getEmail().equals(request.email()) && usersService.emailAlreadyExists(request.email())){
            throw new EmailAlreadyRegistered("This email is already registered.");
        }

        student.setFirstName(request.firstName());
        student.setLastName(request.lastName());
        student.setEmail(request.email());

        return StudentsMapper.fromModelToDto(student);
    }

    @Override
    @Transactional
    public void deleteStudent(UUID studentId) {
        var student = studentsRepository.findStudentById(studentId)
            .orElseThrow(() -> new StudentNotFoundException("Student not found by id"));
        studentsRepository.deleteStudent(student);
    }

    @Override
    public StudentsModel getStudentModelById(UUID studentId) {
        return studentsRepository.findStudentById(studentId)
            .orElseThrow(() -> new StudentNotFoundException("Student not found by id"));
    }

    @Override
    public ResponseStudentDto getStudentById(UUID studentId) {
        return StudentsMapper.fromModelToDto(getStudentModelById(studentId));
    }

    @Override
    public List<ResponseStudentDto> getAllStudents() {
        var students = studentsRepository.findAllStudents();
        return students.stream().map(StudentsMapper::fromModelToDto).toList();
    }

    @Override
    @Transactional
    public ResponseStudentDto addCourseToStudent(UUID studentId, UUID courseId) {
        var student = studentsRepository.findStudentById(studentId)
            .orElseThrow(() -> new StudentNotFoundException("Student not found by id"));

        var course = coursesService.getCoursesModelById(courseId);

        if(student.getCourses().contains(course)){
            throw new StudentAlreadyEnrolledException("Student already enrolled in the course: " + course.getTitle());
        }

        student.getCourses().add(course);
        course.getStudents().add(student);

        return StudentsMapper.fromModelToDto(student);
    }

    @Override
    @Transactional
    public ResponseStudentDto removeCourseFromStudent(UUID studentId, UUID courseId) {
        var student = studentsRepository.findStudentById(studentId)
            .orElseThrow(() -> new StudentNotFoundException("Student not found by id"));

        var course = coursesService.getCoursesModelById(courseId);

        if(!student.getCourses().contains(course)){
            throw new StudentNotEnrolledException("Student is not enrolled in course: " + course.getTitle());
        }

        student.getCourses().remove(course);
        course.getStudents().remove(student);

        return StudentsMapper.fromModelToDto(student);
    }
}
