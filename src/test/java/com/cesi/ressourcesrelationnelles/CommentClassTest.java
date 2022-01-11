package com.cesi.ressourcesrelationnelles;

import com.cesi.ressourcesrelationnelles.features.comments.CommentClass;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommentClassTest {

    @Test
    public void createCommentTest() {
        CommentClass comment = new CommentClass();
        comment.setId(1);
        comment.setAuthor("Romain");
        comment.setTitle("Super intéressant !");
        comment.setContent("Ce document est très intéressant, merci pour le partage.");

        Assert.notNull(comment);
        assertEquals(1, comment.getId());
        assertEquals("Romain", comment.getAuthor());
        assertEquals("Super intéressant !", comment.getTitle());
        assertEquals("Ce document est très intéressant, merci pour le partage.", comment.getContent());

    }
}
