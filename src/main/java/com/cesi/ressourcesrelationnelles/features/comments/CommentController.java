package com.cesi.ressourcesrelationnelles.features.comments;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("comments/{id}")
    public Comment getCommentById(@PathVariable long id) {
        try {
            return commentService.getById(id);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping("/comments")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @PutMapping("/comments/{id}")
    public void commentService(@RequestBody Comment comment, @PathVariable long id) {
        commentService.update(comment, id);
    }


    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable long id) {
        commentService.delete(id);
    }


}
