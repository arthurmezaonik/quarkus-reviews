package br.com.fiap.reviews.exceptions;

public class EmailAlreadyRegistered extends RuntimeException {
    public EmailAlreadyRegistered(String message) {
        super(message);
    }
}
