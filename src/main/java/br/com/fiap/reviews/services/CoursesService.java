package br.com.fiap.reviews.services;

import br.com.fiap.reviews.entities.dto.request.RequestCourseDto;
import br.com.fiap.reviews.entities.dto.response.ResponseCourseDto;
import br.com.fiap.reviews.entities.models.CoursesModel;
import br.com.fiap.reviews.exceptions.CourseAlreadyRegisteredException;
import br.com.fiap.reviews.exceptions.CourseNotFoundException;
import br.com.fiap.reviews.exceptions.StudentsRegiteredToCourseException;
import br.com.fiap.reviews.mappers.CoursesMapper;
import br.com.fiap.reviews.repositories.interfaces.ICoursesRepository;
import br.com.fiap.reviews.services.interfaces.ICoursesService;
import br.com.fiap.reviews.services.interfaces.ITeachersService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CoursesService implements ICoursesService {

    @Inject
    ICoursesRepository coursesRepository;
    @Inject
    ITeachersService teachersService;

    @Override
    public CoursesModel getCoursesModelById(UUID courseId) {
        return coursesRepository.findCourseById(courseId)
            .orElseThrow(() -> new CourseNotFoundException("Course not found by id"));
    }

    @Override
    public ResponseCourseDto getCourseById(UUID id) {
        var course = coursesRepository.findCourseById(id)
            .orElseThrow(() -> new CourseNotFoundException("Course not found by id"));
        return CoursesMapper.fromModelToDto(course);
    }

    @Override
    public List<ResponseCourseDto> getAllCourses() {
        var courses = coursesRepository.findAllCourses();
        return courses.stream().map(CoursesMapper::fromModelToDto).toList();
    }

    @Override
    @Transactional
    public ResponseCourseDto createCourse(RequestCourseDto courseDto) {
        var existingCourses = coursesRepository.findAllCourses().stream().map(c -> c.getTitle().toLowerCase()).toList();

        if(existingCourses.contains(courseDto.title().toLowerCase())){
            throw new CourseAlreadyRegisteredException("A course with this title already exist.");
        }

        var teacher = teachersService.getTeacherModelById(courseDto.teacherId());

        var course = CoursesMapper.fromDtoToModel(courseDto.title(), teacher);
        coursesRepository.saveCourse(course);

        return CoursesMapper.fromModelToDto(course);
    }

    @Override
    @Transactional
    public ResponseCourseDto updateCourse(UUID id, RequestCourseDto courseDto) {
        var course = coursesRepository.findCourseById(id)
            .orElseThrow(() -> new CourseNotFoundException("Course not found by id"));

        var existingCourses = coursesRepository.findAllCourses().stream().map(c -> c.getTitle().toLowerCase()).toList();
        if(existingCourses.contains(courseDto.title().toLowerCase())){
            throw new CourseAlreadyRegisteredException("A course with this title already exist.");
        }

        var teacher = teachersService.getTeacherModelById(courseDto.teacherId());

        course.setTitle(courseDto.title());
        course.setTeacher(teacher);

        return CoursesMapper.fromModelToDto(course);
    }

    @Override
    @Transactional
    public void deleteCourse(UUID id) {
        var course = coursesRepository.findCourseById(id)
            .orElseThrow(() -> new CourseNotFoundException("Course not found by id"));

        if(!course.getStudents().isEmpty()){
            throw new StudentsRegiteredToCourseException("This couse still has students registered.");
        }

        coursesRepository.deleteCourse(course);
    }
}
