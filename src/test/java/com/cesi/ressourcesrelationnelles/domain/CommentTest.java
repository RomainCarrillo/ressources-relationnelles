package com.cesi.ressourcesrelationnelles.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
