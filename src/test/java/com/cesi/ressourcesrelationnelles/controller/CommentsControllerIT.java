package com.cesi.ressourcesrelationnelles.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommentsControllerIT {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getAllComments() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/comments", String.class);
        assertThat(response.getBody()).isEqualTo("Here are all the comments");
    }
}
