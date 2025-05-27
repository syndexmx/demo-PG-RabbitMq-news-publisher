package com.github.syndexmx.demo_rabbit_publish.controller;

import com.github.syndexmx.demo_rabbit_publish.controller.dto.NewsItemDto;
import com.github.syndexmx.demo_rabbit_publish.model.NewsItem;
import com.github.syndexmx.demo_rabbit_publish.service.domain.NewsItemService;
import com.github.syndexmx.demo_rabbit_publish.service.messageBroker.MessageSender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.github.syndexmx.demo_rabbit_publish.controller.mapper.NewsItemDtoMapper.mapItem;

@RestController
public class NewsItemsController {

    private final MessageSender messageSender;
    private final NewsItemService newsItemService;

    public NewsItemsController(MessageSender messageSender, NewsItemService newsItemService) {
        this.messageSender = messageSender;
        this.newsItemService = newsItemService;
    }

    @PostMapping("/api/v0/news-items")
    ResponseEntity<NewsItemDto> createNewsItem(@RequestBody NewsItemDto newsItemDto) {
        NewsItem item = mapItem(newsItemDto);
        messageSender.sendMessage(item);
        final NewsItem savedNewsItem = newsItemService.saveItem(item);
        return new ResponseEntity<>(mapItem(savedNewsItem), HttpStatus.OK);
    }

    @GetMapping("/api/v0/news-items")
    ResponseEntity<List<NewsItemDto>> getAllNewsItems() {
        final List<NewsItemDto> list = newsItemService.findAll().stream()
                .map(item -> mapItem(item))
                .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/api/v0/news-items/{id}")
    ResponseEntity<NewsItemDto> getOneItem(@PathVariable Long id) {
        final NewsItem newsItem = newsItemService.findById(id);
        final NewsItemDto resultItemDto = mapItem(newsItem);
        return new ResponseEntity<>(resultItemDto, HttpStatus.OK);
    }
}
