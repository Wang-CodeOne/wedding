package com.xcy.wedding.service.impl;

import com.xcy.wedding.mapper.UserMapper;
import com.xcy.wedding.pojo.User;
import com.xcy.wedding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public boolean login(User user) {
        Integer id = user.getId();
        User user1 = userMapper.selectByPrimaryKey(id);
        if(user1 != null){
            return true;
        }
        return false;
    }

    @Override
    public int insertUser(User user) {
        String username = user.getUsername();
      User user1 = userMapper.selecteByName(username);
      if(user1 !=null) {
          String phone1 = user1.getPhone();

        if (phone1.equals(user.getPhone())){
            return -1;
        }else {

        int insert = userMapper.insert(user);
            System.out.println("插入的行数："+ insert);
            return insert;
        }
      }else {

          int insert = userMapper.insert(user);
          System.out.println("插入的行数："+ insert);
          return insert;
      }

    }

    @Override
    public User selectByName(String name) {
        return null;
    }


}
