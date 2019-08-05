package com.xcy.wedding.service;

import com.xcy.wedding.pojo.User;

public interface UserService {
    boolean login(User user);

    int insertUser(User user);

    User selectByName(String name);

}
