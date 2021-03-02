package com.gil.mySecretary.web.controller;

import com.gil.mySecretary.domain.todo.TodoEntity;
import com.gil.mySecretary.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/getTodoList")
    public ResponseEntity getTodoListById(@RequestParam String register) {
        return ResponseEntity.ok(
                todoService.getTodoListByRegister(register)
        );
    }

//    @PostMapping("/saveTodo")
//    public ResponseEntity saveTodo(@RequestBody TodoEntity todoEntity) {
//        return ResponseEntity.ok();
//    }
}
