package com.cesi.ressourcesrelationnelles.features.comments;

import com.cesi.ressourcesrelationnelles.domain.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentBouchon {

    public static List<Comment> getBouchon() {
        List<Comment> commentList = new ArrayList<>();
        Comment comment1 = new Comment(1L, "Romain", "Comment 1", "First Comment");
        Comment comment2 = new Comment(2L, "Toto", "Comment 2", "Second Comment");
        Comment comment3 = new Comment(3L, "Tata", "Comment 3", "Third Comment");

        commentList.add(comment1);
        commentList.add(comment2);
        commentList.add(comment3);
        return commentList;
    }

}
