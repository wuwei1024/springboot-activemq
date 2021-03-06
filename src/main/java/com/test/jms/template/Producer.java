package com.test.jms.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

@Component
@EnableScheduling
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;
    private static int count = 0;

    @Scheduled(initialDelay = 60 * 1000, fixedDelay = 60 * 1000)
    public void sendMsg() {
        jmsMessagingTemplate.convertAndSend(queue, "hi, activeMQ(queue), index=" + count);
        jmsMessagingTemplate.convertAndSend(topic, "hi, activeMQ(topic), index=" + count++);
    }
}
