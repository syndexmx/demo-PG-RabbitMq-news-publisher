package com.github.syndexmx.demo_rabbit_publish.config;

import lombok.Setter;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
public class RabbitConfig {

    @Value("${newsitem.queuename}")
    private String queueName;


    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }

}
