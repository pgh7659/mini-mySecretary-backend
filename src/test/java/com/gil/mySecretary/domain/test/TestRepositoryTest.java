package com.gil.mySecretary.domain.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class TestRepositoryTest {
    @Autowired
    TestRepository testRepository;

//    @AfterEach
//    public void cleanup() {
//        testRepository.deleteAll();
//    }

//    @Test
//    @Transactional
//    @Rollback(false)
//    public void saveAndRead() {
//        String title = "Test Title";
//        String content = "Test Content";
//
//        testRepository.save(
//                TestEntity.builder()
//                        .title(title)
//                        .content(content)
//                        .author("Tester")
//                        .build()
//        );
//
//        List<TestEntity> testList = testRepository.findAll();
//        testList.stream().forEach(System.out::println);
//
//        TestEntity test = testList.get(0);
//        assertThat(test.getTitle()).isEqualTo(title);
//        assertThat(test.getContent()).isEqualTo(content);
//    }
}
