/**
 * MainTimer.java 19.9.2010
 */
package scoreboard.timer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ondrej Kvasnovsky
 */
public class MainTimer extends Thread {

	private final int changedTime = 1000;
	private List<MainTimerListener> mainTimerListener = new ArrayList<MainTimerListener>();
	private boolean suspended = false;

	public MainTimer() {
	}

	public void goBackInTime(int seconds) {
		for (MainTimerListener tl : this.mainTimerListener) {
			tl.goBackInTime(seconds);
		}
	}

	public synchronized void addMainTimerListener(MainTimerListener tl) {
		synchronized (mainTimerListener) {
			this.mainTimerListener.add(tl);
		}
	}

	public void cont() {
		suspended = false;
	}

	public final boolean isSuspended() {
		return suspended;
	}

	public void pause() {
		suspended = true;
	}

	public void removeMainTimerListener(MainTimerListener tl) {
		synchronized (mainTimerListener) {
			final boolean remove = this.mainTimerListener.remove(tl);
			System.out.println(remove);
		}
	}

	public void run() {
		while (Thread.currentThread() == this) {
			try {
				sleep(changedTime);
				if (!suspended) {
					synchronized (mainTimerListener) {
						for (MainTimerListener tl : this.mainTimerListener) {
							tl.timeChanged(changedTime);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}