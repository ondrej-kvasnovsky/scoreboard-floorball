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
    private final List<TimerTaskListener> timerTaskListeners = new ArrayList<TimerTaskListener>();

    /**
     * @param time
     */
    public TimerTask(final String time) {
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
    public boolean add(final TimerTaskListener e) {
        return this.timerTaskListeners.add(e);
    }

    /**
     * @return
     */
    public final long getTime() {
        return this.time;
    }

    /**
     * @param time
     */
    public final void setTime(final int time) {
        this.time = time;
    }

    /*
     * (non-Javadoc)
     * 
     * @see scoreboard.floorball.MainTimerListener#timeChanged(int)
     */
    @Override
    public void timeChanged(final int changedTime) {
        if (this.time > 0) {
            this.time -= changedTime;
            for (final TimerTaskListener ttl : this.timerTaskListeners) {
                ttl.timeChanged();
            }
        }
        if (this.time == 0) {
            for (final TimerTaskListener ttl : this.timerTaskListeners) {
                ttl.taskEnded();
            }
        }
    }

    public String toString(final String format) {
        if ("m:ss".equals(format)) {
            return this.formatMss.format(new Date(this.time));
        }
        else {
            return this.formatMmss.format(new Date(this.time));
        }
    }

    @Override
    public void goBackInTime(final int seconds) {
        this.time += (seconds * 1000);
    }
}
