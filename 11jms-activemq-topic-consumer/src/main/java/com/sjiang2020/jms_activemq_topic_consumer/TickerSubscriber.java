package com.sjiang2020.jms_activemq_topic_consumer;

import java.util.concurrent.TimeUnit;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TickerSubscriber {

	private final String connectionUri = "tcp://localhost:61616";
	private ActiveMQConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Destination destination;

	public void before() throws Exception {
		connectionFactory = new ActiveMQConnectionFactory(connectionUri);
		connection = connectionFactory.createConnection();
		connection.setClientID("DurableConsumer3");
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		destination = session.createTopic("EVENTS.QUOTES");
	}

	public void after() throws Exception {
		if (connection != null) {
			connection.close();
		}
	}

	public void run() throws Exception {
		// MessageConsumer consumer = session.createConsumer(destination);
		MessageConsumer consumer = session.createDurableSubscriber((Topic) destination, "DurableConsumer3");
		consumer.setMessageListener(new EventListener());
		TimeUnit.MINUTES.sleep(5);
		connection.stop();
		consumer.close();
	}

}
