package org.example.twitterclone.service.api;

import org.example.twitterclone.domain.model.User;

public interface AuthService {
    public User register(String username, String email, String password);
    public String login(String email, String password);
}
