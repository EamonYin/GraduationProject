package com.mcyy.service;

import com.mcyy.entity.Onsale;
import com.mcyy.entity.OnsaleExample;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/17 10:16
 */
public interface OnSaleService {

    //插入OnSale表
    int InsertOnSale(Onsale record);
    //查询Onsale表
    List<Onsale> SelectAllOnSale(OnsaleExample example);

}
