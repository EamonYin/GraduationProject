package com.mcyy.controller;

import com.mcyy.entity.Onsale;
import com.mcyy.entity.OnsaleExample;
import com.mcyy.service.impl.OnSaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 问题药品页面
 * @Author XiaoMing
 * @create 2020/3/17 10:16
 */
@Controller
public class OnSaleController {
    @Autowired
    OnSaleServiceImpl ossi;

    @RequestMapping("/GoOnsalePage")
    public String GoOnsalePage(HttpServletRequest request){
        OnsaleExample onsaleExample = new OnsaleExample();
        List<Onsale> onsales = ossi.SelectAllOnSale(onsaleExample);
        HttpSession session = request.getSession();
        session.setAttribute("OnSales",onsales);

        return "OnSale";
    }

}
