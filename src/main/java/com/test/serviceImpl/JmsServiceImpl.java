package com.test.serviceImpl;

import com.test.service.JmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author: wuwei
 * @date: 2018/4/25 16:56
 */
@Service
public class JmsServiceImpl implements JmsService {
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public String sendQueue(String msg) {
        jmsMessagingTemplate.convertAndSend(queue, msg);
        return msg + " has been sent to queue successfully!";
    }

    @Override
    public String sendTopic(String msg) {
        jmsMessagingTemplate.convertAndSend(topic, msg);
        return msg + " has been sent to topic successfully!";
    }
}