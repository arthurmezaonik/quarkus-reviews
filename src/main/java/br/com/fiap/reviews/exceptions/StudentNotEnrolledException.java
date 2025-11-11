package br.com.fiap.reviews.exceptions;

public class StudentNotEnrolledException extends RuntimeException {
    public StudentNotEnrolledException(String message) {
        super(message);
    }
}
