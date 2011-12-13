/**
 * DefaultState.java 16.9.2010
 */
package scoreboard.floorball.state;

import scoreboard.floorball.JScoreboardManagerFrame;

/**
 * @author Kvasnovsky Ondrej
 * 
 */
public class DefaultState extends AbstractState {

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initBtnShowChronometer(com.ondrejkvasnovsky
    * .chronometer.JChronometerManagerFrame)
    */
   @Override
   public void initBtnShowChronometer(JScoreboardManagerFrame frame) {
      frame.getBtnShowChronometer().setEnabled(true);
   }

   /*
    * (non-Javadoc)
    * 
    * @seecom.ondrejkvasnovsky.chronometer.state.AbstractState#initTxtGuest(scoreboard.floorball.
    * JScoreboardManagerFrame)
    */
   @Override
   public void initTxtGuest(JScoreboardManagerFrame frame) {
      frame.getTxtGuest().setEnabled(true);
   }

   /*
    * (non-Javadoc)
    * 
    * @seecom.ondrejkvasnovsky.chronometer.state.AbstractState#initTxtHost(scoreboard.floorball.
    * JScoreboardManagerFrame)
    */
   @Override
   public void initTxtHost(JScoreboardManagerFrame frame) {
      frame.getTxtHost().setEnabled(true);
   }

   /*
    * (non-Javadoc)
    * 
    * @seecom.ondrejkvasnovsky.chronometer.state.AbstractState#initTxtTime(scoreboard.floorball.
    * JScoreboardManagerFrame)
    */
   @Override
   public void initTxtTime(JScoreboardManagerFrame frame) {
      frame.getTxtTime().setEnabled(true);
   }
}
