package com.xcy.wedding.mapper;

import com.xcy.wedding.pojo.User;
import com.xcy.wedding.pojo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selecteByName(String username);

    List<UserVo> selectByAll(Map map);
}