package com.mcyy.service;

import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;
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
    //查询指定id的OnSale表中的药品
    Onsale SelectTheOnSale(Integer oId);
    //修改OnSale的o_count
    int UpdateOnSale(Onsale record,OnsaleExample example);
    //更新medicine表的m_remark
    int UpdateRemark(Medicine record , MedicineExample example);
    //删除指OnSale对象
    int DeleteById(Integer oId);

}
