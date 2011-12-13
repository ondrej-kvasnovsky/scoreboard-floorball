/**
 * StartMatchAction.java 16.9.2010
 */
package scoreboard.floorball.action;

import java.awt.event.ActionEvent;

import scoreboard.floorball.JScoreboardManagerFrame;
import scoreboard.floorball.state.StateHolder;


/**
 * @author Kvasnovsky Ondrej
 * 
 */
public class StartMatchAction extends ScoreboardAbstractAction {

   /**
    * 
    */
   private static final long serialVersionUID = -4559207726606808606L;

   /**
    * @param frame
    * @param name
    */
   public StartMatchAction(JScoreboardManagerFrame frame, String name) {
      super(frame, name);
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      getFrame().getCurrentMatch().startMatch();
      getFrame().setState(StateHolder.STATE_MATCH_STARTED);
   }
}
