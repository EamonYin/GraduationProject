package com.mcyy.entity;

/**
 * @Author XiaoMing
 * @create 2020/3/14 23:41
 */
public class Client {

    private int cId;
    private String cClientname;
    private String cPassword;
    private String cPhonenum;

    public Client(int cId, String cClientname, String cPassword, String cPhonenum) {
        this.cId = cId;
        this.cClientname = cClientname;
        this.cPassword = cPassword;
        this.cPhonenum = cPhonenum;
    }

    public Client() {
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcClientname() {
        return cClientname;
    }

    public void setcClientname(String cClientname) {
        this.cClientname = cClientname;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getcPhonenum() {
        return cPhonenum;
    }

    public void setcPhonenum(String cPhonenum) {
        this.cPhonenum = cPhonenum;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cId=" + cId +
                ", cClientname='" + cClientname + '\'' +
                ", cPassword='" + cPassword + '\'' +
                ", cPhonenum='" + cPhonenum + '\'' +
                '}';
    }
}
