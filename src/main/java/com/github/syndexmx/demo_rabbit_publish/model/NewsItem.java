package com.github.syndexmx.demo_rabbit_publish.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "news_items")
public class NewsItem {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    String authours;
    String description;
    String text;
    String source;

}
