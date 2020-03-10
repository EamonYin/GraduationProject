package com.mcyy.service;

import com.mcyy.entity.Salesmessage;
import com.mcyy.entity.SalesmessageExample;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/7 19:15
 */
public interface SaleMessageService {
    //查询所有销售信息
    List<Salesmessage> SellectAllSalesmessage();

    //插入销售信息
    int InsertSalemsg(Salesmessage salesmessage);

}
