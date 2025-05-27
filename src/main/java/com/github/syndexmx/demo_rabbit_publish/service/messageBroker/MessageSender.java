package com.github.syndexmx.demo_rabbit_publish.service.messageBroker;

import com.github.syndexmx.demo_rabbit_publish.model.NewsItem;
import org.springframework.stereotype.Service;

@Service
public interface MessageSender {

    void sendMessage(NewsItem item);

}
