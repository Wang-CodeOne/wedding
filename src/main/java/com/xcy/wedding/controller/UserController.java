package com.xcy.wedding.controller;

import com.xcy.wedding.pojo.User;
import com.xcy.wedding.pojo.UserVo;
import com.xcy.wedding.service.UserService;
import com.xcy.wedding.utils.JsonBean;
import com.xcy.wedding.utils.JsonUtils;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    private static int aid;
    @Autowired
    UserService userService;
    @RequestMapping("/insertUser")
    public JsonBean login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies = request.getCookies();

        if(cookies==null){
             aid = -1;
        }


        String username = request.getParameter("username");
        String phone = request.getParameter("phone");

        System.out.println("login中的username:"+username+ phone);
        if(username==null || phone==null || username==""||phone==""){

            return JsonUtils.createJsonBean(4,"error");
        }
       /* System.out.println("姓名："+username);
        System.out.println("手机号："+phone);*/

        String permission = "false";


        Date cratetime = new Date();
      //  System.out.println("时间："+cratetime);
        User user = new User();
        user.setUsername(username);
        user.setPhone(phone);
        user.setCreatetime(cratetime);

      //  System.out.println("第一个cookiessss:"+cookies[0]);
        if(cookies[0].equals(" ")) {
            aid =1;
            cookies[0].setValue("aid");
       //     System.out.println("第二个cookiessss:"+cookies[0]);
        }else{

            String value = cookies[0].getValue();
            try {
                aid = Integer.parseInt(value);

            }catch (Exception e){
                System.out.println("捕获.NumberFormatException异常");
            }


            //成功将数据存入到cookie中，下一步从cookie中去值


            aid++;
            System.out.println("aid"+ aid);
            cookies[0].setValue("aid");
            response.addCookie(cookies[0]);
          //  System.out.println("cookie:"+cookies[0]);
        }
        user.setAid(aid);
        //查询数据库看是否有值，如果有则不做插入操作

        int i = userService.insertUser(user);
        if (i == 1) {


            System.out.println("插入数据成功！！");
            permission = "true";
        } else if (i == 0) {
            System.out.println("没有插入数据到数据库中");
            return JsonUtils.createJsonBean(0,"error");
        } else if (i == -1) {
            System.out.println("插入数据已经存在！");
            return JsonUtils.createJsonBean(-1,"error");
        }
        return JsonUtils.createJsonBean(1,"success");
    }
@RequestMapping("/selectUserVo")
    public JsonBean selectUserVo (HttpServletRequest request,HttpServletResponse response){
       String location = request.getParameter("location")+"%";
        String username = request.getParameter("username");
       String phone = request.getParameter("phone");
        String createtime = request.getParameter("createtime")+"%";
        //得到用户名和手机号，如果数据库没有直接插入到数据库中

            request.setAttribute("username",username);
            request.setAttribute("phone",phone);

            try {
                login(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }

        UserVo userVo = new UserVo();
       userVo.setLocation(location);
       userVo.setUsername(username);
       userVo.setPhone(phone);


        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //使用SimpleDateFormat的parse()方法生成Date
            Date date = sf.parse(createtime);
            //打印Date
            userVo.setCreatetime(date);
            System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map map =new HashMap<String ,String>();
        map.put("location",location);
        map.put("createtime",createtime);

    System.out.println("map:"+map.values());

    List<UserVo> userVos = userService.selectByAll(map);
    System.out.println("控制层的userVos："+ userVos);
    return JsonUtils.createJsonBean(1,userVos);
    }


}
