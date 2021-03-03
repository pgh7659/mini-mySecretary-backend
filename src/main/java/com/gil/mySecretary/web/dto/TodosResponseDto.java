package com.gil.mySecretary.web.dto;

import com.gil.mySecretary.domain.todos.Todos;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class TodosResponseDto {
    private Long id;
    private String title;
    private LocalDate date;
    private String register;

    public TodosResponseDto(Todos todos) {
        this.id = todos.getId();
        this.title = todos.getTitle();
        this.date = todos.getDate();
        this.register = todos.getRegister();
    }
}
