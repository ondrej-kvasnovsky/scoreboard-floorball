/**
 * ShowChronometerAction.java 16.9.2010
 */
package scoreboard.floorball.action;

import java.awt.event.ActionEvent;

import scoreboard.floorball.JScoreboardFrame;
import scoreboard.floorball.JScoreboardManagerFrame;
import scoreboard.floorball.state.StateHolder;

/**
 * @author Kvasnovsky Ondrej
 * 
 */
public class ShowChronometerAction extends ScoreboardAbstractAction {

    /**
     * @param frame
     * @param name
     */
    public ShowChronometerAction(final JScoreboardManagerFrame frame, final String name) {
        super(frame, name);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        final JScoreboardFrame chronometer = new JScoreboardFrame(getFrame());
        getFrame().setCurrentMatch(chronometer);
        chronometer.setVisible(true);
        getFrame().setState(StateHolder.STATE_START_ENABLED);
    }
}
