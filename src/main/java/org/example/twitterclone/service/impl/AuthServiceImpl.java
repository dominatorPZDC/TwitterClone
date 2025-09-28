package org.example.twitterclone.service.impl;

import org.example.twitterclone.domain.model.User;
import org.example.twitterclone.service.api.AuthService;

public class AuthServiceImpl implements AuthService {
    @Override
    public User register(String username, String email, String password) {
        return null;
    }

    @Override
    public String login(String email, String password) {
        return "";
    }
}
