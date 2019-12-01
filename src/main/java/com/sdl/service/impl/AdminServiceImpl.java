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
    public int updateUserInfo(UserInfo userInfo) {
        return adminDao.updateUserInfo(userInfo);
    }
    public int updateUserPassword(User user) {
        return adminDao.updateUserPassword(user);
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

    public List<Drug> finaAllDrug() {
        return adminDao.finaAllDrug();
    }
}
