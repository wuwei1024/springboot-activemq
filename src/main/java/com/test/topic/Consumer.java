package com.test.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 持久化的订阅者，可以接受离线消息
 */
public class Consumer {
    private static final String URL = "tcp://localhost:61616";
    private static final String TOPIC_NAME = "topic-name";
    private static final String CLIENT_ID = "client_01";

    public static void main(String[] args) throws JMSException {
        // 1. 创建ConnectionFactory
        ConnectionFactory factory = new ActiveMQConnectionFactory(URL);
        // 2. 创建Connection
        Connection connection = factory.createConnection();
        //客户端ID,持久订阅需要设置
        connection.setClientID(CLIENT_ID);
        // 3. 启动连接
        connection.start();
        // 4. 创建会话
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        // 5. 创建一个主题
        Topic topic = session.createTopic(TOPIC_NAME);
        // 6. 创建一个消费者
        //MessageConsumer consumer = session.createConsumer(dest);
        // 创建持久订阅, 指定客户端ID
        MessageConsumer consumer = session.createDurableSubscriber(topic, CLIENT_ID);
        // 7. 创建一个监听器
        consumer.setMessageListener(message -> {
            TextMessage msg = (TextMessage) message;
            try {
                System.out.println("接收消息为：" + msg.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });
        // 先不关闭，不然还没接收到消息就关闭了
//        consumer.close();
//        session.close();
//        connection.close();
    }
}
