package com.test.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 生产者
 */
public class Producer {
    /**
     * ActiveMQ服务器地址
     */
    private final static String URL = "tcp://localhost:61616";
    /**
     * 队列名
     */
    private final static String QUEUE_NAME = "queue-name";

    public static void main(String[] args) throws JMSException {
        // 1. 创建ConnectionFactory
        ConnectionFactory factory = new ActiveMQConnectionFactory(URL);
        // 2. 创建Connection
        Connection connection = factory.createConnection();
        // 3. 启动连接
        connection.start();
        // 4. 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5. 创建一个目标
        Queue queue = session.createQueue(QUEUE_NAME);
        // 6. 创建一个生产者
        MessageProducer producer = session.createProducer(queue);
        for (int i = 0; i < 10; i++) {
            // 7. 创建消息
            TextMessage msg = session.createTextMessage("消息" + i);
            // 8. 发布消息
            producer.send(msg);
            System.out.println(msg);
        }
        // 9. 关闭连接
        producer.close();
        session.close();
        connection.close();
    }
}
