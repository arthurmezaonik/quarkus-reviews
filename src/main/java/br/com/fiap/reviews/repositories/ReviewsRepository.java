package br.com.fiap.reviews.repositories;

import br.com.fiap.reviews.entities.models.ReviewsModel;
import br.com.fiap.reviews.repositories.interfaces.IReviewsRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ReviewsRepository implements IReviewsRepository, PanacheRepositoryBase<ReviewsModel, UUID> {
    @Override
    public Optional<ReviewsModel> findReviewsById(UUID reviewId) {
        return findByIdOptional(reviewId);
    }

    @Override
    public List<ReviewsModel> findAllReviews() {
        return findAll().list();
    }

    @Override
    public List<ReviewsModel> findAllReviewsByCourse(UUID courseId) {
        return find("course.id", courseId).list();
    }

    @Override
    public void saveReview(ReviewsModel review) {
        persist(review);
    }
}
