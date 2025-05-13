package com.github.syndexmx.demo_rabbit_publish.service;

import com.github.syndexmx.demo_rabbit_publish.model.NewsItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsItemService {

    NewsItem saveItem(NewsItem item);
    List<NewsItem> findAll();
}
