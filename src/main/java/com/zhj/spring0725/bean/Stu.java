package com.zhj.spring0725.bean;

public class Stu {
    private Integer stuid;
    private String sname;
    private int claid;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getClaid() {
        return claid;
    }

    public void setClaid(int claid) {
        this.claid = claid;
    }

    public Stu() {
    }

    public Stu(Integer stuid, String sname, int claid) {
        this.stuid = stuid;
        this.sname = sname;
        this.claid = claid;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "stuid=" + stuid +
                ", sname='" + sname + '\'' +
                ", claid=" + claid +
                '}';
    }
}
