package com.gil.mySecretary.domain.todos;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Entity(name = "todo_table")
@ToString
public class Todos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(nullable = false)
    private Boolean done;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String register;

    @Builder
    public Todos(String title, Boolean done, LocalDate date, String register) {
        this.title = title;
        this.done = done;
        this.date = Optional.ofNullable(date).orElse(LocalDate.now());
        this.register = register;
    }

    public void update(Boolean done) {
        this.done = done;
    }
}
