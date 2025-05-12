package com.github.syndexmx.demo_rabbit_publish.controller.mapper;

import com.github.syndexmx.demo_rabbit_publish.controller.dto.NewsItemDto;
import com.github.syndexmx.demo_rabbit_publish.model.NewsItem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewsItemDtoMapper {

    public static NewsItemDto mapItem(NewsItem item) {
        return NewsItemDto.builder()
                .id(item.getId())
                .title(item.getTitle())
                .authours(item.getAuthours())
                .source(item.getSource())
                .description(item.getDescription())
                .text(item.getText())
                .build();
    }

    public static NewsItem mapItem(NewsItemDto item) {
        return NewsItem.builder()
                .title(item.getTitle())
                .authours(item.getAuthours())
                .source(item.getSource())
                .description(item.getDescription())
                .text(item.getText())
                .build();
    }

}
