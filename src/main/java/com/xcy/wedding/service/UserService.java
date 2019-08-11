package com.xcy.wedding.service;

import com.xcy.wedding.pojo.User;
import com.xcy.wedding.pojo.UserVo;

import java.util.List;
import java.util.Map;

public interface UserService {
    boolean login(User user);

    int insertUser(User user);

    User selectByName(String name);

    List<UserVo> selectByAll(Map map);

}
