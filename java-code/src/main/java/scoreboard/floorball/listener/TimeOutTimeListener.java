/**
 * TimeOutTimeListener.java, 13.12.2011 15:21:28 
 */
package scoreboard.floorball.listener;

import scoreboard.floorball.JScoreboardFrame;
import scoreboard.floorball.state.StateHolder;
import scoreboard.sound.SoundPlayer;
import scoreboard.timer.MainTimer;
import scoreboard.timer.TimerTaskListener;

/**
 * @author kvasnond
 */
public class TimeOutTimeListener implements TimerTaskListener {

    public enum Type {
        Host, Guest
    }

    /**
     * frame
     */
    private final JScoreboardFrame frame;
    private final Type type;

    /**
     * Creates new instance.
     * 
     * @param frame
     */
    public TimeOutTimeListener(final JScoreboardFrame frame, Type type) {
        this.frame = frame;
        this.type = type;
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.timer.TimerTaskListener#taskEnded()
     */
    @Override
    public void taskEnded() {
        new SoundPlayer().playHorn();
        this.frame.getLblTimeOut().setText("");
        this.frame.getLblTimeOutGuest().setText("");
        this.frame.getLblTimeOutHost().setText("");
        this.frame.getFrameManager().setState(StateHolder.STATE_MATCH_PAUSED);
        this.frame.getTimeoutTimer().pause();
        this.frame.setTimeoutTimer(null);
        this.frame.setTimeoutTimer(new MainTimer());
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.timer.TimerTaskListener#timeChanged()
     */
    @Override
    public void timeChanged() {
        switch (type) {
            case Host:
                this.frame.getLblTimeOut().setText(this.frame.getTimerTimeOutHost().toString("mm:ss"));
                break;
            case Guest:
                this.frame.getLblTimeOut().setText(this.frame.getTimerTimeOutGuest().toString("mm:ss"));
                break;
        }
    }

}
