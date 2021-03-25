package com.gil.mySecretary.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(method = RequestMethod.GET, value = "/naver")
    public ResponseEntity getHelloWorld() {
        System.out.println("hello");
        return ResponseEntity.ok("Hello world!");
    }
}
