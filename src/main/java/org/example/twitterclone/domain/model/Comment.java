package org.example.twitterclone.domain.model;

import java.util.UUID;

public class Comment {
    private String id = UUID.randomUUID().toString();
    private String userId;
    private String content;
}
