/**
 * ScoreboardAbstractAction.java 16.9.2010
 */
package scoreboard.floorball.action;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import scoreboard.floorball.JScoreboardManagerFrame;

/**
 * @author Kvasnovsky Ondrej
 */
public abstract class ScoreboardAbstractAction extends AbstractAction {

    private final JScoreboardManagerFrame frame;

    /**
     * @param frame
     * @param name
     */
    public ScoreboardAbstractAction(final JScoreboardManagerFrame frame, final String name) {
        super(name);
        this.frame = frame;
    }

    /**
     * @return the frame
     */
    public final JScoreboardManagerFrame getFrame() {
        return this.frame;
    }

    /**
     * @param name
     * @param icon
     */
    public ScoreboardAbstractAction(final JScoreboardManagerFrame frame, final String name, final Icon icon) {
        super(name, icon);
        this.frame = frame;
    }
}
