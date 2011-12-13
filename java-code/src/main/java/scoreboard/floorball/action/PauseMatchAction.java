/**
 * PauseMatchAction.java 16.9.2010
 */
package scoreboard.floorball.action;

import java.awt.event.ActionEvent;

import scoreboard.floorball.JScoreboardManagerFrame;
import scoreboard.floorball.state.StateHolder;

/**
 * @author Kvasnovsky Ondrej
 * 
 */
public class PauseMatchAction extends ScoreboardAbstractAction {

    /**
     * @param frame
     * @param name
     */
    public PauseMatchAction(final JScoreboardManagerFrame frame, final String name) {
        super(frame, name);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        getFrame().getCurrentMatch().pauseMatch();
        getFrame().setState(StateHolder.STATE_MATCH_PAUSED);
    }
}
