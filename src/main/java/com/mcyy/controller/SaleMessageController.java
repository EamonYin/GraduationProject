package com.mcyy.controller;

import com.mcyy.entity.*;
import com.mcyy.service.impl.MedicineServiceImpl;
import com.mcyy.service.impl.SaleMessageServiceImpl;
import com.mcyy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @Author XiaoMing
 * @create 2020/3/7 18:22
 */
@Controller
public class SaleMessageController {

    @Autowired
    SaleMessageServiceImpl smsi;
    @Autowired
    UserServiceImpl usi;
    @Autowired
    MedicineServiceImpl msi;

    /**
     * 查询所有销售记录
     * @param request
     * @return 销量页面
     */
    @RequestMapping(value = "/salemessage", method = {RequestMethod.GET, RequestMethod.POST})
    public String SaleMessage(HttpServletRequest request) {
        List<Salesmessage> salesmessages = smsi.SellectAllSalesmessage();

        HttpSession session = request.getSession();
        session.setAttribute("salesmessages", salesmessages);
        System.out.println(salesmessages);

        return "SaleMessage";
    }

    /**
     * 为salemessage-add页面提供数据
     * @param request
     * @return
     */
    @RequestMapping(value = "/addsalemessage", method = {RequestMethod.GET, RequestMethod.POST})
    public String AddSaleMessage(HttpServletRequest request){

        /*查询所有注册用户名以及用户id*/
        UserExample userExample = new UserExample();
        List<User> users = usi.SelectUser(userExample);

        HttpSession session = request.getSession();
        session.setAttribute("users", users);

        /*查询所有注册药品名以及药品id*/
        MedicineExample medicineExample = new MedicineExample();
        List<Medicine> medicines = msi.selectAll(medicineExample);
        session.setAttribute("medicines", medicines);

        return "salemessage-add";
    }

    @RequestMapping(value = "/submitting_add", method = {RequestMethod.GET, RequestMethod.POST})
    public void submitting(HttpServletRequest request) throws ParseException {

        //数据库salemessage表存的是用户id和药名id，所以，此处获取的是id
        String userName_id = request.getParameter("UserName_id");
        String drugName_id = request.getParameter("DrugName_id");
        String purchased = request.getParameter("Purchased");
        String salesTime = request.getParameter("SalesTime");

        System.out.println("哆啦A梦"+userName_id+","+drugName_id+","+purchased+","+salesTime);

        //字符串时间转date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = simpleDateFormat.parse(salesTime);


        Salesmessage salesmessage = new Salesmessage();
        salesmessage.setSmInventory(Integer.parseInt(purchased));
        salesmessage.setSmMedicineid(Integer.parseInt(drugName_id));
        salesmessage.setSmUserid(Integer.parseInt(userName_id));
        salesmessage.setSmData(date);

        smsi.InsertSalemsg(salesmessage);

//        return "SaleMessage";
    }

}
