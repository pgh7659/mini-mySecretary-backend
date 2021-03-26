package com.gil.mySecretary.web.controller;

import com.gil.mySecretary.config.auth.CurrentUser;
import com.gil.mySecretary.config.auth.model.UserPrincipal;
import com.gil.mySecretary.web.dto.TodoListRequestDto;
import com.gil.mySecretary.web.dto.TodoUpdateRequestDto;
import com.gil.mySecretary.web.dto.TodosResponseDto;
import com.gil.mySecretary.web.dto.TodosSaveRequestDto;
import com.gil.mySecretary.web.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public List<TodosResponseDto> getTodos(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date, @CurrentUser UserPrincipal userPrincipal) {
        return todoService.getTodoList(new TodoListRequestDto(userPrincipal.getEmail(), date));
    }

    @PostMapping
    public Long saveTodo(@RequestBody TodosSaveRequestDto todosSaveRequestDto, @CurrentUser UserPrincipal userPrincipal) {
        todosSaveRequestDto.changeRegister(userPrincipal.getEmail());

        return todoService.save(todosSaveRequestDto);
    }

    @PutMapping("/{id}")
    public TodosResponseDto updateDone(@PathVariable Long id, @RequestBody TodoUpdateRequestDto todoUpdateRequestDto) {
        return todoService.updateDone(id, todoUpdateRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }
}
