package com.xcy.wedding.mapper;

import com.xcy.wedding.pojo.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {
    List<News> selectAllNews();
}
