package com.gil.mySecretary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

//@Component
//public class DatabaseConfig implements ApplicationRunner {
//    @Autowired
//    DataSource dataSource;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        try(Connection connection = dataSource.getConnection()) {
//            System.out.println(connection.getMetaData().getURL());
//            System.out.println(connection.getMetaData().getUserName());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
