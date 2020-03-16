package com.mcyy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Stock {
    private Integer sId;

    private Integer sMedicineid;

    private Integer sCount;

    private Date sPastdate;

    private BigDecimal sPrice;

    private Date sToday;

    //Stock2Mapper加的属性
    private Medicine medicine;

    public Stock(Integer sId, Integer sMedicineid, Integer sCount, Date sPastdate, BigDecimal sPrice, Date sToday, Medicine medicine) {
        this.sId = sId;
        this.sMedicineid = sMedicineid;
        this.sCount = sCount;
        this.sPastdate = sPastdate;
        this.sPrice = sPrice;
        this.sToday = sToday;
        this.medicine = medicine;
    }

    public Stock() {
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getsMedicineid() {
        return sMedicineid;
    }

    public void setsMedicineid(Integer sMedicineid) {
        this.sMedicineid = sMedicineid;
    }

    public Integer getsCount() {
        return sCount;
    }

    public void setsCount(Integer sCount) {
        this.sCount = sCount;
    }

    public Date getsPastdate() {
        return sPastdate;
    }

    public void setsPastdate(Date sPastdate) {
        this.sPastdate = sPastdate;
    }

    public BigDecimal getsPrice() {
        return sPrice;
    }

    public void setsPrice(BigDecimal sPrice) {
        this.sPrice = sPrice;
    }

    public Date getsToday() {
        return sToday;
    }

    public void setsToday(Date sToday) {
        this.sToday = sToday;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "sId=" + sId +
                ", sMedicineid=" + sMedicineid +
                ", sCount=" + sCount +
                ", sPastdate=" + sPastdate +
                ", sPrice=" + sPrice +
                ", sToday=" + sToday +
                ", medicine=" + medicine +
                '}';
    }
}