package br.com.fiap.reviews.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class StudentsRegiteredToCourseExceptionMapper implements ExceptionMapper<StudentsRegiteredToCourseException> {
    @Override
    public Response toResponse(StudentsRegiteredToCourseException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(Map.of("message", exception.getMessage()))
            .build();

    }
}
