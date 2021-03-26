package com.gil.mySecretary.web.controller;

import com.gil.mySecretary.config.auth.CurrentUser;
import com.gil.mySecretary.config.auth.model.UserPrincipal;
import com.gil.mySecretary.domain.todos.Todos;
import com.gil.mySecretary.domain.todos.TodosRepository;
import com.gil.mySecretary.web.dto.TodosResponseDto;
import com.gil.mySecretary.web.dto.TodosSaveRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodosApiControllerTest {
//    @LocalServerPort
//    private int port;

//    @Autowired
//    private TestRestTemplate testRestTemplate;

//    @Autowired
//    private TodosRepository todosRepository;

//    @AfterEach
//    public void clean() {
//        todosRepository.deleteAll();
//    }

//    @Test
//    public void Todos_save() {
//        String title = "new Todo1";
//        @CurrentUser UserPrincipal userPrincipal;
//
//        TodosSaveRequestDto todosSaveRequestDto = TodosSaveRequestDto.builder()
//                .title(title)
//                .register(register)
//                .build();
//
//        String baseurl = "http://localhost:" + port;
//        String saveUrl = baseurl + "/api/todos";
//        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(saveUrl, todosSaveRequestDto, Long.class);
//
//        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Todos> list = todosRepository.findAllByDate(LocalDate.now());
//        System.out.println("Test");
//        System.out.println(list.get(0).toString());
//        String getListByDateUrl = baseurl + "/api/todos?date=2021-03-03";
//        ResponseEntity<List> responseOfListByDate =
//                testRestTemplate.getForEntity(
//                        getListByDateUrl,
//                        List.class
//                        );
//
//        Assertions.assertThat(responseOfListByDate.getStatusCode()).isEqualTo(HttpStatus.OK);
//        Assertions.assertThat(responseOfListByDate.getBody()).toString();
//    }
}
