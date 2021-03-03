package com.gil.mySecretary.web.service;

import com.gil.mySecretary.domain.todos.Todos;
import com.gil.mySecretary.domain.todos.TodosRepository;
import com.gil.mySecretary.web.dto.TodoListRequestDto;
import com.gil.mySecretary.web.dto.TodosResponseDto;
import com.gil.mySecretary.web.dto.TodosSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodosRepository todosRepository;

    public List<TodosResponseDto> getTodoList(TodoListRequestDto todoListRequestDto) {
        List<Todos> todoList = null;
        if(null != todoListRequestDto.getRegister() && null != todoListRequestDto.getDate()) {
            todoList = todosRepository.findAllByRegisterAndDate(
                    todoListRequestDto.getRegister(),
                    todoListRequestDto.getDate());

        } else if(null != todoListRequestDto.getRegister()) {
            todoList = todosRepository.findAllByRegister(todoListRequestDto.getRegister());

        } else if(null != todoListRequestDto.getDate()) {
            todoList = todosRepository.findAllByDate(todoListRequestDto.getDate());

        } else {
            todoList = todosRepository.findAll();
        }

        return todoList.stream().map(TodosResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Long save(TodosSaveRequestDto todosSaveRequestDto) {
        return todosRepository.save(todosSaveRequestDto.toEntity()).getId();
    }
}
