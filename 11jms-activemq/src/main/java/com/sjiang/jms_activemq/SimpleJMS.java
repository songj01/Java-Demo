package com.sjiang.jms_activemq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

public class SimpleJMS {
	
	private final String connectionUri = "tcp://localhost:61616";
	
	private ActiveMQConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Destination destination;
	
	public void before( ) throws Exception {
		connectionFactory = new ActiveMQConnectionFactory(connectionUri);
		connection = connectionFactory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		destination = session.createQueue("MyQueue");	
	}
	
	public void after() throws Exception {
		if(connection !=null) {
			connection.close();
		}
	}
	
	
	public void run() throws Exception{
		MessageProducer producer = session.createProducer(destination);
		 final Logger logger = Logger.getLogger(SimpleJMS.class);
		try {
			TextMessage message = session.createTextMessage();
			message.setText("we sent a message");
			producer.send(message);
		}finally {
			producer.close();
		}
		
		MessageConsumer consumer = session.createConsumer(destination);
		try {
			TextMessage message = (TextMessage) consumer.receive();
//			System.out.println(message.getText());
			
			logger.info(message.getText()); 
		}finally {
			consumer.close();
		}
		
		
		
	}
	

}
