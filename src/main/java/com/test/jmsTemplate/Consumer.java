package com.test.jmsTemplate;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    /**
     * 消息队列监听器
     * destination 队列名称
     * containerFactory 监听器容器工厂,若存在2个以上的监听容器工厂,需进行指定
     */
    @JmsListener(destination = "sample.queue", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue1(String msg) {
        System.out.println("Queue Consumer1: " + msg);
    }

    @JmsListener(destination = "sample.queue", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue2(String msg) {
        System.out.println("Queue Consumer2: " + msg);
    }

    @JmsListener(destination = "sample.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic1(String msg) {
        System.out.println("Topic Consumer1: " + msg);
    }

    @JmsListener(destination = "sample.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic2(String msg) {
        System.out.println("Topic Consumer2: " + msg);
    }
}
