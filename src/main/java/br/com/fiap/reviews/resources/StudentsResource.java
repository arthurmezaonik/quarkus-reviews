package br.com.fiap.reviews.resources;

import br.com.fiap.reviews.entities.dto.request.RequestStudentDto;
import br.com.fiap.reviews.entities.dto.response.ResponseStudentDto;
import br.com.fiap.reviews.services.interfaces.IStudentsService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentsResource {

    @Inject
    IStudentsService studentService;

    @GET
    @Path("/{id}")
    public Response getStudentById(@PathParam("id") UUID id) {
        return Response.ok(studentService.getStudentById(id)).build();
    }

    @GET
    public Response getAllStudents() {
        return Response.ok(studentService.getAllStudents()).build();
    }

    @POST
    public Response createStudent(@Valid RequestStudentDto studentDto) {
        ResponseStudentDto created = studentService.createStudent(studentDto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PATCH
    @Path("/{id}")
    public Response updateStudent(@PathParam("id") UUID id, RequestStudentDto studentDto) {
        ResponseStudentDto updated = studentService.updateStudent(id, studentDto);
        return Response.ok(updated).build();
    }

    @POST
    @Path("/{id}/courses/{courseId}")
    public Response addCourseToStudent(@PathParam("id") UUID id, @PathParam("courseId") UUID courseId) {
        ResponseStudentDto updated = studentService.addCourseToStudent(id, courseId);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}/courses/{courseId}")
    public Response removeCourseFromStudent(@PathParam("id") UUID id, @PathParam("courseId") UUID courseId) {
        ResponseStudentDto updated = studentService.removeCourseFromStudent(id, courseId);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") UUID id) {
        studentService.deleteStudent(id);
        return Response.noContent().build();
    }
}
