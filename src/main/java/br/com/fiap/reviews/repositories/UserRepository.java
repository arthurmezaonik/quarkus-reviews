package br.com.fiap.reviews.repositories;

import br.com.fiap.reviews.entities.models.UsersModel;
import br.com.fiap.reviews.repositories.interfaces.IUserRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class UserRepository implements IUserRepository, PanacheRepositoryBase<UsersModel, UUID> {

    @Override
    public boolean existsByEmail(String email) {
        return find("email", email).firstResultOptional().isPresent();
    }
}
