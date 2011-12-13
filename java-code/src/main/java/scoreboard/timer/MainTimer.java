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
    private final List<MainTimerListener> mainTimerListener = new ArrayList<MainTimerListener>();
    private boolean suspended = false;

    public MainTimer() {
    }

    public void goBackInTime(final int seconds) {
        for (final MainTimerListener tl : this.mainTimerListener) {
            tl.goBackInTime(seconds);
        }
    }

    public synchronized void addMainTimerListener(final MainTimerListener tl) {
        synchronized (this.mainTimerListener) {
            this.mainTimerListener.add(tl);
        }
    }

    public void cont() {
        this.suspended = false;
    }

    public final boolean isSuspended() {
        return this.suspended;
    }

    public void pause() {
        this.suspended = true;
    }

    public void removeMainTimerListener(final MainTimerListener tl) {
        synchronized (this.mainTimerListener) {
            final boolean remove = this.mainTimerListener.remove(tl);
            System.out.println(remove);
        }
    }

    @Override
    public void run() {
        while (Thread.currentThread() == this) {
            try {
                sleep(this.changedTime);
                if (!this.suspended) {
                    synchronized (this.mainTimerListener) {
                        for (final MainTimerListener tl : this.mainTimerListener) {
                            tl.timeChanged(this.changedTime);
                        }
                    }
                }
            }
            catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }
}