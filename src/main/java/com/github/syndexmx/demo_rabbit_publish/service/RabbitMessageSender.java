package com.github.syndexmx.demo_rabbit_publish.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.syndexmx.demo_rabbit_publish.model.NewsItem;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Setter
@Slf4j
public class RabbitMessageSender implements MessageSender {

    private final AmqpTemplate amqpTemplate;

    @Value("${newsitem.queuename}")
    private String queueName;

    public RabbitMessageSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void sendMessage(NewsItem item) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(item);
            final LocalDateTime timeStamp = LocalDateTime.now();
            amqpTemplate.convertAndSend(queueName, timeStamp.toString() + " : " + json);
        } catch (JsonProcessingException e) {
            log.warn(e.getMessage());
        }
    }
}
