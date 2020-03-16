package com.mcyy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Onsale {
    private Integer oId;

    private String oName;

    private BigDecimal oPrice;

    private String oCount;

    private String oState;

    private Date oPastdate;

    private String oClassify;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName == null ? null : oName.trim();
    }

    public BigDecimal getoPrice() {
        return oPrice;
    }

    public void setoPrice(BigDecimal oPrice) {
        this.oPrice = oPrice;
    }

    public String getoCount() {
        return oCount;
    }

    public void setoCount(String oCount) {
        this.oCount = oCount == null ? null : oCount.trim();
    }

    public String getoState() {
        return oState;
    }

    public void setoState(String oState) {
        this.oState = oState == null ? null : oState.trim();
    }

    public Date getoPastdate() {
        return oPastdate;
    }

    public void setoPastdate(Date oPastdate) {
        this.oPastdate = oPastdate;
    }

    public String getoClassify() {
        return oClassify;
    }

    public void setoClassify(String oClassify) {
        this.oClassify = oClassify == null ? null : oClassify.trim();
    }

    @Override
    public String toString() {
        return "Onsale{" +
                "oId=" + oId +
                ", oName='" + oName + '\'' +
                ", oPrice=" + oPrice +
                ", oCount='" + oCount + '\'' +
                ", oState='" + oState + '\'' +
                ", oPastdate=" + oPastdate +
                ", oClassify='" + oClassify + '\'' +
                '}';
    }
}