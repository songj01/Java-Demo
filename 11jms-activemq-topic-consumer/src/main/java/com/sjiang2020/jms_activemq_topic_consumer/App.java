package com.sjiang2020.jms_activemq_topic_consumer;

/**
 * Hello world!
 *
 */
public class App 
{
	 public static void main(String[] args) {
	        TickerSubscriber producer = new TickerSubscriber();
	        System.out.print("\n\n\n");
	        System.out.println("Starting example Stock Ticker Subscriber now...");
	        try {
	            producer.before();
	            producer.run();
	            producer.after();
	        } catch (Exception e) {
	            System.out.println("Caught an exception during the example: " + e.getMessage());
	        }
	        System.out.println("Finished running the sample Stock Ticker Subscriber app.");
	        System.out.print("\n\n\n");
	    }
}
