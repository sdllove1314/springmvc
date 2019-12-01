package com.sdl.model;

import java.math.BigDecimal;
import java.sql.Blob;

public class Drug {
    int gid;
    Object gimage;
    String gname;
    BigDecimal gprice;
    int gnum;
    String gnote;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public Object getGimage() {
        return gimage;
    }

    public void setGimage(Object gimage) {
        this.gimage = gimage;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public BigDecimal getGprice() {
        return gprice;
    }

    public void setGprice(BigDecimal gprice) {
        this.gprice = gprice;
    }

    public int getGnum() {
        return gnum;
    }

    public void setGnum(int gnum) {
        this.gnum = gnum;
    }

    public String getGnote() {
        return gnote;
    }

    public void setGnote(String gnote) {
        this.gnote = gnote;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "gid=" + gid +
                ", gimage=" + gimage +
                ", gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", gnum=" + gnum +
                ", gnote='" + gnote + '\'' +
                '}';
    }
}
