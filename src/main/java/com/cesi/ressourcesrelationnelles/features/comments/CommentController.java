package com.cesi.ressourcesrelationnelles.features.comments;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cesi.ressourcesrelationnelles.domain.Comment;


@RestController
public class CommentController {

	
    private CommentRepository commentRepository;

    Logger logger = LoggerFactory.getLogger(CommentController.class);


    @GetMapping("/comments")
    public List<Comment> getAllComments(@RequestParam(required = false) String author, @RequestParam(required = false) String title) {
 //       if (author != null || title != null) {
 //           return commentRepository.getList(author, title);
 //       } else {
            return commentRepository.findAll();
 //       }
    }


    @GetMapping("comments/{id}")
    public Optional<Comment> getCommentById(@PathVariable long id) {
        return commentRepository.findById(id);
    }

    @PostMapping("/comments")
    public Comment addComment(@RequestBody Comment comment) {
        return commentRepository.insert(comment);
    }

//    @PutMapping("/comments/{id}")
//    public void commentService(@RequestBody Comment comment, @PathVariable long id) {
//        commentRepository.update(comment, id);
//    }


    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable long id) {
        commentRepository.deleteById(id);
    }


}
