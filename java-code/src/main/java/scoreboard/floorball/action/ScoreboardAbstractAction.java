/**
 * ScoreboardAbstractAction.java 16.9.2010
 */
package scoreboard.floorball.action;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import scoreboard.floorball.JScoreboardManagerFrame;


/**
 * @author Kvasnovsky Ondrej
 * 
 */
public abstract class ScoreboardAbstractAction extends AbstractAction {

   private final JScoreboardManagerFrame frame;

   /**
    * @param name
    */
   public ScoreboardAbstractAction(JScoreboardManagerFrame frame, String name) {
      super(name);
      this.frame = frame;
   }

   /**
    * @return the frame
    */
   public final JScoreboardManagerFrame getFrame() {
      return frame;
   }

   /**
    * @param name
    * @param icon
    */
   public ScoreboardAbstractAction(JScoreboardManagerFrame frame, String name, Icon icon) {
      super(name, icon);
      this.frame = frame;
   }
}
