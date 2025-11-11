package br.com.fiap.reviews.services;

import br.com.fiap.reviews.entities.dto.request.RequestReviewDto;
import br.com.fiap.reviews.entities.dto.response.ResponseReviewDto;
import br.com.fiap.reviews.exceptions.ReviewNotFoundException;
import br.com.fiap.reviews.exceptions.StudentNotEnrolledException;
import br.com.fiap.reviews.exceptions.TeacherNotFoundException;
import br.com.fiap.reviews.mappers.ReviewsMapper;
import br.com.fiap.reviews.mappers.TeachersMapper;
import br.com.fiap.reviews.repositories.interfaces.IReviewsRepository;
import br.com.fiap.reviews.services.interfaces.IReviewsService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ReviewsService implements IReviewsService {

    @Inject
    IReviewsRepository reviewsRepository;
    @Inject
    StudentService studentService;
    @Inject
    CoursesService coursesService;

    @Override
    public ResponseReviewDto getReviewById(UUID id) {
        var review = reviewsRepository.findReviewsById(id)
            .orElseThrow(() -> new ReviewNotFoundException("Review not found by id"));

        return ReviewsMapper.fromModelToDto(review);
    }

    @Override
    public List<ResponseReviewDto> getAllReviews() {
        var reviews = reviewsRepository.findAllReviews();
        return reviews.stream().map(ReviewsMapper::fromModelToDto).toList();
    }

    @Override
    public List<ResponseReviewDto> getReviewsByCourse(UUID courseId) {
        // just validates if course exists
        var course = coursesService.getCoursesModelById(courseId);

        var reviews = reviewsRepository.findAllReviewsByCourse(courseId);
        return reviews.stream().map(ReviewsMapper::fromModelToDto).toList();
    }

    @Override
    @Transactional
    public ResponseReviewDto createReview(RequestReviewDto payload) {
        var course = coursesService.getCoursesModelById(payload.courseId());
        var student = studentService.getStudentModelById(payload.studentId());

        if (!student.getCourses().contains(course)) {
            throw new StudentNotEnrolledException("Student is not enrolled in course: " + course.getTitle());
        }

        var review = ReviewsMapper.fromDtoToModel(payload, course, student);

        if (review.isUrgent()){
            // queue service to get notified
            System.out.println("Notification to teacher");
        }

        reviewsRepository.saveReview(review);

        return ReviewsMapper.fromModelToDto(review);
    }
}
