package com.sdl.model;

public class Pet {
    int petid;
    Object petimage;
    String petname;
    String petbreed;
    String petsex;
    String petage;
    String petweight;
    int userid;

    public int getPetid() {
        return petid;
    }

    public void setPetid(int petid) {
        this.petid = petid;
    }

    public Object getPetimage() {
        return petimage;
    }

    public void setPetimage(Object petimage) {
        this.petimage = petimage;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getPetbreed() {
        return petbreed;
    }

    public void setPetbreed(String petbreed) {
        this.petbreed = petbreed;
    }

    public String getPetsex() {
        return petsex;
    }

    public void setPetsex(String petsex) {
        this.petsex = petsex;
    }

    public String getPetage() {
        return petage;
    }

    public void setPetage(String petage) {
        this.petage = petage;
    }

    public String getPetweight() {
        return petweight;
    }

    public void setPetweight(String petweight) {
        this.petweight = petweight;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petid=" + petid +
                ", petimage=" + petimage +
                ", petname='" + petname + '\'' +
                ", petbreed='" + petbreed + '\'' +
                ", petsex='" + petsex + '\'' +
                ", petage='" + petage + '\'' +
                ", petweight='" + petweight + '\'' +
                ", userid=" + userid +
                '}';
    }
}
