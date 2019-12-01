package com.sdl.dao;

import com.sdl.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
    /**
     * 验证登录
     */
    public User findUser(@Param("username") String suername, @Param("userpassword") String userpassword);
}
