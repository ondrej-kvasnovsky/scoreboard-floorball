/**
 * PauseContinueMatchKeyListener.java 20.9.2010
 */
package scoreboard.floorball.listener;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import scoreboard.floorball.JScoreboardManagerFrame;
import scoreboard.floorball.state.StateHolder;

/**
 * @author Kvasnovsky Ondrej
 */
public final class PauseContinueMatchKeyListener implements KeyListener {

    /**
    * 
    */
    private final JScoreboardManagerFrame frame;

    /**
     * @param jScoreboardManagerFrame
     */
    public PauseContinueMatchKeyListener(
            final JScoreboardManagerFrame jScoreboardManagerFrame) {
        this.frame = jScoreboardManagerFrame;
    }

    @Override
    public void keyTyped(final KeyEvent e) {
    }

    @Override
    public void keyReleased(final KeyEvent e) {
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        if (this.frame.getCurrentMatch() != null) {
            System.out.println("key - " + e.getKeyCode());
            if (this.frame.getStateHolder().getState() == StateHolder.STATE_MATCH_PAUSED) {
                if (37 == e.getKeyCode()) {
                    this.frame.getCurrentMatch().goBackInTime(-1);
                }
                if (39 == e.getKeyCode()) {
                    this.frame.getCurrentMatch().goBackInTime(1);
                }
            }
            final int keyCodeSpace = 32;
            if (keyCodeSpace == e.getKeyCode()) {
                if (this.frame.getStateHolder().getState() == StateHolder.STATE_MATCH_STARTED) {
                    this.frame.getPauseMatchAction().actionPerformed(new ActionEvent(
                            this.frame.getBtnPause(), 0, "space pressed"));
                }
                else {
                    this.frame.getContinueMatchAction().actionPerformed(new ActionEvent(
                            this.frame.getBtnContinueMatch(), 0, "space pressed"));
                }
            }
        }
    }
}