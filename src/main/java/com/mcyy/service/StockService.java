package com.mcyy.service;

import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;
import com.mcyy.entity.Stock;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/16 17:04
 */
public interface StockService {
    //查询药品以获得商品状态
    List<Medicine> AllMedicine(MedicineExample medicineExample);
    //根据id查询指定药品
    Medicine TheMedicine(Integer mId);
    //更新medicine表的过期时间以及库存（过期/临期/库存低）
    int UpdateTheMedicin(Medicine record,MedicineExample example);
    //异常药品插入Stock表
    int InsertDrugStock(Stock record);
    //查询Stock表
    List<Stock> SelectAllStock();


}
