package java.com.cesi.ressourcesrelationnelles.test.features.comments;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.cesi.ressourcesrelationnelles.domain.Comment;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommentsControllerITTest {

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
