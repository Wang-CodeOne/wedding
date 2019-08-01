package com.xcy.wedding.controller;

import com.xcy.wedding.pojo.News;
import com.xcy.wedding.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class newsController {

    @Autowired
    NewsService newsService;

    @RequestMapping("selectAllNews")
    @ResponseBody
    public Object selectAllNews() {

        List<News> newsList = newsService.selectAllNews();


        return newsList;
    }

}
