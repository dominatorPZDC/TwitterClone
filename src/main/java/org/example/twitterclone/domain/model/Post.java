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

    public Post(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<String> getLikes() {
        return likes;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
