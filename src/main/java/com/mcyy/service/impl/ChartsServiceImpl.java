package com.mcyy.service.impl;

import com.mcyy.dao.mapper.SalesmessageMapper;
import com.mcyy.entity.Salesmessage;
import com.mcyy.service.ChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/5 19:12
 */
@Service
public class ChartsServiceImpl implements ChartsService {
    @Autowired
    SalesmessageMapper salesmessageMapper;

    //按日期分组，统计当天销售额
    @Override
    public List<Salesmessage> SumByDay() {
        return salesmessageMapper.SumByDay();
    }
    //早晨时段销量
    @Override
    public Integer MorningSell(String morning) {
        return salesmessageMapper.MorningSell(morning);
    }
    //中午时段销量
    @Override
    public Integer NoonSell(String noon) {
        return salesmessageMapper.NoonSell(noon);
    }
    //下午时段销量
    @Override
    public Integer AfternoonSell(String afternoon) {
        return salesmessageMapper.AfternoonSell(afternoon);
    }
    //查询数据库时间
    @Override
    public List<String> SelectSaleTime() {
        return salesmessageMapper.SelectSaleTime();
    }
}
