package com.mcyy.entity;

import java.util.Date;

public class Returns {
    private Date rPasttime;
    private Integer rCount;
    private Date rDate;
    private Integer rId;
    private Integer rMedicineid;

    //Returns2Mapper添加属性
    private Medicine medicine;

    public Returns(Integer rId, Integer rMedicineid, Integer rCount, Date rDate, Date rPasttime, Medicine medicine) {
        this.rId = rId;
        this.rMedicineid = rMedicineid;
        this.rCount = rCount;
        this.rDate = rDate;
        this.rPasttime = rPasttime;
        this.medicine = medicine;
    }

    public Returns() {
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;

    }

    public Integer getrCount() {
        return rCount;
    }

    public void setrCount(Integer rCount) {
        this.rCount = rCount;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getrMedicineid() {
        return rMedicineid;
    }

    public void setrMedicineid(Integer rMedicineid) {
        this.rMedicineid = rMedicineid;
    }

    public Date getrPasttime() {
        return rPasttime;
    }

    public void setrPasttime(Date rPasttime) {
        this.rPasttime = rPasttime;
    }

    @Override
    public String toString() {
        return "Returns{" +
                "rId=" + rId +
                ", rMedicineid=" + rMedicineid +
                ", rCount=" + rCount +
                ", rDate=" + rDate +
                ", rPasttime=" + rPasttime +
                ", medicine=" + medicine +
                '}';
    }
}