package com.cesi.ressourcesrelationnelles.features.comments;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentService.getList();
    }

    @PostMapping("/comments")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @PutMapping("/comment/{id}")
    public Comment commentService(@RequestBody Comment comment, @PathVariable long id) {
        return commentService.update(comment, id);
    }


    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable long id) {
        commentService.delete(id);
    }


}
