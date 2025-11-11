package br.com.fiap.reviews.entities.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UsersDomain {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
}
