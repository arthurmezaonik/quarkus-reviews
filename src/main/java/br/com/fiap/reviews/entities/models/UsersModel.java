package br.com.fiap.reviews.entities.models;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
public class UsersModel extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name="first_name", length=100, nullable = false)
    private String firstName;

    @Column(name="last_name", length=100, nullable = false)
    private String lastName;

    @Column(nullable = false, unique=true)
    private String email;

    public UsersModel(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
