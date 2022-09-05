package com.sjiang2020.jms_activemq_topic_consumer;

import javax.jms.Message;
import javax.jms.MessageListener;

public class EventListener implements MessageListener {

	@Override
	 public void onMessage(Message message) {
        try {
            float price = message.getFloatProperty("price");
            String symbol = message.getStringProperty("symbol");
            System.out.println("Price Update: " + symbol + "[$" + price + "]");
        } catch (Exception e) {
            System.out.println("Worker caught an Exception");
        }
    }
}
