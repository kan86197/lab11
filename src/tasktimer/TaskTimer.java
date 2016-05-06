package tasktimer;

import static java.lang.System.out;

import java.util.Scanner;
import java.io.*;
import java.util.function.IntConsumer;
import java.util.function.Consumer;
import java.util.concurrent.atomic.*;  // hack, using AtomicInteger as accumulator

/**
 * Time how long it takes to perform some tasks
 * using different programming constructs.
 * 
 * TODO Improve this code by restructuring it to eliminate duplicate code.
 */
public class TaskTimer
{
	static InputStream instream = Dictionary.getWordsAsStream();

	/** 
	 * Define a customer Consumer class that computes <b>both</b> the average 
	 * and count of values.
	 * An IntConsumer is a special Consumer interface the has an 'int' parameter 
	 * in accept().
	 */
	static class IntCounter implements IntConsumer {
		// count the values
		public int count = 0;
		// total of the values
		private long total = 0;
		/** accept consumes an int. In this method, count the value and add it to total. */
		public void accept(int value) { count++; total += value; }
		/** Get the average of all the values consumed. */
		public double average() { 
			return (count>0) ? ((double)total)/count : 0.0;
		}
		public int getCount() { return count; }
	}

	/**
	 * Process all the words in a file (one word per line) using BufferedReader
	 * and the lines() method which creates a Stream of Strings (one item per line).  
	 * Then use the stream to compute summary statistics.
	 * This is same as task3, except we use a Collector instead of Consumer.
	 */
	public static void task4( ) {
		// initialize
		
	
		// We want the Consumer to add to the count and total length,
		// but a Lambda can only access local variables (from surrounding scope) if
		// they are final.  That means, we can't use an int, long, or double variable. 
		// So, use AtomicInteger and AtomicLong, which are mutable objects.


	}

	// Limit number of words read.  Otherwise, the next task could be very sloooow.


	/** 
	 * Append all the words from the dictionary to a String.
	 * This shows why you should be careful about using "string1"+"string2".
	 */
	public static void task5( ) {
		// initialize
		
	}

	/** 
	 * Append all the words from the dictionary to a StringBuilder.
	 * Compare how long this takes to appending to String.
	 */
	public static void task6( ) {
		// initialize
	}
	
	public static void execAndPrint(Runnable task){
		StopWatch watch = new StopWatch();
		out.print(task.toString());
		watch.start();
		task.run();
		watch.stop();
		out.printf("Elapsed time is %f sec\n",(watch.getElasped())*1.0E-9 );
	}


	/** Run all the tasks. */
	public static void main(String [] args) {
		execAndPrint(new Task1());
		execAndPrint(new Task2());
		execAndPrint(new Task3());
		execAndPrint(new Task4());
		execAndPrint(new Task5());
		execAndPrint(new Task6());
	}

}
