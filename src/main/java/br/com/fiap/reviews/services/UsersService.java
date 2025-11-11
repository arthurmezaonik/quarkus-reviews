package br.com.fiap.reviews.services;

import br.com.fiap.reviews.repositories.interfaces.IUserRepository;
import br.com.fiap.reviews.services.interfaces.IUsersService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UsersService implements IUsersService {
    @Inject
    IUserRepository userRepository;

    @Override
    public boolean emailAlreadyExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
