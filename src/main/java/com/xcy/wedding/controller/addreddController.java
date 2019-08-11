package com.xcy.wedding.controller;

import com.xcy.wedding.pojo.Address;
import com.xcy.wedding.service.UserService;
import com.xcy.wedding.service.addressService;
import com.xcy.wedding.utils.JsonBean;
import com.xcy.wedding.utils.JsonUtils;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class addreddController {
    private static int id;
    @Autowired
    addressService addressService;

    @Autowired
    UserService userService;
    @RequestMapping("/addr")
    public JsonBean add0rUpdateAddress(HttpServletRequest request, HttpServletResponse response){
        Address address = new Address();

       /* String value = cookie.getValue();
        int id = Integer.parseInt(value);
        System.out.println("id"+id);*/

        String longitude = request.getParameter("longitude");
        String latitude = request.getParameter("latitude");
        String location = request.getParameter("location");

        System.out.println("longitude:"+longitude+"  lat:"+latitude + "location:"+location);
       // id = cookie.getValue(id);
        Cookie[] cookies = request.getCookies();
        String value = cookies[0].getValue();
        try {
             id = Integer.parseInt(value);
        }catch (Exception e){
            System.out.println("addreddController的异常捕获成功！！！");
        }
        System.out.println("addreddController的id"+id);
        address.setId(id);

           /* address.setLog( Long.valueOf(longitude));
            address.setLat(Long.valueOf(latitude));*/
            address.setLog(longitude);
            address.setLat(latitude);
            address.setLocation(location);

   if(addressService.selectByJW(address)){
        return JsonUtils.createJsonBean(0,"error");
    }

        addressService.adOUpAddress(address);

        return JsonUtils.createJsonBean(1,"success");
    }
}
