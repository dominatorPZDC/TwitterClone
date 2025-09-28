package org.example.twitterclone.service.api;

import org.example.twitterclone.domain.model.Comment;
import org.example.twitterclone.domain.model.Post;

import java.util.List;

public interface PostService {
    Post createPost(String newContent);
    Post updatePost(String postId, String newContent);
    void deletePost(String postId);
    Post likePost(String postId);
    Post unlikePost(String postId);
    Post commentPost(String postId, String content);
    List<Post> getUserFeed();
    List<Post> getUserPosts(String userId);
    List<Comment> getPostComment(String postId);
}
