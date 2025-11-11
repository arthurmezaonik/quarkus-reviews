package br.com.fiap.reviews.exceptions;

public class CourseAlreadyRegisteredException extends RuntimeException {
    public CourseAlreadyRegisteredException(String message) {
        super(message);
    }
}
