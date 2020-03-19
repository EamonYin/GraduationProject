package com.mcyy.controller;

import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;
import com.mcyy.entity.RemarkPoJo;
import com.mcyy.service.MedicineService;
import com.mcyy.service.impl.MedicineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class LoginController {
    @Autowired
    MedicineServiceImpl msi;
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String text(){
        return "login";
    }

    /**
     * 系统welcome页（index页右侧）
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request) throws UnknownHostException {
        //获取当前时间并格式化
        Date date = new Date();
        SimpleDateFormat dateFm = new SimpleDateFormat("yyyy年MM月dd日 EEEE");
        String currSun = dateFm.format(date);
        System.out.println(currSun);
        HttpSession session = request.getSession();
        session.setAttribute("Date",currSun);
        //获取本地IP
        InetAddress LocalIp = Inet4Address.getLocalHost();
        session.setAttribute("IP",LocalIp);

        //创建集合存多个ReMarkPoJo对象<唯一的药名对应多个药名下的信息>
        ArrayList<Object> objects = new ArrayList<>();
        //查询所有药品信息
        MedicineExample medicineExample = new MedicineExample();
        List<Medicine> medicines = msi.selectAll(medicineExample);
        //遍历Medicine
        for (Medicine medicine:medicines) {
            String remark = medicine.getmRemark();
            System.out.println("得得得得得"+remark);
            //如果remark不为空，截取字符串放入ReMarkPoJo
            if(remark!=null){
                //根据 ； 分割字符串
                String[] split = remark.split( ";");
                for (String str:split) {
                    RemarkPoJo remarkPoJo = new RemarkPoJo();
                    remarkPoJo.setDrugName("药品："+medicine.getmName());
                    remarkPoJo.setDrugRemark(str);
                    objects.add(remarkPoJo);
                    System.out.println(str);
                }
            }else {
                System.out.println("该药品暂无信息");
            }

        }
        System.out.println("开心的感觉"+objects);

        session.setAttribute("RemarkMsgs",objects);

        return "welcome";
    }

}
