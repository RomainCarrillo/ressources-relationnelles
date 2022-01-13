package com.cesi.ressourcesrelationnelles.features.comments;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Test
    void createCommentListTest() {
        List<Comment> expectedCommentList = new ArrayList<>();
        Comment comment1 = new Comment(1L, "Romain", "Comment 1", "First Comment");
        Comment comment2 = new Comment(2L, "Toto", "Comment 2", "Second Comment");
        Comment comment3 = new Comment(3L, "Tata", "Comment 3", "Third Comment");

        expectedCommentList.add(comment1);
        expectedCommentList.add(comment2);
        expectedCommentList.add(comment3);

        commentService.createList(expectedCommentList);

        List<Comment> actualCommentList = commentService.getList();

        assertFalse(actualCommentList.isEmpty());
        assertEquals(expectedCommentList.size(), actualCommentList.size());
    }


    @Test
    void findCommentByIdTest() throws Exception {
        Comment testComment = commentService.create(new Comment());
        Comment actualComment = commentService.getById(testComment.getId());
        assertNotNull(actualComment);
    }

    @Test
    void findCommentByIdNotExistingTest() {
        assertThrowsExactly(NotFoundException.class, () -> {
            Comment actualComment = commentService.getById(-27);
        });
    }

    //TODO add missing test methods delete, update, create

}
