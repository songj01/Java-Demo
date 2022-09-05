package com.sjiang2020.jms_demos;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer2 {
	// URL of the JMS server
	// private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	private static String url = "tcp://localhost:61616";

	// Name of the topic from which we will receive messages from = " testt"

	public static void main(String[] args) throws JMSException {
		// Getting JMS connection from the server

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		System.out.println("Started consumer 2!");
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Topic topic = session.createTopic("testt");

		MessageConsumer consumer = session.createConsumer(topic);

		MessageListener listner = new MessageListener() {
			public void onMessage(Message message) {
				try {
					if (message instanceof TextMessage) {
						TextMessage textMessage = (TextMessage) message;
						System.out.println("2nd Consumer Received message" + new Date(System.currentTimeMillis()) + "::"
								+ textMessage.getText() + "'");
					}
				} catch (JMSException e) {
					System.out.println("Caught:" + e);
					e.printStackTrace();
				}
			}
		};

		consumer.setMessageListener(listner);
		// connection.close();

	}
}
