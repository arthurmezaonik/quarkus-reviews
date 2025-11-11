package br.com.fiap.reviews.repositories.interfaces;

public interface IUserRepository {
    boolean existsByEmail(String email);
}
