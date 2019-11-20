package com.sdl.service.impl;

import com.sdl.dao.UserDao;
import com.sdl.model.User;
import com.sdl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    public User findAll(int userid) {
        return userDao.findAll(userid);
    }
}
