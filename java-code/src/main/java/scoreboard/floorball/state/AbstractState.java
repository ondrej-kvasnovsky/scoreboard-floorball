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
    
    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initBtnTimeoutHost(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnTimeoutGuest(JScoreboardManagerFrame frame) {
        frame.getBtnTimeoutGuest().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initBtnTimeoutHost(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnTimeoutHost(JScoreboardManagerFrame frame) {
        frame.getBtnTimeoutHost().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initBtnContinueMatch(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnContinueMatch(final JScoreboardManagerFrame frame) {
        frame.getBtnContinueMatch().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initBtnGoBackInTime(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnGoBackInTime(final JScoreboardManagerFrame frame) {
        frame.getBtnGoBackInTime().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initBtnPause(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnPause(final JScoreboardManagerFrame frame) {
        frame.getBtnPause().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initBtnShowChronometer(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnShowChronometer(final JScoreboardManagerFrame frame) {
        frame.getBtnShowChronometer().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initBtnStart(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnStart(final JScoreboardManagerFrame frame) {
        frame.getBtnStart().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initBtnStartNextPeriod(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnStartNextPeriod(final JScoreboardManagerFrame frame) {
        frame.getBtnStartNextPeriod().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initPnlMain(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initPnlMain(final JScoreboardManagerFrame frame) {
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initSpinnerGuest(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initSpinnerGuest(final JScoreboardManagerFrame frame) {
        frame.getSpinnerGuest().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initSpinnerHost(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initSpinnerHost(final JScoreboardManagerFrame frame) {
        frame.getSpinnerHost().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initSpinnerPeriod(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initSpinnerPeriod(final JScoreboardManagerFrame frame) {
        frame.getSpinnerPeriod().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initTxtGuest(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initTxtGuest(final JScoreboardManagerFrame frame) {
        frame.getTxtGuest().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initTxtGuestPenality1(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initTxtGuestPenality1(final JScoreboardManagerFrame frame) {
        frame.getTxtGuestPenalty1().setEnabled(false);
    }

    /** 
     * {@inheritDoc}
     * @see scoreboard.floorball.state.State#initBtnCancelPenaltyGuest2(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnCancelPenaltyGuest2(JScoreboardManagerFrame frame) {
        frame.getBtnCancelPenaltyGuest2().setEnabled(false);
    }

    /** 
     * {@inheritDoc}
     * @see scoreboard.floorball.state.State#initBtnCancelPenaltyGuest1(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnCancelPenaltyGuest1(JScoreboardManagerFrame frame) {
        frame.getBtnCancelPenaltyGuest1().setEnabled(false);
    }

    /** 
     * {@inheritDoc}
     * @see scoreboard.floorball.state.State#initBtnCancelPenaltyHost2(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnCancelPenaltyHost2(JScoreboardManagerFrame frame) {
        frame.getBtnCancelPenaltyHost2().setEnabled(false);
    }

    /** 
     * {@inheritDoc}
     * @see scoreboard.floorball.state.State#initBtnCancelPenaltyHost1(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnCancelPenaltyHost1(JScoreboardManagerFrame frame) {
        frame.getBtnCancelPenaltyHost1().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initTxtGuestPenalty1(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initTxtGuestPenalty1(final JScoreboardManagerFrame frame) {
        frame.getTxtGuestPenalty2().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initTxtHost(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initTxtHost(final JScoreboardManagerFrame frame) {
        frame.getTxtHost().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initTxtHostPenalty1(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initTxtHostPenalty1(final JScoreboardManagerFrame frame) {
        frame.getTxtHostPenalty1().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initTxtHostPenalty2(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initTxtHostPenalty2(final JScoreboardManagerFrame frame) {
        frame.getTxtHostPenalty2().setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initTxtTime(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initTxtTime(final JScoreboardManagerFrame frame) {
        frame.getTxtTime().setEnabled(false);
    }
}
