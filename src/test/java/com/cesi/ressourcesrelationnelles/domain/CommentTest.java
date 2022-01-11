package com.cesi.ressourcesrelationnelles.domain;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommentTest {

    @Test
    public void createCommentTest() {
        Comment comment = new Comment();
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
