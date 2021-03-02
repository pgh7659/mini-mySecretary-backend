package com.gil.mySecretary.domain.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    List<TodoEntity> findAllByRegister(String register);
    List<TodoEntity> findAllByDate(LocalDate date);
}
