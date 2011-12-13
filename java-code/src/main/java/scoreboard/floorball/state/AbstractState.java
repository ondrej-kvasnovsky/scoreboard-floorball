/**
 * AbstractState.java 16.9.2010
 */
package scoreboard.floorball.state;

import scoreboard.floorball.JScoreboardManagerFrame;

/**
 * @author Kvasnovsky Ondrej
 * 
 */
public abstract class AbstractState implements State {

   /**
    * 
    */
   public AbstractState() {
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initBtnContinueMatch(com.ondrejkvasnovsky
    * .chronometer.JChronometerManagerFrame)
    */
   @Override
   public void initBtnContinueMatch(JScoreboardManagerFrame frame) {
      frame.getBtnContinueMatch().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initBtnGoBackInTime(scoreboard.floorball.
    * JScoreboardManagerFrame)
    */
   @Override
   public void initBtnGoBackInTime(JScoreboardManagerFrame frame) {
      frame.getBtnGoBackInTime().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initBtnPause(scoreboard.floorball
    * .JChronometerManagerFrame)
    */
   @Override
   public void initBtnPause(JScoreboardManagerFrame frame) {
      frame.getBtnPause().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initBtnShowChronometer(com.ondrejkvasnovsky
    * .chronometer.JChronometerManagerFrame)
    */
   @Override
   public void initBtnShowChronometer(JScoreboardManagerFrame frame) {
      frame.getBtnShowChronometer().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initBtnStart(scoreboard.floorball
    * .JChronometerManagerFrame)
    */
   @Override
   public void initBtnStart(JScoreboardManagerFrame frame) {
      frame.getBtnStart().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initBtnStartNextPeriod(scoreboard.floorball.
    * JScoreboardManagerFrame)
    */
   @Override
   public void initBtnStartNextPeriod(JScoreboardManagerFrame frame) {
      frame.getBtnStartNextPeriod().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initPnlMain(scoreboard.floorball
    * .JChronometerManagerFrame)
    */
   @Override
   public void initPnlMain(JScoreboardManagerFrame frame) {
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initSpinnerGuest(scoreboard.floorball
    * .JChronometerManagerFrame)
    */
   @Override
   public void initSpinnerGuest(JScoreboardManagerFrame frame) {
      frame.getSpinnerGuest().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initSpinnerHost(scoreboard.floorball
    * .JChronometerManagerFrame)
    */
   @Override
   public void initSpinnerHost(JScoreboardManagerFrame frame) {
      frame.getSpinnerHost().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @seecom.ondrejkvasnovsky.chronometer.state.JChronometerManagerFrameState#initSpinnerPeriod(com.ondrejkvasnovsky.
    * chronometer.JChronometerManagerFrame)
    */
   @Override
   public void initSpinnerPeriod(JScoreboardManagerFrame frame) {
      frame.getSpinnerPeriod().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initTxtGuest(scoreboard.floorball
    * .JChronometerManagerFrame)
    */
   @Override
   public void initTxtGuest(JScoreboardManagerFrame frame) {
      frame.getTxtGuest().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initTxtGuestPenality1(com.ondrejkvasnovsky
    * .chronometer.JChronometerManagerFrame)
    */
   @Override
   public void initTxtGuestPenality1(JScoreboardManagerFrame frame) {
      frame.getTxtGuestPenalty1().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initTxtGuestPenalty1(com.ondrejkvasnovsky
    * .chronometer.JChronometerManagerFrame)
    */
   @Override
   public void initTxtGuestPenalty1(JScoreboardManagerFrame frame) {
      frame.getTxtGuestPenalty2().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initTxtHost(scoreboard.floorball
    * .JChronometerManagerFrame)
    */
   @Override
   public void initTxtHost(JScoreboardManagerFrame frame) {
      frame.getTxtHost().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initTxtHostPenalty1(com.ondrejkvasnovsky.
    * chronometer.JChronometerManagerFrame)
    */
   @Override
   public void initTxtHostPenalty1(JScoreboardManagerFrame frame) {
      frame.getTxtHostPenalty1().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initTxtHostPenalty2(com.ondrejkvasnovsky.
    * chronometer.JChronometerManagerFrame)
    */
   @Override
   public void initTxtHostPenalty2(JScoreboardManagerFrame frame) {
      frame.getTxtHostPenalty2().setEnabled(false);
   }

   /*
    * (non-Javadoc)
    * 
    * @see scoreboard.floorball.state.State#initTxtTime(scoreboard.floorball
    * .JChronometerManagerFrame)
    */
   @Override
   public void initTxtTime(JScoreboardManagerFrame frame) {
      frame.getTxtTime().setEnabled(false);
   }
}
