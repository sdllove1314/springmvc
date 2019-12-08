package com.sdl.service.impl;

import com.sdl.dao.AdminDao;
import com.sdl.model.Drug;
import com.sdl.model.SUserInfo;
import com.sdl.model.User;
import com.sdl.model.UserInfo;
import com.sdl.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminDao adminDao;
    public UserInfo getInfoByID(int userid) {
        return adminDao.getInfoByID(userid);
    }
    public int updataUserInfo(UserInfo userInfo) {
        return adminDao.updataUserInfo(userInfo);
    }
    public int updataUserPassword(User user) {
        return adminDao.updataUserPassword(user);
    }
    public List<SUserInfo> findAllUserInfo(String userType) {
        return adminDao.findAllUserInfo(userType);
    }
    public int delUserbyId(int userid) {
        return adminDao.delUserbyId(userid);
    }
    public int addUser(User user) {
        return adminDao.addUser(user);
    }
    public int addUserInfo(UserInfo userInfo) {
        return adminDao.addUserInfo(userInfo);
    }
    public int addDrugInfo(Drug drug) {
        return adminDao.addDrugInfo(drug);
    }
    public Drug findDrug(int gid) {
        return adminDao.findDrug(gid);
    }
    public List<Drug> findAllDrug() {
        return adminDao.findAllDrug();
    }
    public int updataDrugInfo(Drug drug) {
        return adminDao.updataDrugInfo(drug);
    }
    public int delteDrug(int gid) {
        return adminDao.delteDrug(gid);
    }
}
