package br.com.fiap.reviews.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class StudentNotFoundExceptionMapper implements ExceptionMapper<StudentNotFoundException> {

    @Override
    public Response toResponse(StudentNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
            .entity(Map.of("message", exception.getMessage()))
            .build();
    }
}
