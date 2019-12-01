package com.sdl.dao;

import com.sdl.model.Drug;
import com.sdl.model.SUserInfo;
import com.sdl.model.User;
import com.sdl.model.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
    /**
     * 查看用户信息
     * @param userid
     * @return
     */
    public UserInfo getInfoByID(int userid);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    public int updateUserInfo(UserInfo userInfo);

    /**
     * 更改密码
     * @param user
     * @return
     */
    public int updateUserPassword(User user);
    /**
     * 查找某类型的所有用户信息
     * @param userType
     * @return
     */
    public List<SUserInfo> findAllUserInfo(String userType);

    /**
     * 根据ID删除用户
     * @param userid
     * @return
     */
    public int delUserbyId(int userid);

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 添加用户信息
     * @param userInfo
     * @return
     */
    public int addUserInfo(UserInfo userInfo);

    /**
     * 添加药品信息
     * @param drug
     * @return
     */
    public int addDrugInfo(Drug drug);

    /**
     * 查看所有药品
     * @return
     */
    public List<Drug> finaAllDrug();
    /**
     * 根据ID查找药品
     * @param gid
     * @return
     */
    public Drug findDrug(int gid);
}
