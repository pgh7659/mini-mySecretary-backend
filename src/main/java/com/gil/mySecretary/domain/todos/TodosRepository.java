package com.gil.mySecretary.domain.todos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TodosRepository extends JpaRepository<Todos, Long> {
    List<Todos> findAllByRegister(String register);
    List<Todos> findAllByDate(LocalDate date);
    List<Todos> findAllByRegisterAndDate(String register, LocalDate date);
}
