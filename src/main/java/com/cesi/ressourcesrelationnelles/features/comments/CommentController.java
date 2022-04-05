package com.cesi.ressourcesrelationnelles.features.comments;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/comment")
    public ResponseEntity<Comment> getComment(@RequestParam String id) {
        Optional<Comment> comment;
        comment = commentRepository.findById(id);
        return comment.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getComments(@RequestParam(required = false) String resourceId) {
        if(resourceId != null){
            List<Comment> commentList = commentRepository.findCommentsByResource(resourceId);
            if(!commentList.isEmpty())
                return new ResponseEntity<>(commentList, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        // If no argument, get every comments
        else return new ResponseEntity<>(commentRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/createComment")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        try {
            Comment _comment = commentRepository.save(comment);
            return new ResponseEntity<>(_comment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteComment")
    public ResponseEntity<HttpStatus> deleteComment(@RequestParam String id) {
        try {
            commentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
