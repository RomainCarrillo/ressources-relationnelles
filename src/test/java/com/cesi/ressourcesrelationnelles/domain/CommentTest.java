package com.cesi.ressourcesrelationnelles.domain;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommentTest {

    @Test
    public void createCommentTest() {
        List<Comment> commentList = new ArrayList<>();
        Comment comment = new Comment(1, "Romain", "Super intéressant !", "Ce document est très intéressant, merci pour le partage.");
        commentList.add(comment);

        Assert.notNull(commentList);
        assertEquals(1, comment.getId());
        assertEquals("Romain", comment.getAuthor());
        assertEquals("Super intéressant !", comment.getTitle());
        assertEquals("Ce document est très intéressant, merci pour le partage.", comment.getContent());

    }
}
