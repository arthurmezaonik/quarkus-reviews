package br.com.fiap.reviews.resources;

import br.com.fiap.reviews.entities.dto.request.RequestReviewDto;
import br.com.fiap.reviews.entities.dto.response.ResponseReviewDto;
import br.com.fiap.reviews.services.interfaces.IReviewsService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewsResource {

    @Inject
    IReviewsService reviewsService;

    @GET
    @Path("/{id}")
    public Response getReviewById(@PathParam("id") UUID id) {
        return Response.ok(reviewsService.getReviewById(id)).build();
    }

    @GET
    public Response getAllReviews() {
        return Response.ok(reviewsService.getAllReviews()).build();
    }

    @POST
    public Response createReview(@Valid RequestReviewDto reviewDto) {
        ResponseReviewDto created = reviewsService.createReview(reviewDto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @GET
    @Path("/course/{id}")
    public Response getAllReviewsByCourse(@PathParam("id") UUID courseId) {
        return Response.ok(reviewsService.getReviewsByCourse(courseId)).build();
    }

}
