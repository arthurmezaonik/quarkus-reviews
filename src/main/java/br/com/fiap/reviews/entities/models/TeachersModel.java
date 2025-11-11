package br.com.fiap.reviews.entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="teachers")
@PrimaryKeyJoinColumn(name="id")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class TeachersModel extends UsersModel{

    @Column(nullable = false, name="hire_date")
    private LocalDateTime hireDate = LocalDateTime.now();

    public TeachersModel(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }
}
