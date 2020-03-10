package com.mcyy.controller;

import com.mcyy.entity.Salesmessage;
import com.mcyy.service.impl.ChartsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/5 19:09
 */
@RequestMapping(value = "/charts")
@Controller
public class ChartsController {
    @Autowired
    ChartsServiceImpl csi;

    /**
     * 跳转月销量柱状图页
     * @return
     */
    @RequestMapping(value = "/gomonthly" , method = {RequestMethod.POST, RequestMethod.GET})
    public String GoMonthly(){
        return "MonthlyChart";
    }

    /**
     * 发送月销量柱状图所需Json
     * @return 月销量
     */
    @RequestMapping(value = "/monthlychart" , method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List<Salesmessage> MonthlyChart() {
        List<Salesmessage> salesmessages = csi.SumByDay();
        return salesmessages;
    }

    /**
     * 跳转日销量柱状图页
     * @param request
     * @param response
     * @return 日销量页
     */
    @RequestMapping(value = "/goday", method = {RequestMethod.POST, RequestMethod.GET})
    public String testcontroller2(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        List<String> time = csi.SelectSaleTime();
        session.setAttribute("seltime", time);

        return "DayChart";
    }

    /**
     * 发送日销量柱状图所需Json
     * @param response
     * @param changetime
     * @return 选定日期的销售额集合
     */
    @RequestMapping(value = "/daychart", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List<HashMap<Object, Object>> TestChartDay(HttpServletResponse response, String changetime) {

        if (changetime.equals("changetime") || changetime == "") {
            changetime = "2019-09-01";
        }

        String today = changetime;
        HashMap<Object, Object> mapmor = new HashMap<>();
        HashMap<Object, Object> mapnoon = new HashMap<>();
        HashMap<Object, Object> mapafter = new HashMap<>();
        List<HashMap<Object, Object>> list = new ArrayList<>();

        Integer salesmessagesMor = csi.MorningSell(today);
        mapmor.put("name", "上午");
        mapmor.put("value", salesmessagesMor);
        list.add(mapmor);

        Integer salesmessagesNoon = csi.NoonSell(today);
        mapnoon.put("name", "中午");
        mapnoon.put("value", salesmessagesNoon);
        list.add(mapnoon);

        Integer salesmessagesAfter = csi.AfternoonSell(today);
        mapafter.put("name", "下午");
        mapafter.put("value", salesmessagesAfter);
        list.add(mapafter);

        System.out.println(list);

        return list;
    }

}
