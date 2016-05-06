package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import tasktimer.TaskTimer.IntCounter;

/**
	 * Process all the words in a file (one word per line) using BufferedReader
	 * and the lines() method which creates a Stream of Strings (one item per line).  
	 * Then use the stream to compute summary statistics.
	 * In a lambda you cannot access a local variable unless it is final,
	 * so (as a cludge) we use an attribute for the count.
	 * When this method is rewritten as a Runnable, it can be a non-static attribute
	 * of the runnable.
	 * Display summary statistics and elapsed time.
	 */
public class Task3 implements Runnable {
	
	private BufferedReader br = null;
	public Task3(){
		try {
			br = new BufferedReader( new InputStreamReader(Dictionary.getWordsAsStream()) );
		} catch (Exception ex) {
			out.println("Could not open dictionary: "+ex.getMessage());
			return;
		}
	}
	
	public void run(){
		long totalsize = 0;
		long count = 0;
		// This code uses Java's IntStream.average() method.
		// But there is no way to also get the count of items.
		// averageLength = br.lines().mapToInt( (word) -> word.length() )
		//                         .average().getAsDouble();
		// So instead we write out own IntConsumer to count and average the stream,
		// and use our IntConsumer to "consume" the stream.
		IntCounter counter = new IntCounter();
		br.lines().mapToInt( word -> word.length() ).forEach( counter );
		// close the input
		try {
			br.close();
		} catch(IOException ex) { /* ignore it */ }
		out.printf("Average length of %,d words is %.2f\n", counter.getCount(), counter.average() );
	}
	
	public String toString(){
		return "Starting task: read words using BufferedReader and Stream";
	}
}
