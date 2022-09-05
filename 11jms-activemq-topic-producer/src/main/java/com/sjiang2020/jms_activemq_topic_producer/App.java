package com.sjiang2020.jms_activemq_topic_producer;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		TickerPublisher producer = new TickerPublisher();
		System.out.print("\n\n\n");
		System.out.println("Starting example Stock Ticker Publisher now...");
		try {
			producer.before();
			producer.run();
			producer.after();
		} catch (Exception e) {
			System.out.println("Caught an exception during the example: " + e.getMessage());
		}
		System.out.println("Finished running the sample Stock Ticker Publisher app.");
		System.out.print("\n\n\n");
	}
}
