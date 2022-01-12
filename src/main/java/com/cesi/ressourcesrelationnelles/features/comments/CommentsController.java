package com.cesi.ressourcesrelationnelles.features.comments;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentsController {

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        List<Comment> commentList = new ArrayList<>();
        Comment comment1 = new Comment(1, "Romain", "Comment 1", "First Comment");
        Comment comment2 = new Comment(2, "Toto", "Comment 2", "Second Comment");
        Comment comment3 = new Comment(3, "Tata", "Comment 3", "Third Comment");

        commentList.add(comment1);
        commentList.add(comment2);
        commentList.add(comment3);
        return commentList;
    }
}
