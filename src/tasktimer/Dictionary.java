package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Dictionary {
	public static InputStream getWordsAsStream(){
		  InputStream instream = TaskTimer.class.getClassLoader().getResourceAsStream("wordlist.txt");
		  return instream;
	}
}
