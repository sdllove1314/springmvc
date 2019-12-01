package com.sdl.service;

import com.sdl.model.Drug;
import com.sdl.model.SUserInfo;
import com.sdl.model.User;
import com.sdl.model.UserInfo;

import java.util.List;

public interface AdminService {
    public UserInfo getInfoByID(int userid);
    public int updateUserInfo(UserInfo userInfo);
    public int updateUserPassword(User user);
    public List<SUserInfo> findAllUserInfo(String userType);
    public int delUserbyId(int userid);
    public int addUser(User user);
    public int addUserInfo(UserInfo userInfo);
    public int addDrugInfo(Drug drug);
    public Drug findDrug(int gid);
    public List<Drug> finaAllDrug();
}
