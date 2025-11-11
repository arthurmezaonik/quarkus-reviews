package br.com.fiap.reviews.entities.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TeachersDomain extends UsersDomain {

    private LocalDateTime hireDate;
}
