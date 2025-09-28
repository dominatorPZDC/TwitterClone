package org.example.twitterclone.service.impl;

import org.example.twitterclone.domain.model.Comment;
import org.example.twitterclone.domain.model.Post;
import org.example.twitterclone.domain.model.User;
import org.example.twitterclone.domain.repository.PostRepository;
import org.example.twitterclone.domain.repository.UserRepository;
import org.example.twitterclone.service.api.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    public final PostRepository postRepository;
    public final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Post createPost(String newContent) {
        return postRepository.save(new Post(getCurrentUserId(), newContent));
    }

    @Override
    public Post updatePost(String postId, String newContent) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post with id " + postId + " does not exist"));
        post.setContent(newContent);
        postRepository.save(post);
        return post;
    }

    @Override
    public void deletePost(String postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public Post likePost(String postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post with id " + postId + " does not exist"));
        post.getLikes().add(getCurrentUserId());
        postRepository.save(post);
        return post;
    }

    @Override
    public Post unlikePost(String postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post with id " + postId + " does not exist"));
        post.getLikes().remove(getCurrentUserId());
        postRepository.save(post);
        return post;
    }

    @Override
    public Post commentPost(String postId, String content) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post with id " + postId + " does not exist"));
        post.getComments().add(new Comment(postId, content));
        postRepository.save(post);
        return null;
    }

    @Override
    public List<Post> getUserFeed() {
        User user = userRepository.findById(getCurrentUserId()).orElseThrow(() -> new IllegalArgumentException("User with id " + getCurrentUserId() + " does not exist"));
        return postRepository.findAllByUserIdInOrderByTimestamp(new ArrayList<>(user.getFollowing()));
    }

    @Override
    public List<Post> getUserPosts(String userId) {
        return postRepository.findAllByUserIdOrderByTimestamp(getCurrentUserId());
    }

    @Override
    public List<Comment> getPostComment(String postId) {
        return postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found")).getComments();
    }

    private String getCurrentUserId() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }
}
