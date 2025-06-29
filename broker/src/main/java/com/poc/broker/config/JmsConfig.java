package com.poc.broker.config;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfig {

    @Bean(name = "myConnectionFactory")
    public ConnectionFactory myConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL("tcp://activemq:61616");
        factory.setUserName("admin");
        factory.setPassword("admin");
        return factory;
    }
}
