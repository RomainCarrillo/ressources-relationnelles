package com.cesi.ressourcesrelationnelles.features.comments;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cesi.ressourcesrelationnelles.domain.Comment;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    @Query("{'resourceId':?0}")
    List<Comment> findCommentsByResource(String resourceId);
}
