package java.com.cesi.ressourcesrelationnelles.test.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cesi.ressourcesrelationnelles.domain.Comment;

class CommentTest {

    @Test
    void createCommentTest() {
        List<Comment> commentList = new ArrayList<>();
        Comment comment = new Comment(1L, "Romain", "Super intéressant !", "Ce document est très intéressant, merci pour le partage.");
        commentList.add(comment);

        assertNotNull(commentList);
        assertEquals("Romain", comment.getAuthor());
        assertEquals("Super intéressant !", comment.getTitle());
        assertEquals("Ce document est très intéressant, merci pour le partage.", comment.getContent());

    }
}
