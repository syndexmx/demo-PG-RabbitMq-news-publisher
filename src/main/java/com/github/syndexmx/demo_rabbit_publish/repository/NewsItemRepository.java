package com.github.syndexmx.demo_rabbit_publish.repository;

import com.github.syndexmx.demo_rabbit_publish.model.NewsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsItemRepository extends JpaRepository<NewsItem, Long> {
}
