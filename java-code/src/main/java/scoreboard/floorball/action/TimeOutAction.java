/**
 * TimeoutAction.java, 13.12.2011 10:43:42 
 */
package scoreboard.floorball.action;

import java.awt.event.ActionEvent;

import javax.swing.Icon;

import scoreboard.floorball.JScoreboardManagerFrame;
import scoreboard.floorball.state.StateHolder;

/**
 * @author kvasnond
 */
public class TimeOutAction extends ScoreboardAbstractAction {

    /**
     * Creates new instance.
     * 
     * @param frame
     * @param name
     */
    public TimeOutAction(JScoreboardManagerFrame frame, String name) {
        super(frame, name);
    }

    /**
     * Creates new instance.
     * 
     * @param frame
     * @param name
     * @param icon
     */
    public TimeOutAction(JScoreboardManagerFrame frame, String name, Icon icon) {
        super(frame, name, icon);
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        final String actionCommand = e.getActionCommand();
        if ("TimeoutGuest".equals(actionCommand)) {
            getFrame().getCurrentMatch().startTimeOutForGuest();
        }
        else if ("TimeoutHost".equals(actionCommand)) {
            getFrame().getCurrentMatch().startTimeOutForHost();
        }
        getFrame().setState(StateHolder.STATE_TIMEOUT);
    }

}
