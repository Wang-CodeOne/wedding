package com.xcy.wedding.controller;

import com.xcy.wedding.pojo.User;
import com.xcy.wedding.service.UserService;
import com.xcy.wedding.utils.JsonBean;
import com.xcy.wedding.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/insertUser")
    public JsonBean login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        System.out.println("姓名："+username);
        System.out.println("手机号："+phone);
        boolean permission = false;
        Date cratetime = new Date();
        User user = new User();
        user.setUsername(username);
        user.setPhone(phone);
        user.setCreatetime(cratetime);
        int i = userService.insertUser(user);
        if (i == 1) {
            System.out.println("插入数据成功！！");
            permission = true;
        } else if (i == 0) {
            System.out.println("没有插入数据到数据库中");
            return JsonUtils.createJsonBean(0,"error");
        } else if (i == -1) {
            System.out.println("插入数据已经存在！");
            return JsonUtils.createJsonBean(-1,"error");
        }
        return JsonUtils.createJsonBean(1,"success");
    }

}
