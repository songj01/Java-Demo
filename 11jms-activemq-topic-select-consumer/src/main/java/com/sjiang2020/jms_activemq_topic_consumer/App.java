package com.sjiang2020.jms_activemq_topic_consumer;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SelectiveTickerConsumer producer = new SelectiveTickerConsumer();
		System.out.print("\n\n\n");
		System.out.println("Starting example Selective Stock Ticker Consumer now...");
		try {
			producer.before();
			producer.run();
			producer.after();
		} catch (Exception e) {
			System.out.println("Caught an exception during the example: " + e.getMessage());
		}
		System.out.println("Finished running the sample Selective Stock Ticker Consumer app.");
		System.out.print("\n\n\n");
	}

}
