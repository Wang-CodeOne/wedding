package com.xcy.wedding.service;

import com.xcy.wedding.pojo.News;
import org.springframework.stereotype.Service;

import java.util.List;


public interface NewsService {
    List<News> selectAllNews();
}
