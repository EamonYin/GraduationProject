package com.mcyy.controller;

import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;
import com.mcyy.entity.Onsale;
import com.mcyy.entity.Stock;
import com.mcyy.service.impl.OnSaleServiceImpl;
import com.mcyy.service.impl.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/16 14:39
 */
@Controller
public class StockController {
    @Autowired
    StockServiceImpl ssi;
    @Autowired
    OnSaleServiceImpl ossi;

    /**
     * 前往进货（Stock）页面
     * @return
     */
    @RequestMapping("/GoStockPage")
    public String GoStockPage(HttpServletRequest request){

        List<Stock> stocks = ssi.SelectAllStock();
        HttpSession session = request.getSession();
        session.setAttribute("Stocks",stocks);

        return "Stock";
    }

    /**
     * 前往添加进货页面（Stock-add）
     * @return
     */
    @RequestMapping("/AddStockPage")
    public String AddStockPage(HttpServletRequest request){
        MedicineExample example = new MedicineExample();
        List<Medicine> medicines = ssi.AllMedicine(example);

        HttpSession session = request.getSession();
        session.setAttribute("StockDrugs",medicines);

        return "Stock-add";
    }

    /**
     * 添加进货业务
     * @param
     * @return
     */
    @RequestMapping("/AddStock")
    public void AddStock(HttpServletResponse response ,HttpServletRequest request) throws IOException, ParseException {
        //获取前端stock-add页面的传值
        String drugID = request.getParameter("DrugID");
        String stockCount = request.getParameter("StockCount");
        String stockPrice = request.getParameter("StockPrice");
        String pastDate = request.getParameter("PastDate");
        String operator = request.getParameter("Operator");//记录当前操作员
        //获取前台选中药品状态（1.正常/2.过期/3.库存低/4.临期）
        int state = DrugState(response, Integer.parseInt(drugID));
        //格式化过期时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(pastDate);
        //创建当前药物的stock（进货表）对象
        Stock stock = new Stock();
        stock.setsCount(Integer.parseInt(stockCount));
        stock.setsMedicineid(Integer.parseInt(drugID));
        stock.setsPastdate(date);
        BigDecimal StockPrice = new BigDecimal(stockPrice);//格式化Decimal
        stock.setsPrice(StockPrice);
        Date date1 = new Date();
        stock.setsToday(date1);//上货时间

        //传入下面UpdateTheMedicine方法中所需的药品对象
        MedicineExample medicineExample = new MedicineExample();
        MedicineExample.Criteria criteria = medicineExample.createCriteria();
        criteria.andMIdEqualTo(Integer.parseInt(drugID));
        //创建当前药品的medicine表对象
        Medicine medicine = new Medicine();
        medicine.setmPastdate(date);
        int inventory = Integer.parseInt(stockCount);
        medicine.setmInventory(inventory);
        medicine.setmPrice(StockPrice);
//        medicine.setmId(Integer.parseInt(drugID));

        System.out.println("hahaahhahahahahahah"+medicine+"+++"+medicineExample.toString());

        //查询drugID对应的药品为了获取medicin表中的旧信息插入onsale表
        Medicine medicine1 = ssi.TheMedicine(Integer.parseInt(drugID));

        //创建Onsale表（问题药品/促销药品表）对象
        Onsale onsale = new Onsale();
        onsale.setoName(medicine1.getmName());
        onsale.setoPrice(StockPrice);
        onsale.setoCount(medicine1.getmInventory());
        onsale.setoPastdate(medicine1.getmPastdate());
        onsale.setoClassify(medicine1.getmClassify());
        onsale.setoOperator(operator);//将当前操作员存入OnSale表

        //state =（1.正常/2.过期/3.库存低/4.临期）
        if(state == 2){
            onsale.setoState("过期");
            ossi.InsertOnSale(onsale);
            ssi.UpdateTheMedicin(medicine,medicineExample);
        }
        else if(state == 3){
            onsale.setoState("库存过低");
            ssi.InsertDrugStock(stock);
            ossi.InsertOnSale(onsale);
            ssi.UpdateTheMedicin(medicine,medicineExample);
        }
        else if(state == 4){
            onsale.setoState("临期");
            ssi.InsertDrugStock(stock);
            ossi.InsertOnSale(onsale);
            ssi.UpdateTheMedicin(medicine,medicineExample);
        }
        else{
            MedicineExample medicineExample1 = new MedicineExample();
            ssi.AllMedicine(medicineExample1);
        }


    }

    /**
     * 判断药品处理办法，返回前台
     * @param Drug_id
     * @param response
     * @throws IOException
     */
    @RequestMapping("/OptionDrugState")
    public void OptionDrugState(String Drug_id, HttpServletResponse response) throws IOException {
        DrugState(response,Integer.parseInt(Drug_id));
    }

    /**
     * 工具方法类
     * 通过药品 ID 查询药品状态（1.正常/2.过期/3.库存低/4.临期）
     * @param response ， id
     * @return 药品状态
     */
    public int DrugState(HttpServletResponse response , int id) throws IOException {

//MedicineExample example = new MedicineExample();
//List<Medicine> medicines = ssi.AllMedicine(example);
        //查询药品以获得商品状态
        Medicine medicine = ssi.TheMedicine(id);
        //获取药品状态
//        for (Medicine medicine:medicines) {
            Date pastdate = medicine.getmPastdate();
            Integer inventory = medicine.getmInventory();
            String medicinename = medicine.getmName();

        //获取当前时间
            Date date = new Date();
            int day = (int) ((date.getTime() - pastdate.getTime()) / (1000 * 3600 * 24));
            //判断药品状态
            if(day >= -15 && day <= 0 && inventory > 10){
                medicine.setmState("临期");
                response.getWriter().print(medicinename+" 为“临期”药品，系统将其加入问题药品中处理");
                return 4;
            }else if(day > 0 && inventory > 10){
                medicine.setmState("过期");
                response.getWriter().print(medicinename+" 为“过期”药品，系统将为您清空旧货并上新");
                return 2;
            }else if(day <= 0 && inventory < 11) {
                medicine.setmState("库存过低");
                response.getWriter().print(medicinename+" 为“库存过低”药品，系统将其加入问题药品中处理");
                return 3;
            }else {
                medicine.setmState("正常");
                response.getWriter().print(medicinename+" 药品状态正常，无需进货");
                return 1;
            }

//        }
    }

}
