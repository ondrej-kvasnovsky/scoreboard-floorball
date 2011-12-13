/**
 * TimerTask.java 19.9.2010
 */
package scoreboard.timer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kvasnovsky Ondrej
 */
public class TimerTask implements MainTimerListener {

	private final SimpleDateFormat formatMss = new SimpleDateFormat("m:ss");
	private final SimpleDateFormat formatMmss = new SimpleDateFormat("mm:ss");
	private long time = 0;
	private List<TimerTaskListener> timerTaskListeners = new ArrayList<TimerTaskListener>();

	/**
	 * @param time
	 */
	public TimerTask(String time) {
		final String[] split = time.trim().split(":");
		if (split.length == 2) {
			final Integer minutes = Integer.valueOf(split[0]);
			if (minutes > 0) {
				this.time = minutes * 60 * 1000;
			}
			final Integer seconds = Integer.valueOf(split[1]);
			if (seconds > 0) {
				this.time += seconds * 1000;
			}
		}
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(TimerTaskListener e) {
		return timerTaskListeners.add(e);
	}

	/**
	 * @return
	 */
	public final long getTime() {
		return time;
	}

	/**
	 * @param time
	 */
	public final void setTime(int time) {
		this.time = time;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see scoreboard.floorball.MainTimerListener#timeChanged(int)
	 */
	@Override
	public void timeChanged(int changedTime) {
		if (this.time > 0) {
			this.time -= changedTime;
			for (TimerTaskListener ttl : timerTaskListeners) {
				ttl.timeChanged();
			}
		}
		if (this.time == 0) {
			for (TimerTaskListener ttl : timerTaskListeners) {
				ttl.taskEnded();
			}
		}
	}

	public String toString(String format) {
		if ("m:ss".equals(format)) {
			return formatMss.format(new Date(time));
		} else {
			return formatMmss.format(new Date(time));
		}
	}

	@Override
	public void goBackInTime(int seconds) {
		this.time += (seconds * 1000);
	}
}
