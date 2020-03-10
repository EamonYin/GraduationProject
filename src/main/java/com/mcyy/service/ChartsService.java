package com.mcyy.service;

import com.mcyy.entity.Salesmessage;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/5 19:11
 */
public interface ChartsService {

    //按日期分组，统计当天销售额
    List<Salesmessage> SumByDay();

    //早晨时段销量
    Integer MorningSell(String morning);
    //中午时段销量
    Integer NoonSell(String noon);
    //下午时段销量
    Integer AfternoonSell(String afternoon);
    //查询数据库时间
    List<String> SelectSaleTime();
}
