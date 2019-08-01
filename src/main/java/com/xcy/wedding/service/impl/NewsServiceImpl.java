package com.xcy.wedding.service.impl;

import com.xcy.wedding.mapper.NewsMapper;
import com.xcy.wedding.pojo.News;
import com.xcy.wedding.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsMapper newsMapper;


    @Override
    public List<News> selectAllNews() {
        List<News> list = newsMapper.selectAllNews();
        return list;
    }
}
