package com.sdl.service.impl;

import com.sdl.dao.LoginDao;
import com.sdl.model.User;
import com.sdl.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginDao loginDao;
    public User findUser(String username, String userpassword) {
        return loginDao.findUser(username,userpassword);
    }
}
