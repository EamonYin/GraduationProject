package com.mcyy.dao.mapper;

import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MedicineMapper {
    long countByExample(MedicineExample example);

    int deleteByExample(MedicineExample example);

    int deleteByPrimaryKey(Integer mId);

    int insert(Medicine record);

    int insertSelective(Medicine record);

    List<Medicine> selectByExample(MedicineExample example);

    Medicine selectByPrimaryKey(Integer mId);

    int updateByExampleSelective(@Param("record") Medicine record, @Param("example") MedicineExample example);

    int updateByExample(@Param("record") Medicine record, @Param("example") MedicineExample example);

    int updateByPrimaryKeySelective(Medicine record);

    int updateByPrimaryKey(Medicine record);

    //查询指定的添加药品，并返回m_id(int)
    int SelectTheDrugId(@Param("m_name")String m_name , @Param("m_price")BigDecimal m_price
            , @Param("m_inventory")int m_inventory , @Param("m_pastdate")Date m_pastdate , @Param("m_classify")String m_classify);

    //通过OnSale表中的药品名查找Medicine表中对应的药
    Medicine SelectMedicineByName(@Param("MedicineName") String MedicineName);

}