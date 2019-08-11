package com.xcy.wedding.pojo;

import java.util.Date;

/**
 * @program: wedding
 * @author: qiang
 * @create: 2019-08-07 00:23
 */
public class UserVo extends User {
    private Integer id;

    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }



    private String phone;

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", aid=" + aid +
                ", createtime=" + createtime +
                ", location='" + location + '\'' +
                '}';
    }

    private Integer aid;

    private Date createtime;

    private String location;



}
