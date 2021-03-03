package com.gil.mySecretary.web.controller;

import com.gil.mySecretary.web.dto.TodoListRequestDto;
import com.gil.mySecretary.web.dto.TodosResponseDto;
import com.gil.mySecretary.web.dto.TodosSaveRequestDto;
import com.gil.mySecretary.web.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public List<TodosResponseDto> getTodos(@ModelAttribute TodoListRequestDto todoListRequestDto) {
        return todoService.getTodoList(todoListRequestDto);
    }

    @PostMapping
    public Long saveTodo(@RequestBody TodosSaveRequestDto todosSaveRequestDto) {
        return todoService.save(todosSaveRequestDto);
    }
}
