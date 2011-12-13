package scoreboard.floorball.state;

import scoreboard.floorball.JScoreboardManagerFrame;

public class MatchStartedState extends AbstractState {

   /*
    * (non-Javadoc)
    * 
    * @seecom.ondrejkvasnovsky.chronometer.state.AbstractState#initBtnPause(scoreboard.floorball.
    * JScoreboardManagerFrame)
    */
   @Override
   public void initBtnPause(JScoreboardManagerFrame frame) {
      frame.getBtnPause().setEnabled(true);
   }
}
