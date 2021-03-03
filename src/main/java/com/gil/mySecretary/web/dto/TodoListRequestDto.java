package com.gil.mySecretary.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@ToString
public class TodoListRequestDto {
    private String register;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
