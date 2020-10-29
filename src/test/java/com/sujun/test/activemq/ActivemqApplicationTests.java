package com.sujun.test.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.listener.MessageListenerContainer;

import javax.jms.*;

@SpringBootTest
class ActivemqApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void create() throws JMSException {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://192.168.2.202:61617");

        Connection connection = connectionFactory.createConnection();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("user");
        MessageProducer producer = session.createProducer(queue);
        TextMessage textMessage = session.createTextMessage("woshinidie");
        producer.send(textMessage);


        MessageConsumer consumer = session.createConsumer(queue);

        session.close();


    }

}
