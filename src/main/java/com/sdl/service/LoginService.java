package com.sdl.service;

import com.sdl.model.User;

public interface LoginService {
    public User findUser(String username, String userpassword);
}
