package com.mcyy.service;

import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/14 16:23
 */
public interface DrugsManagementService {

    //查询药品信息（药品管理页面）
    List<Medicine> DrugsAllMsg(MedicineExample example);

    //添加药品信息（此时没有m_medicineid）
    int InsertDrugMsg(Medicine medicine);

    //查询指定的添加药品，并返回m_id(int)
    int SelectTheDrugId(String m_name , BigDecimal m_price , int m_inventory , Date m_pastdate , String m_classify);

    //更新 medicine表 中 m_medicineid = m_id
    int updateTheDrugId(Medicine record,MedicineExample example);
}
