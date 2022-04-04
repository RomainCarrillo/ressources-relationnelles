package java.com.cesi.ressourcesrelationnelles.test.features.comments;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import com.cesi.ressourcesrelationnelles.features.comments.CommentRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class CommentsControllerTest {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    private MockMvc mvc;

    @Test
    void getComments() throws Exception {
        commentRepository.save(new Comment());
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/comments").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        List<Comment> responseCommentList = new ObjectMapper().readValue(contentAsString, new TypeReference<>() {
        });

        assertNotNull(responseCommentList);
        assertFalse(isEmpty(responseCommentList));
    }


}
