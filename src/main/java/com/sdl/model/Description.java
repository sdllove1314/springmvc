package com.sdl.model;

public class Description {
    int did;
    String descdate;
    String petname;
    String description;
    String descdrug;
    String result;
    int resoved;
    int petid;
    int userid;
    int doctorid;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDescdate() {
        return descdate;
    }

    public void setDescdate(String descdate) {
        this.descdate = descdate;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescdrug() {
        return descdrug;
    }

    public void setDescdrug(String descdrug) {
        this.descdrug = descdrug;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getResoved() {
        return resoved;
    }

    public void setResoved(int resoved) {
        this.resoved = resoved;
    }

    public int getPetid() {
        return petid;
    }

    public void setPetid(int petid) {
        this.petid = petid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }
    public Description(){};
    public Description(int did, String descdate, String petname, String description, String descdrug, String result, int resoved, int petid, int userid, int doctorid) {
        this.did = did;
        this.descdate = descdate;
        this.petname = petname;
        this.description = description;
        this.descdrug = descdrug;
        this.result = result;
        this.resoved = resoved;
        this.petid = petid;
        this.userid = userid;
        this.doctorid = doctorid;
    }

    @Override
    public String toString() {
        return "Description{" +
                "did=" + did +
                ", descdate='" + descdate + '\'' +
                ", petname='" + petname + '\'' +
                ", description='" + description + '\'' +
                ", descdrug='" + descdrug + '\'' +
                ", result='" + result + '\'' +
                ", resoved=" + resoved +
                ", petid=" + petid +
                ", userid=" + userid +
                ", doctorid=" + doctorid +
                '}';
    }
}
