package com.test.service;

/**
 * @author: wuwei
 * @date: 2018/4/25 16:53
 */
public interface JmsService {
    String sendQueue(String msg);

    String sendTopic(String msg);
}
