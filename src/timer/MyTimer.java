package Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

/**
 * This class represents ArrayList the hold all of the timer listeners.
 * 
 */
public class MyTimer {
	// code to maintain listeners
	private ArrayList<TimerListener> listeners;
	private Timer timer ;
	private int cnt=0;
	private static MyTimer instance = null;

	/** 
	 * static method to create instance of Singleton class.
	 * 
	 * @param delay - the delay of the timer.
	 * @return - MyTimer instance.
	 */
	public static MyTimer getInstance(){
		if (instance == null)
			instance = new MyTimer();
		return instance;
	}


	/** 
	 * Private constructor restricted to this class.
	 * 
	 * @param delay - the delay of the timer.
	 */
	private MyTimer(){
		listeners = new ArrayList<TimerListener>();
		timer = new Timer(1000,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i=0;
				while(listeners.size() > i) {
					int speed=listeners.get(i).getSpeed();
					if (cnt%speed==0)
						listeners.get(i).action();
					i++;
				}
				cnt++;
			}    
		});
		timer.start();
	}

	/**
	 * This function adds a new TimerListener to the listeners' arrayList.
	 * 
	 * @param listeners -  a new TimerListener to add to the listeners' arrayList.
	 */
	public void add(TimerListener listener) {
		listeners.add(listener);
	}

	/**
	 * This function stops the timer.
	 */
	public void stopTimer() {
		this.timer.stop();
	}

	/**
	 * This function starts the timer.
	 */
	public void startTimer() {
		this.timer.start();
	}
}