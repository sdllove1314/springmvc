package com.sdl.model;

import java.io.Serializable;

public class User implements Serializable {
   Integer userid;
   String usertype;
   String username;
   String userpassword;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public User(Integer userid, String usertype, String username, String userpassword) {
        this.userid = userid;
        this.usertype = usertype;
        this.username = username;
        this.userpassword = userpassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", usertype='" + usertype + '\'' +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                '}';
    }
}
