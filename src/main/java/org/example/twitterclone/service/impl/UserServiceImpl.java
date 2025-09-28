package org.example.twitterclone.service.impl;

import org.example.twitterclone.domain.model.User;
import org.example.twitterclone.dto.request.UpdateUserRequest;
import org.example.twitterclone.service.api.UserSevice;

public class UserServiceImpl implements UserSevice {
    @Override
    public User getCurrent() {
        return null;
    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public User updateUserProfile(UpdateUserRequest updateUserRequest) {
        return null;
    }

    @Override
    public void follow(String targetId) {

    }

    @Override
    public void unfollow(String targetId) {

    }

    @Override
    public void deleteUser() {

    }
}
