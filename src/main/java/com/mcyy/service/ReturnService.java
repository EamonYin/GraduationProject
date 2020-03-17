package com.mcyy.service;

import com.mcyy.entity.*;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/17 11:34
 */
public interface ReturnService {

    //查询退货信息
    List<Returns> SelectAllReturns();
    //插入退货表
    int InsertReturns(Returns record);
    //查询所有药品（medicine表）
    List<Medicine> SelectAllMedicine(MedicineExample example);
    //插入OnSale问题药品表(改为调用OnSaleService中的同名方法)
//    int InsertOnSale(Onsale record);
    //查询对应id的药品库存
    Medicine SelectMedicineById (Integer mId);


}
