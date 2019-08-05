package com.xcy.wedding.controller;

import com.xcy.wedding.pojo.Address;
import com.xcy.wedding.service.addressService;
import com.xcy.wedding.utils.JsonBean;
import com.xcy.wedding.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class addreddController {
    @Autowired
    addressService addressService;
    @RequestMapping("/addr")
    public JsonBean add0rUpdateAddress(HttpServletRequest request, HttpServletResponse response){
        Address address = new Address();
        int id =1 ;

        String longitude = request.getParameter("longitude");
        String latitude = request.getParameter("latitude");

        System.out.println("longitude:"+longitude+"  lat:"+latitude);
       // id = cookie.getValue(id);

        address.setId(id);

           /* address.setLog( Long.valueOf(longitude));
            address.setLat(Long.valueOf(latitude));*/
            address.setLog(longitude);
            address.setLat(latitude);



        addressService.adOUpAddress(address);

        return JsonUtils.createJsonBean(1,"success");
    }
}
