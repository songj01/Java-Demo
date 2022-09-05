package com.sjiang.jms_activemq;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       SimpleJMS example = new SimpleJMS();
       System.out.println("\n\n\n");
       System.out.println("Starting SimpleJMS example now ...");
       
       try {
    	   example.before();
    	   example.run();
    	   example.after();
       }catch(Exception e) {
    	   System.out.println("Caught an exception during the example: " + e.getMessage());
       }
       
       System.out.println("Finished running the SimpleJMS example");
       System.out.println("\n\n\n");
    }
}
