package com.github.syndexmx.demo_rabbit_publish.service;

import com.github.syndexmx.demo_rabbit_publish.model.NewsItem;
import com.github.syndexmx.demo_rabbit_publish.repository.NewsItemRepository;
import org.springframework.stereotype.Service;

@Service
public class NewsItemServiceImpl implements NewsItemService {

    private final NewsItemRepository itemRepository;

    public NewsItemServiceImpl(NewsItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public NewsItem saveItem(NewsItem item) {
        return itemRepository.save(item);
    }

}
