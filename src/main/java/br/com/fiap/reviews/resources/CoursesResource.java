package br.com.fiap.reviews.resources;

import br.com.fiap.reviews.entities.dto.request.RequestCourseDto;
import br.com.fiap.reviews.entities.dto.request.RequestTeacherDto;
import br.com.fiap.reviews.entities.dto.response.ResponseCourseDto;
import br.com.fiap.reviews.entities.dto.response.ResponseTeacherDto;
import br.com.fiap.reviews.services.interfaces.ICoursesService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoursesResource {

    @Inject
    ICoursesService coursesService;

    @GET
    @Path("/{id}")
    public Response getCourseById(@PathParam("id") UUID id) {
        return Response.ok(coursesService.getCourseById(id)).build();
    }

    @GET
    public Response getAllCourses() {
        return Response.ok(coursesService.getAllCourses()).build();
    }

    @POST
    public Response createCourse(@Valid RequestCourseDto courseDto) {
        ResponseCourseDto created = coursesService.createCourse(courseDto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PATCH
    @Path("/{id}")
    public Response updateCourse(@PathParam("id") UUID id, RequestCourseDto courseDto) {
        ResponseCourseDto updated = coursesService.updateCourse(id, courseDto);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCourse(@PathParam("id") UUID id) {
        coursesService.deleteCourse(id);
        return Response.noContent().build();
    }
}
