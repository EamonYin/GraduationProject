package com.mcyy.controller;

import com.mcyy.entity.*;
import com.mcyy.service.impl.OnSaleServiceImpl;
import com.mcyy.service.impl.ReturnServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/17 11:34
 */
@Controller
public class ReturnsController {
    @Autowired
    ReturnServiceImpl rsi;
    @Autowired
    OnSaleServiceImpl ossi;

    /**
     * 跳转ReturnsPage页面，并查询要显示的信息
     * @param request
     * @return
     */
    @RequestMapping("/GoReturnsPage")
    public String GoReturnsPage(HttpServletRequest request){
        List<Returns> returns = rsi.SelectAllReturns();
        HttpSession session = request.getSession();
        session.setAttribute("Returns",returns);
        return "Returns";
    }

    /**
     * 跳转ReturnsAdd页面，并查询能够退货的药品信息
     * @param request
     * @return
     */
    @RequestMapping("/GoReturnsAdd")
    public String GoReturnsAdd(HttpServletRequest request){
        MedicineExample medicineExample = new MedicineExample();
        List<Medicine> medicines = rsi.SelectAllMedicine(medicineExample);
        HttpSession session = request.getSession();
        session.setAttribute("ReturnsDrugs",medicines);
        return "Returns-add";
    }

    /**
     * 退货提交业务
     * @param request
     * @return
     */
    @RequestMapping("/ReturnsAdd")
    public String ReturnsAdd(HttpServletRequest request) throws ParseException {
        //获取前端数据
        String returnsDrugID = request.getParameter("ReturnsDrugID");
        String returnsCount = request.getParameter("ReturnsCount");
        String returnsPrice = request.getParameter("ReturnsPrice");
        String returnsPastDate = request.getParameter("ReturnsPastDate");
        String operator = request.getParameter("Operator");//记录当前操作员
        //将退货信息持久化到数据库Returns表
        Returns returns = new Returns();
        returns.setrMedicineid(Integer.parseInt(returnsDrugID));
        returns.setrCount(Integer.parseInt(returnsCount));
        //格式化时间
        Date today = new Date();
        returns.setrDate(today);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date pasttime = simpleDateFormat.parse(returnsPastDate);
        returns.setrPasttime(pasttime);
        rsi.InsertReturns(returns);
        //根据前台药品id查询对应药品对象
        Medicine medicine = rsi.SelectMedicineById(Integer.parseInt(returnsDrugID));
        //创建退货对象
        Onsale onsale = new Onsale();
        onsale.setoState("退货");
        onsale.setoName(medicine.getmName());
        BigDecimal price = new BigDecimal(returnsPrice);
        onsale.setoPrice(price);
        onsale.setoCount(Integer.parseInt(returnsCount));
        onsale.setoPastdate(pasttime);
        onsale.setoClassify(medicine.getmClassify());
        onsale.setoOperator(operator);//将当前操作员存入OnSale表
        //将退货信息持久化到数据库OnSale表
        ossi.InsertOnSale(onsale);

        return "Returns";
    }

}
