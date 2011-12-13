/**
 * CancelPenaltyAction.java, 13.12.2011 18:52:13 
 */
package scoreboard.floorball.action;

import java.awt.event.ActionEvent;

import javax.swing.Icon;

import scoreboard.floorball.JScoreboardManagerFrame;

/**
 * @author kvasnond
 */
public class CancelPenaltyAction extends ScoreboardAbstractAction {

    public enum Type {
        Host1, Host2, Guest1, Guest2
    }

    private Type type;

    /**
     * Creates new instance.
     * 
     * @param frame
     * @param name
     */
    public CancelPenaltyAction(final JScoreboardManagerFrame frame, final String name, final Type type) {
        super(frame, name);
        this.type = type;
    }

    /**
     * Creates new instance.
     * 
     * @param frame
     * @param name
     * @param icon
     */
    public CancelPenaltyAction(final JScoreboardManagerFrame frame, final String name, final Icon icon) {
        super(frame, name, icon);
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("X " + this.type);
        switch (type) {
            case Host1:
                getFrame().getCurrentMatch().getTimerHostPenalty1().setTime(0);
                getFrame().getCurrentMatch().setTimerGuestPenalty1(null);
                getFrame().getCurrentMatch().getLblHostPenalty1().setText("");
                getFrame().getTxtHostPenalty1().setText("");
                break;
            case Host2:
                getFrame().getCurrentMatch().getTimerHostPenalty2().setTime(0);
                getFrame().getCurrentMatch().getLblHostPenalty2().setText("");
                getFrame().getTxtHostPenalty2().setText("");
                getFrame().getCurrentMatch().getTimerHostPenalty2();
                break;
            case Guest1:
                getFrame().getCurrentMatch().getTimerGuestPenalty1().setTime(0);
                getFrame().getCurrentMatch().getLblGuestPenalty1().setText("");
                getFrame().getTxtGuestPenalty1().setText("");
                getFrame().getCurrentMatch().getTimerGuestPenalty1();
                break;
            case Guest2:
                getFrame().getCurrentMatch().getTimerGuestPenalty2().setTime(0);
                getFrame().getCurrentMatch().getLblGuestPenalty2().setText("");
                getFrame().getTxtGuestPenalty2().setText("");
                getFrame().getCurrentMatch().getTimerGuestPenalty2();
                break;

        }
    }

}
