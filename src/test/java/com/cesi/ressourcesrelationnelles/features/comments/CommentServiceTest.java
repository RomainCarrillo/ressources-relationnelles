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
    private CommentRepository commentRepository;

    @Autowired
    private CommentService commentService;

    @Test
    void createCommentListTest() {
        commentRepository.deleteAll();
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
    void findUsersByAuthor() {
        commentRepository.deleteAll();
        // given
        commentService.create(new Comment("Paul", "Comment 1"));
        commentService.create(new Comment("Romain", "Comment 2"));
        // when
        List<Comment> comments = commentService.getList("Romain", null);
        // then
        assertNotNull(comments);
        assertEquals(1, comments.size());
        assertEquals("Romain", comments.get(0).getAuthor());
    }

    @Test
    void findUsersByAuthorNotFind() {
        commentRepository.deleteAll();
        // given
        commentService.create(new Comment("Paul", "Comment 1"));
        commentService.create(new Comment("Romain", "Comment 2"));
        // when
        List<Comment> comments = commentService.getList("Jack", null);
        // then
        assertNotNull(comments);
        assertEquals(0, comments.size());
    }

    @Test
    void findUsersByTitle() {
        commentRepository.deleteAll();
        // given
        commentService.create(new Comment("Paul", "Comment 1"));
        commentService.create(new Comment("Romain", "Comment 2"));
        // when
        List<Comment> comments = commentService.getList(null, "Comment 1");
        // then
        assertEquals(1, comments.size());
        assertEquals("Comment 1", comments.get(0).getTitle());
    }

    @Test
    void findUsersByTitleNotFind() {
        commentRepository.deleteAll();
        // given
        commentService.create(new Comment("Paul", "Comment 1"));
        commentService.create(new Comment("Romain", "Comment 2"));
        // when
        List<Comment> comments = commentService.getList(null, "Comment 999");
        // then
        assertNotNull(comments);
        assertEquals(0, comments.size());
    }

    @Test
    void findUsersByAuthorAndTitle() {
        commentRepository.deleteAll();
        // given
        commentService.create(new Comment("Paul", "Comment 1"));
        commentService.create(new Comment("Romain", "Comment 2"));
        // when
        List<Comment> comments = commentService.getList("Romain", "Comment 2");
        // then
        assertEquals(1, comments.size());
        assertEquals("Comment 2", comments.get(0).getTitle());
        assertEquals("Romain", comments.get(0).getAuthor());

    }

    @Test
    void findUsersByAuthorAndTitleNotFind() {
        commentRepository.deleteAll();
        // given
        commentService.create(new Comment("Paul", "Comment 1"));
        commentService.create(new Comment("Romain", "Comment 2"));
        commentService.create(new Comment("Jean", "Comment 4"));
        commentService.create(new Comment("Guy", "Comment 999"));

        // when
        List<Comment> comments = commentService.getList("Jean", "Comment 999");
        // then
        assertNotNull(comments);
        assertEquals(0, comments.size());
    }


    @Test
    void findCommentByIdTest() throws Exception {
        commentRepository.deleteAll();
        Comment testComment = commentService.create(new Comment());
        Comment actualComment = commentService.getById(testComment.getId());
        assertNotNull(actualComment);
    }

    @Test
    void findCommentByIdNotExistingTest() {
        commentRepository.deleteAll();
        assertThrowsExactly(NotFoundException.class, () -> {
            Comment testComment = commentService.create(new Comment());
            Comment actualComment = commentService.getById(-27);
            assertNotNull(testComment);
            assertNull(actualComment);
        });
    }

    //TODO add missing test methods delete, update, create

}
