package com.sdl.model;

public class UserInfo {
    int infoid;
    String usersex;
    String usertel;
    String userqq;
    String usernote;
    int userid;

    public int getInfoid() {
        return infoid;
    }

    public void setInfoid(int infoid) {
        this.infoid = infoid;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }

    public String getUserqq() {
        return userqq;
    }

    public void setUserqq(String userqq) {
        this.userqq = userqq;
    }

    public String getUsernote() {
        return usernote;
    }

    public void setUsernote(String usernote) {
        this.usernote = usernote;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    public UserInfo(){};
    public UserInfo(String usersex, String usertel, String userqq, String usernote, int userid) {
        this.usersex = usersex;
        this.usertel = usertel;
        this.userqq = userqq;
        this.usernote = usernote;
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "infoid=" + infoid +
                ", usersex='" + usersex + '\'' +
                ", usertel='" + usertel + '\'' +
                ", userqq='" + userqq + '\'' +
                ", usernote='" + usernote + '\'' +
                ", userid=" + userid +
                '}';
    }
}
