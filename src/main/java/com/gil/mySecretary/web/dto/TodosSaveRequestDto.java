package com.gil.mySecretary.web.dto;

import com.gil.mySecretary.domain.todos.Todos;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Optional;

@ToString
@Getter
@NoArgsConstructor
public class TodosSaveRequestDto {
    private String title;
    private LocalDate date;
    private String register;

    @Builder
    public TodosSaveRequestDto(String title, LocalDate date, String register) {
        this.title = title;
        this.date = Optional.ofNullable(date).orElse(LocalDate.now());
        this.register = register;
    }

    public Todos toEntity() {
        return Todos.builder()
                .title(this.title)
                .done(false)
                .date(this.date)
                .register(this.register)
                .build();
    }
}
