package br.com.fiap.reviews.resources;

import br.com.fiap.reviews.entities.dto.request.RequestTeacherDto;
import br.com.fiap.reviews.entities.dto.response.ResponseTeacherDto;
import br.com.fiap.reviews.services.interfaces.ITeachersService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/teachers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeachersResource {

    @Inject
    ITeachersService teachersService;

    @GET
    @Path("/{id}")
    public Response getTeacherById(@PathParam("id") UUID id) {
        return Response.ok(teachersService.getTeacherById(id)).build();
    }

    @GET
    public Response getAllTeachers() {
        return Response.ok(teachersService.getAllTeachers()).build();
    }

    @POST
    public Response createTeacher(@Valid RequestTeacherDto teacherDto) {
        ResponseTeacherDto created = teachersService.createTeacher(teacherDto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PATCH
    @Path("/{id}")
    public Response updateTeacher(@PathParam("id") UUID id, RequestTeacherDto teacherDto) {
        ResponseTeacherDto updated = teachersService.updateTeacher(id, teacherDto);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeacher(@PathParam("id") UUID id) {
        teachersService.deleteTeacher(id);
        return Response.noContent().build();
    }
}
