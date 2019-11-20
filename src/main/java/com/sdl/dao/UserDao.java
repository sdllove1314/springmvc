package com.sdl.dao;


import com.sdl.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User findAll(int userid);
}
