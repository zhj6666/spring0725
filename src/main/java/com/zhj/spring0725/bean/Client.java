package com.zhj.spring0725.bean;

public class Client {
    private Integer cliId;
    private String  cliNo;
    private String cliName;
    private String cliMan;
    private String cliPhone;
    private String cliAddress;
    private String cliPostbox;
    private String cliBank;
    private String cliBankId;

    @Override
    public String toString() {
        return "Client{" +
                "cliId=" + cliId +
                ", cliNo='" + cliNo + '\'' +
                ", cliName='" + cliName + '\'' +
                ", cliMan='" + cliMan + '\'' +
                ", cliPhone='" + cliPhone + '\'' +
                ", cliAddress='" + cliAddress + '\'' +
                ", cliPostbox='" + cliPostbox + '\'' +
                ", cliBank='" + cliBank + '\'' +
                ", cliBankId='" + cliBankId + '\'' +
                '}';
    }

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public String getCliNo() {
        return cliNo;
    }

    public void setCliNo(String cliNo) {
        this.cliNo = cliNo;
    }

    public String getCliName() {
        return cliName;
    }

    public void setCliName(String cliName) {
        this.cliName = cliName;
    }

    public String getCliMan() {
        return cliMan;
    }

    public void setCliMan(String cliMan) {
        this.cliMan = cliMan;
    }

    public String getCliPhone() {
        return cliPhone;
    }

    public void setCliPhone(String cliPhone) {
        this.cliPhone = cliPhone;
    }

    public String getCliAddress() {
        return cliAddress;
    }

    public void setCliAddress(String cliAddress) {
        this.cliAddress = cliAddress;
    }

    public String getCliPostbox() {
        return cliPostbox;
    }

    public void setCliPostbox(String cliPostbox) {
        this.cliPostbox = cliPostbox;
    }

    public String getCliBank() {
        return cliBank;
    }

    public void setCliBank(String cliBank) {
        this.cliBank = cliBank;
    }

    public String getCliBankId() {
        return cliBankId;
    }

    public void setCliBankId(String cliBankId) {
        this.cliBankId = cliBankId;
    }

    public Client(Integer cliId, String cliNo, String cliName, String cliMan, String cliPhone, String cliAddress, String cliPostbox, String cliBank, String cliBankId) {

        this.cliId = cliId;
        this.cliNo = cliNo;
        this.cliName = cliName;
        this.cliMan = cliMan;
        this.cliPhone = cliPhone;
        this.cliAddress = cliAddress;
        this.cliPostbox = cliPostbox;
        this.cliBank = cliBank;
        this.cliBankId = cliBankId;
    }

    public Client() {

    }
}
