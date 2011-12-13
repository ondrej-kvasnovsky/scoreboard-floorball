package scoreboard.floorball.listener;

import java.io.IOException;
import java.io.InputStream;

import scoreboard.floorball.JScoreboardFrame;
import scoreboard.floorball.state.StateHolder;
import scoreboard.sound.SoundPlayer;
import scoreboard.timer.TimerTaskListener;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class MainTimerTimeListener implements TimerTaskListener {

    /**
     * frame
     */
    private final JScoreboardFrame frame;

    /**
     * Creates new instance.
     * 
     * @param jScoreboardFrame
     */
    public MainTimerTimeListener(final JScoreboardFrame jScoreboardFrame) {
        this.frame = jScoreboardFrame;
    }

    @Override
    public void taskEnded() {
        this.frame.getMainTimer().pause();
        new SoundPlayer().playHorn();
        this.frame.getMainTimer().removeMainTimerListener(this.frame.getMainTimerTask());
        this.frame.setMainTimerTask(null);
        this.frame.getFrameManager().getTxtTime().setText("20:00");
        this.frame.getLblTime().setText("20:00");
        final Integer period = Integer.valueOf(this.frame.getLblPeriod().getText()) + 1;
        this.frame.getFrameManager().getSpinnerPeriod().setValue(period.toString());
        this.frame.getFrameManager().setState(StateHolder.STATE_PERIOD_ENDED);
    }

    @Override
    public void timeChanged() {
        this.frame.getLblTime().setText(this.frame.getMainTimerTask().toString("mm:ss"));
        this.frame.getFrameManager().getTxtTime().setText(this.frame.getMainTimerTask().toString("mm:ss"));
    }
}