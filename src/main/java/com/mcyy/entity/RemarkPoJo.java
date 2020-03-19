package com.mcyy.entity;

/**
 * @Author XiaoMing
 * @create 2020/3/19 22:37
 */
public class RemarkPoJo {
    private String drugName;
    private String drugRemark;

    public RemarkPoJo(String drugName, String drugRemark) {
        this.drugName = drugName;
        this.drugRemark = drugRemark;
    }

    public RemarkPoJo() {
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugRemark() {
        return drugRemark;
    }

    public void setDrugRemark(String drugRemark) {
        this.drugRemark = drugRemark;
    }

    @Override
    public String toString() {
        return "RemarkPoJo{" +
                "drugName='" + drugName + '\'' +
                ", drugRemark='" + drugRemark + '\'' +
                '}';
    }
}
