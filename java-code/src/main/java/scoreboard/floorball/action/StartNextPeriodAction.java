/**
 * StartNextPeriodAction.java 16.9.2010
 */
package scoreboard.floorball.action;

import java.awt.event.ActionEvent;

import javax.swing.Icon;

import scoreboard.floorball.JScoreboardManagerFrame;
import scoreboard.floorball.state.StateHolder;

/**
 * @author Kvasnovsky Ondrej
 * 
 */
public class StartNextPeriodAction extends ScoreboardAbstractAction {

    /**
     * @param frame
     * @param name
     * @param icon
     */
    public StartNextPeriodAction(final JScoreboardManagerFrame frame, final String name, final Icon icon) {
        super(frame, name, icon);
    }

    /**
     * @param frame
     * @param name
     */
    public StartNextPeriodAction(final JScoreboardManagerFrame frame, final String name) {
        super(frame, name);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        getFrame().getCurrentMatch().updateMatchData();
        getFrame().getCurrentMatch().startNextPeriod();
        getFrame().setState(StateHolder.STATE_MATCH_STARTED);
    }
}
