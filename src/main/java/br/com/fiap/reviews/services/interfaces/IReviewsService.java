package br.com.fiap.reviews.services.interfaces;

import br.com.fiap.reviews.entities.dto.request.RequestReviewDto;
import br.com.fiap.reviews.entities.dto.response.ResponseReviewDto;

import java.util.List;
import java.util.UUID;

public interface IReviewsService {
    ResponseReviewDto getReviewById(UUID id);
    List<ResponseReviewDto> getAllReviews();
    List<ResponseReviewDto> getReviewsByCourse(UUID courseId);
    ResponseReviewDto createReview(RequestReviewDto payload);
}
