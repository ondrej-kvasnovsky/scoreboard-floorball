package scoreboard.floorball.state;

import scoreboard.floorball.JScoreboardManagerFrame;

public class MatchPausedState extends AbstractState {

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initSpinnerGuest(scoreboard.floorball
    * .JChronometerManagerFrame)
    */
   @Override
   public void initSpinnerGuest(JScoreboardManagerFrame frame) {
      frame.getSpinnerGuest().setEnabled(true);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initBtnGoBackInTime(scoreboard.floorball.
    * JScoreboardManagerFrame)
    */
   @Override
   public void initBtnGoBackInTime(JScoreboardManagerFrame frame) {
      frame.getBtnGoBackInTime().setEnabled(true);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initSpinnerHost(scoreboard.floorball
    * .JChronometerManagerFrame)
    */
   @Override
   public void initSpinnerHost(JScoreboardManagerFrame frame) {
      frame.getSpinnerHost().setEnabled(true);
   }

   /*
    * (non-Javadoc)
    * 
    * @seecom.ondrejkvasnovsky.chronometer.state.JChronometerManagerFrameState#initSpinnerPeriod(com.ondrejkvasnovsky.
    * chronometer.JChronometerManagerFrame)
    */
   @Override
   public void initSpinnerPeriod(JScoreboardManagerFrame frame) {
      frame.getSpinnerPeriod().setEnabled(true);
   }

   /*
    * (non-Javadoc)
    * 
    * @seecom.ondrejkvasnovsky.chronometer.state.AbstractState#initBtnContinueMatch(scoreboard.floorball.
    * JScoreboardManagerFrame)
    */
   @Override
   public void initBtnContinueMatch(JScoreboardManagerFrame frame) {
      frame.getBtnContinueMatch().setEnabled(true);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initTxtGuest(scoreboard.floorball
    * .JChronometerManagerFrame)
    */
   @Override
   public void initTxtGuest(JScoreboardManagerFrame frame) {
      frame.getTxtGuest().setEnabled(true);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initTxtGuestPenality1(com.ondrejkvasnovsky
    * .chronometer.JChronometerManagerFrame)
    */
   @Override
   public void initTxtGuestPenality1(JScoreboardManagerFrame frame) {
      if (":".equals(frame.getTxtGuestPenalty1().getText().trim())) {
         frame.getTxtGuestPenalty1().setEnabled(true);
      }
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initTxtGuestPenalty1(com.ondrejkvasnovsky
    * .chronometer.JChronometerManagerFrame)
    */
   @Override
   public void initTxtGuestPenalty1(JScoreboardManagerFrame frame) {
      if (":".equals(frame.getTxtGuestPenalty2().getText().trim())) {
         frame.getTxtGuestPenalty2().setEnabled(true);
      }
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initTxtHost(scoreboard.floorball
    * .JChronometerManagerFrame)
    */
   @Override
   public void initTxtHost(JScoreboardManagerFrame frame) {
      frame.getTxtHost().setEnabled(true);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initTxtHostPenalty1(com.ondrejkvasnovsky.
    * chronometer.JChronometerManagerFrame)
    */
   @Override
   public void initTxtHostPenalty1(JScoreboardManagerFrame frame) {
      if (":".equals(frame.getTxtHostPenalty1().getText().trim())) {
         frame.getTxtHostPenalty1().setEnabled(true);
      }
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initTxtHostPenalty2(com.ondrejkvasnovsky.
    * chronometer.JChronometerManagerFrame)
    */
   @Override
   public void initTxtHostPenalty2(JScoreboardManagerFrame frame) {
      if (":".equals(frame.getTxtHostPenalty2().getText().trim())) {
         frame.getTxtHostPenalty2().setEnabled(true);
      }
   }
}
