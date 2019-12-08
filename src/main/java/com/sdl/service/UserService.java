package com.sdl.service;

import com.sdl.model.Description;
import com.sdl.model.Pet;

import java.util.List;

public interface UserService {
    public int addPet(Pet pet);
    public List<Pet> findAllPet(int petuserid);
    public int deltePet(int petid);
    public int updataPetInfo(Pet pet);
    public Pet findaPet(int petid);
    public int newDescription(Description description);
    public int updataDescription(Description description);
    public List<Description> findAllDescription(int userid);
    public int delDescription(int did);
    public List<Description> findDescresoved(int userid,int resoved);
}
