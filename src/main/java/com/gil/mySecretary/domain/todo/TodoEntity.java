package com.gil.mySecretary.domain.todo;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;

@Entity
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String register;

    @Builder
    public TodoEntity(String title, LocalDate date, String register) {
        this.title = title;
        this.date = Optional.ofNullable(date).orElse(LocalDate.now());
        this.register = register;
    }

}
