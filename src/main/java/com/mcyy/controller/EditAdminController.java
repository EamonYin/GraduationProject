package com.mcyy.controller;

import com.alibaba.fastjson.JSON;
import com.mcyy.entity.User;
import com.mcyy.entity.UserExample;
import com.mcyy.service.impl.EditAdminServiceImpl;
import com.mcyy.service.impl.UserServiceImpl;
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
 * @create 2020/3/18 19:22
 */
@Controller
public class EditAdminController {
    @Autowired
    UserServiceImpl usi;
    @Autowired
    EditAdminServiceImpl easi;

    /**
     * 查询User表并显示
     * @param request
     * @return
     */
    @RequestMapping("/GoEditAdmin")
    public String GoEditAdmin(HttpServletRequest request){
        UserExample userExample = new UserExample();
        List<User> users = usi.SelectUser(userExample);
        HttpSession session = request.getSession();
        session.setAttribute("EditUsersSize",users.size());
        session.setAttribute("EditUsers",users);
        return "Admin-Edit";
    }

    /**
     * 根据要编辑的管理人员id，返回给前台显示该管理人员其他信息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/ShowUserMsg")
    public void ShowUserMsg(HttpServletRequest request , HttpServletResponse response) throws IOException {

        String editAdminId = request.getParameter("EditAdminId");
        //通过id查询用户其他信息
        User user = easi.SelectUserById(Integer.parseInt(editAdminId));
        //以JSON的方式发送给前台
        request.setAttribute("EditUser",user);
        String result = JSON.toJSONString(user);
        System.out.println("樱桃"+result);
        PrintWriter pw = response.getWriter();
        pw.write(result);
        pw.flush();
        pw.close();

    }

    /**
     * 更新更改后的用户信息
     * @param request
     */
    @RequestMapping("/UpDateAdmin")
    public void UpDateAdmin(HttpServletRequest request){
        //获取前台传来的数据
        String uId = request.getParameter("uId");
        String uUsername = request.getParameter("uUsername");
        String uPassword = request.getParameter("uPassword");
        String changeLimit = request.getParameter("ChangeLimit");
        //更新用户信息
        User user = new User();
        user.setuUsername(uUsername);
        user.setuPassword(uPassword);
        user.setuLimit(Integer.parseInt(changeLimit));
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUIdEqualTo(Integer.parseInt(uId));
        easi.UpdateUserById(user,userExample);

//        return "redirect:/GoEditAdmin";
    }

    /**
     * 删除指定id用户
     * @param uId
     * @return
     */
    @RequestMapping("/DeleteAdmin")
    public String DeleteAdmin(String uId){
        easi.DeleteUserById(Integer.parseInt(uId));
        return  "redirect:/GoEditAdmin";
    }

    /**
     * Admin-Add弹出层
     * @return
     */
    @RequestMapping("/GoAdminAddPage")
    public String GoAdminAddPage(){
        return "Admin-Add";
    }

    /**
     * 添加User业务
     * @param request
     * @return
     */
    @RequestMapping("/AddAdmin")
    public String AddAdmin(HttpServletRequest request){
        String uUsername = request.getParameter("uUsername");
        String uPassword = request.getParameter("uPassword");
        String changeAdminLimit = request.getParameter("ChangeAdminLimit");

        User user = new User();
        user.setuUsername(uUsername);
        user.setuPassword(uPassword);
        user.setuLimit(Integer.parseInt(changeAdminLimit));
        usi.AddUser(user);
        return "redirect:/GoEditAdmin";
    }

}
