/**
 * StartNextPeriodAction.java 16.9.2010
 */
package scoreboard.floorball.action;

import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.JOptionPane;

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
   public StartNextPeriodAction(JScoreboardManagerFrame frame, String name, Icon icon) {
      super(frame, name, icon);
   }

   /**
    * @param frame
    * @param name
    */
   public StartNextPeriodAction(JScoreboardManagerFrame frame, String name) {
      super(frame, name);
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      getFrame().getCurrentMatch().updateMatchData();
      getFrame().getCurrentMatch().startNextPeriod();
      getFrame().setState(StateHolder.STATE_MATCH_STARTED);
   }
}
