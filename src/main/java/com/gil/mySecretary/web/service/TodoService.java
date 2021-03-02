package com.gil.mySecretary.web.service;

import com.gil.mySecretary.domain.todo.TodoEntity;
import com.gil.mySecretary.domain.todo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public List<TodoEntity> getTodoListByRegister(String register) {
        return todoRepository.findAllByRegister(register);
    }

    public List<TodoEntity> getTodoListByDate(LocalDate date) {
        return todoRepository.findAllByDate(date);
    }

//    public boolean save()
}
