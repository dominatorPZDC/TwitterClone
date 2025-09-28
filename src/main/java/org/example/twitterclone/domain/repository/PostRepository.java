package org.example.twitterclone.domain.repository;

import org.example.twitterclone.domain.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findAllByUserIdInOrderByTimestamp(List<String> userIds);
    List<Post> findAllByUserIdOrderByTimestamp(String userId);
}
