package tasktimer;

public class StopWatch {
	private long startTime, stopTime;
	private boolean running;
	
	public void start(){
		startTime = System.nanoTime();
	}
	public void stop(){
		stopTime = System.nanoTime();
	}
	
	public double getElasped(){
		return stopTime - startTime;
	}
}
