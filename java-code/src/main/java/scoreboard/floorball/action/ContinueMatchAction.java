package scoreboard.floorball.action;

import java.awt.event.ActionEvent;

import scoreboard.floorball.JScoreboardManagerFrame;
import scoreboard.floorball.state.StateHolder;

/**
 * @author Ondrej Kvasnovsky
 */
public class ContinueMatchAction extends ScoreboardAbstractAction {

    /**
     * @param frame
     * @param name
     */
    public ContinueMatchAction(final JScoreboardManagerFrame frame, final String name) {
        super(frame, name);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        final JScoreboardManagerFrame frame = getFrame();
        frame.getCurrentMatch().continueMatch();
        frame.getCurrentMatch().updateMatchData();
        frame.getCurrentMatch().penaltyToGuest();
        frame.getCurrentMatch().penaltyToHost();
        frame.setState(StateHolder.STATE_MATCH_STARTED);
    }
}
