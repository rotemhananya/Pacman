package hw4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class MyTimer {


	// code to maintain listeners
	private ArrayList<TimerListener> listeners;
	private Timer timer ;
	private static MyTimer instance = null;
	// static method to create instance of Singleton class
	public static MyTimer getInstance()
	{
		if (instance == null)
			instance = new MyTimer();

		return instance;
	}
	
	
	// private constructor restricted to this class itself
	private MyTimer()
	{
		listeners = new ArrayList<TimerListener>();
		timer = new Timer(1000,new ActionListener() {
			@Override
	    	public void actionPerformed(ActionEvent arg0) {
	    		int i=0;
	    		while(listeners.size() > i) {
	    			listeners.get(i).action();
	    			i++;
	    		}
			}    
		});
		timer.start();
	}


	public void add(TimerListener listener) {
		listeners.add(listener);
	}
	






}
