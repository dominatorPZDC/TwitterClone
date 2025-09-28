package org.example.twitterclone.service.api;

import org.example.twitterclone.domain.model.User;
import org.example.twitterclone.dto.request.UpdateUserRequest;

public interface UserSevice {
    User getCurrent();
    User getById(String id);
    User updateUserProfile(UpdateUserRequest updateUserRequest);
    void follow(String targetId);
    void unfollow(String targetId);
    void deleteUser();
}
