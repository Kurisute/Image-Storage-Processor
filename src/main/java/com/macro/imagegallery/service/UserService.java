package com.macro.imagegallery.service;

import com.macro.imagegallery.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}