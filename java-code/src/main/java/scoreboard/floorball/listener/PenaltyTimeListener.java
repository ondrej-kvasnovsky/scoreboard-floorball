package scoreboard.floorball.listener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import scoreboard.floorball.JScoreboardFrame;
import scoreboard.timer.TimerTask;
import scoreboard.timer.TimerTaskListener;

/**
 * @author Ondrej Kvasnovsky
 */
public class PenaltyTimeListener implements TimerTaskListener {

    /**
     * frame
     */
    private final JScoreboardFrame frame;
    private final JLabel lbl;
    private final TimerTask timer;
    private final JTextField txt;

    /**
     * @param lbl
     * @param jScoreboardFrame TODO
     */
    public PenaltyTimeListener(JScoreboardFrame frame, final JLabel lbl, final JTextField txt, final TimerTask timer) {
        this.frame = frame;
        this.lbl = lbl;
        this.txt = txt;
        this.timer = timer;
    }

    @Override
    public void taskEnded() {
        if (this.timer == getFrame().getTimerGuestPenalty1()) {
            getFrame().getFrameManager().getTxtGuestPenalty1().setText("");
            getFrame().getLblGuestPenalty1().setText(" ");
            getFrame().getMainTimer().removeMainTimerListener(getFrame().getTimerGuestPenalty1());
            getFrame().setTimerGuestPenalty1(null);
        }
        else if (this.timer == getFrame().getTimerGuestPenalty2()) {
            getFrame().getFrameManager().getTxtGuestPenalty2().setText("");
            getFrame().getLblGuestPenalty2().setText(" ");
            getFrame().getMainTimer().removeMainTimerListener(getFrame().getTimerGuestPenalty2());
            getFrame().setTimerGuestPenalty2(null);
        }
        else if (this.timer == getFrame().getTimerHostPenalty1()) {
            getFrame().getFrameManager().getTxtHostPenalty1().setText("");
            getFrame().getLblHostPenalty1().setText(" ");
            getFrame().getMainTimer().removeMainTimerListener(getFrame().getTimerHostPenalty1());
            getFrame().setTimerHostPenalty1(null);
        }
        else if (this.timer == getFrame().getTimerHostPenalty2()) {
            getFrame().getFrameManager().getTxtHostPenalty2().setText("");
            getFrame().getLblHostPenalty2().setText(" ");
            getFrame().getMainTimer().removeMainTimerListener(getFrame().getTimerHostPenalty2());
            getFrame().setTimerHostPenalty2(null);
        }
    }

    @Override
    public void timeChanged() {
        this.lbl.setText(this.timer.toString("m:ss"));
        this.txt.setText(this.timer.toString("m:ss"));
    }

    /**
     * Returns the frame.
     * 
     * @return the frame
     */
    public JScoreboardFrame getFrame() {
        return this.frame;
    }
}