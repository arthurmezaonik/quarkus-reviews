package br.com.fiap.reviews.repositories.interfaces;

import br.com.fiap.reviews.entities.models.ReviewsModel;
import br.com.fiap.reviews.entities.models.TeachersModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IReviewsRepository {
    Optional<ReviewsModel> findReviewsById(UUID reviewId);
    List<ReviewsModel> findAllReviews();
    List<ReviewsModel> findAllReviewsByCourse(UUID courseId);
    void saveReview(ReviewsModel review);
}
