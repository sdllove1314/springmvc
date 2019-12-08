package com.sdl.service.impl;

import com.sdl.dao.UserDao;
import com.sdl.model.Description;
import com.sdl.model.Pet;
import com.sdl.model.User;
import com.sdl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    public int addPet(Pet pet) {
        return userDao.addPet(pet);
    }

    public List<Pet> findAllPet(int petuserid) {
        return userDao.findAllPet(petuserid);
    }

    public int deltePet(int petid) {
        return userDao.deltePet(petid);
    }

    public int updataPetInfo(Pet pet) {
        return userDao.updataPetInfo(pet);
    }

    public Pet findaPet(int petid) {
        return userDao.findaPet(petid);
    }

    public int newDescription(Description description) {
        return userDao.newDescription(description);
    }

    public int updataDescription(Description description) {
        return userDao.updataDescription(description);
    }

    public List<Description> findAllDescription(int userid) {
        return userDao.findAllDescription(userid);
    }

    public int delDescription(int did) {
        return userDao.delDescription(did);
    }

    public List<Description> findDescresoved(int userid, int resoved) {
        return userDao.findDescresoved(userid,resoved);
    }
}
