package org.example.twitterclone.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Document(collection = "post")
public class Post {
    @Id
    private String id;
    private String userId;
    private String content;
    private Set<String> likes;
    private List<Comment> comments;
    private Date timestamp;

}
