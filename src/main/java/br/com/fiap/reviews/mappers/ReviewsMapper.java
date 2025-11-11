package br.com.fiap.reviews.mappers;

import br.com.fiap.reviews.entities.dto.request.RequestReviewDto;
import br.com.fiap.reviews.entities.dto.response.ResponseReviewDto;
import br.com.fiap.reviews.entities.models.CoursesModel;
import br.com.fiap.reviews.entities.models.ReviewsModel;
import br.com.fiap.reviews.entities.models.StudentsModel;
import br.com.fiap.reviews.entities.models.TeachersModel;

public class ReviewsMapper {

    // model -> dto
    public static ResponseReviewDto fromModelToDto (ReviewsModel review) {
        var course = CoursesMapper.fromModelToDto(review.getCourse());
        var student = StudentsMapper.fromModelToDto(review.getStudent());
        return new ResponseReviewDto(review.getId(), review.getComment(), course, student, review.getRating(), review.isUrgent());
    }

    // dto -> model
    public static ReviewsModel fromDtoToModel (RequestReviewDto review, CoursesModel course, StudentsModel student) {
        return new ReviewsModel(student, course, review.comment(), review.rating());
    }
}
