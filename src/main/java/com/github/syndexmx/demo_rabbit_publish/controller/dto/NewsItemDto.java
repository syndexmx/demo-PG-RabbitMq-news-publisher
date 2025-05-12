package com.github.syndexmx.demo_rabbit_publish.controller.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class NewsItemDto {

    Long id;

    String title;
    String authours;
    String description;
    String text;
    String source;

}
