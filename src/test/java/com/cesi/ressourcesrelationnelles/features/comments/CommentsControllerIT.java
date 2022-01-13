package com.cesi.ressourcesrelationnelles.features.comments;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommentsControllerIT {

    @Autowired
    private TestRestTemplate template;

    @Test
    void getAllComments() {
        ResponseEntity<Comment[]> responseEntity = template.getForEntity("/comments", Comment[].class);
        Comment[] commentsArray = responseEntity.getBody();
        List<Comment> commentList = Arrays.stream(commentsArray).collect(Collectors.toList());
        assertTrue(commentList.isEmpty());
    }

}
