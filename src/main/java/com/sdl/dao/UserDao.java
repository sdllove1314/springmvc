package com.sdl.dao;


import com.sdl.model.Description;
import com.sdl.model.Pet;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    /**
     * 添加宠物
     * @param pet
     * @return
     */
    public int addPet(Pet pet);

    /**
     * 查找用户的userid所有宠物
     * @return
     */
    public List<Pet> findAllPet(int petuserid);

    /**
     * 删除宠物
     * @param petid
     * @return
     */
    public int deltePet(int petid);

    /**
     * 更新宠物信息
     * @param pet
     * @return
     */
    public int updataPetInfo(Pet pet);

    /**
     * 找到一个宠物信息
     * @param petid
     * @return
     */
    public Pet findaPet(int petid);

    /**
     *新建挂号单
     * @param description
     * @return
     */
    public int newDescription(Description description);

    /**
     * 更新挂号单
     * @param description
     * @return
     */
    public int updataDescription(Description description);

    /**
     * 查询所有挂号单
     * @param userid
     * @return
     */
    public List<Description> findAllDescription(int userid);

    /**
     * 删除挂号单
     * @param did
     * @return
     */
    public int delDescription(int did);

    /**
     * 查找完成挂号单
     * @param resoved
     * @return
     */
    public List<Description> findDescresoved(@Param("userid") int userid,@Param("resoved") int resoved);
}
