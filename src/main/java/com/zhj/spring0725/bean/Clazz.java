package com.zhj.spring0725.bean;

public class Clazz {
    private int claid;
    private String claname;

    public int getClaid() {
        return claid;
    }

    public void setClaid(int claid) {
        this.claid = claid;
    }

    public String getClaname() {
        return claname;
    }

    public void setClaname(String claname) {
        this.claname = claname;
    }

    public Clazz(int claid, String claname) {
        this.claid = claid;
        this.claname = claname;
    }

    public Clazz() {
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "claid=" + claid +
                ", claname='" + claname + '\'' +
                '}';
    }
}
