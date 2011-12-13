/**
 * GoBackInTimeAction.java 19.9.2010
 */
package scoreboard.floorball.action;

import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import scoreboard.floorball.JScoreboardManagerFrame;

/**
 * @author Kvasnovsky Ondrej
 * 
 */
public class GoBackInTimeAction extends ScoreboardAbstractAction {

    /**
    * 
    */
    private static final long serialVersionUID = 3339010344298186098L;

    /**
     * @param frame
     * @param name
     */
    public GoBackInTimeAction(final JScoreboardManagerFrame frame, final String name) {
        super(frame, name);
    }

    /**
     * @param frame
     * @param name
     * @param icon
     */
    public GoBackInTimeAction(final JScoreboardManagerFrame frame, final String name, final Icon icon) {
        super(frame, name, icon);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        final String value = JOptionPane.showInputDialog(getFrame(), "How many seconds?");
        final int seconds = Integer.valueOf(value);
        getFrame().getCurrentMatch().goBackInTime(seconds);
    }
}
