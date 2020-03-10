package com.mcyy.entity;

import java.util.Date;

public class Salesmessage {
    private Integer smId;

    private Integer smMedicineid;

    private Integer smUserid;

    private Date smData;

    private Integer smInventory;

    //Salesmessage2Mapper中添加的两个对象

    private User user;

    private Medicine medicine;

    public Integer getSmId() {
        return smId;
    }

    public void setSmId(Integer smId) {
        this.smId = smId;
    }

    public Integer getSmMedicineid() {
        return smMedicineid;
    }

    public void setSmMedicineid(Integer smMedicineid) {
        this.smMedicineid = smMedicineid;
    }

    public Integer getSmUserid() {
        return smUserid;
    }

    public void setSmUserid(Integer smUserid) {
        this.smUserid = smUserid;
    }

    public Date getSmData() {
        return smData;
    }

    public void setSmData(Date smData) {
        this.smData = smData;
    }

    public Integer getSmInventory() {
        return smInventory;
    }

    public void setSmInventory(Integer smInventory) {
        this.smInventory = smInventory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    @Override
    public String toString() {
        return "Salesmessage{" +
                "smId=" + smId +
                ", smMedicineid=" + smMedicineid +
                ", smUserid=" + smUserid +
                ", smData=" + smData +
                ", smInventory=" + smInventory +
                ", user=" + user +
                ", medicine=" + medicine +
                '}';
    }
}