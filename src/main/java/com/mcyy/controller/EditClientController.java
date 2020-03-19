package com.mcyy.controller;

import com.alibaba.fastjson.JSON;
import com.mcyy.entity.Client;
import com.mcyy.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/18 22:37
 */
@Controller
public class EditClientController {
    @Autowired
    ClientServiceImpl csi;

    /**
     * 查询所有Client信息，并显示到页面
     * @param request
     * @return
     */
    @RequestMapping("/GoClientPage")
    public String GoClientPage(HttpServletRequest request){
        List<Client> clients = csi.SelectAllClient();
        HttpSession session = request.getSession();
        session.setAttribute("Clients",clients);
        return "Client-Edit";
    }

    /**
     * 根据要编辑的Client_id，返回给前台显示该Client其他信息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/ShowClientMsg")
    public void ShowClientMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String editClientId = request.getParameter("EditClientId");
        Client client = csi.SelectClientById(Integer.parseInt(editClientId));
        request.setAttribute("EditClient",client);
        String result = JSON.toJSONString(client);
        System.out.println("樱桃"+result);
        PrintWriter pw = response.getWriter();
        pw.write(result);
        pw.flush();
        pw.close();
    }

    /**
     * 更改修改后的Client信息
     * @param request
     */
    @RequestMapping("/UpDateClient")
    public void UpDateClient(HttpServletRequest request){
        //获取前台传来的数据
        String cId = request.getParameter("cId");
        String cClientname = request.getParameter("cClientname");
        String cPassword = request.getParameter("cPassword");
        String cPhonenum = request.getParameter("cPhonenum");
        System.out.println("大菠萝"+cId);
        //更新用户信息
        Client client = new Client();
        client.setcClientname(cClientname);
        client.setcPassword(cPassword);
        client.setcPhonenum(cPhonenum);
        csi.UpDateClientById(client,Integer.parseInt(cId));
    }

    /**
     * 删除指定 id Client
     * @param uId
     * @return
     */
    @RequestMapping("/DeleteClient")
    public String DeleteClient(String uId){
        System.out.println("大萝卜"+uId);
        csi.DeleteClientById(Integer.parseInt(uId));
        return "redirect:/GoClientPage";
    }

}
