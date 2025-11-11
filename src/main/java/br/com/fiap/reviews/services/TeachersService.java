package br.com.fiap.reviews.services;

import br.com.fiap.reviews.entities.dto.request.RequestTeacherDto;
import br.com.fiap.reviews.entities.dto.response.ResponseTeacherDto;
import br.com.fiap.reviews.entities.models.TeachersModel;
import br.com.fiap.reviews.exceptions.EmailAlreadyRegistered;
import br.com.fiap.reviews.exceptions.TeacherNotFoundException;
import br.com.fiap.reviews.mappers.TeachersMapper;
import br.com.fiap.reviews.repositories.interfaces.ITeachersRepository;
import br.com.fiap.reviews.services.interfaces.ITeachersService;
import br.com.fiap.reviews.services.interfaces.IUsersService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeachersService implements ITeachersService {

    @Inject
    ITeachersRepository teachersRepository;
    @Inject
    IUsersService usersService;

    @Override
    public TeachersModel getTeacherModelById(UUID id) {
        return teachersRepository.findTeachersById(id)
            .orElseThrow(() -> new TeacherNotFoundException("Teacher not found by id"));
    }

    @Override
    public ResponseTeacherDto getTeacherById(UUID id) {
        return TeachersMapper.fromModelToDto(getTeacherModelById(id));
    }

    @Override
    public List<ResponseTeacherDto> getAllTeachers() {
        var teachers = teachersRepository.findAllTeachers();
        return teachers.stream().map(TeachersMapper::fromModelToDto).toList();
    }

    @Override
    @Transactional
    public ResponseTeacherDto createTeacher(RequestTeacherDto request) {
        if (usersService.emailAlreadyExists(request.email())){
            throw new EmailAlreadyRegistered("This email is already registered.");
        }

        var teacher = TeachersMapper.fromDtoToModel(request);
        teachersRepository.saveTeacher(teacher);

        return TeachersMapper.fromModelToDto(teacher);
    }

    @Override
    @Transactional
    public ResponseTeacherDto updateTeacher(UUID id, RequestTeacherDto request) {
        var teacher = teachersRepository.findTeachersById(id)
            .orElseThrow(() -> new TeacherNotFoundException("Teacher not found by id"));

        if (!teacher.getEmail().equals(request.email()) && usersService.emailAlreadyExists(request.email())){
            throw new EmailAlreadyRegistered("This email is already registered.");
        }

        teacher.setFirstName(request.firstName());
        teacher.setLastName(request.lastName());
        teacher.setEmail(request.email());

        return TeachersMapper.fromModelToDto(teacher);
    }

    @Override
    @Transactional
    public void deleteTeacher(UUID id) {
        var teacher = teachersRepository.findTeachersById(id)
            .orElseThrow(() -> new TeacherNotFoundException("Teacher not found by id"));
        teachersRepository.deleteTeacher(teacher);
    }
}
