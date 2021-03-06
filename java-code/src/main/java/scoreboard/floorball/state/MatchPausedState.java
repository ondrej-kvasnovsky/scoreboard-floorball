package scoreboard.floorball.state;

import scoreboard.floorball.JScoreboardManagerFrame;

/**
 * @author Ondrej Kvasnovsky
 */
public class MatchPausedState extends AbstractState {

    /** 
     * {@inheritDoc}
     * @see scoreboard.floorball.state.State#initBtnCancelPenaltyGuest2(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnCancelPenaltyGuest2(JScoreboardManagerFrame frame) {
        frame.getBtnCancelPenaltyGuest2().setEnabled(true);
    }

    /** 
     * {@inheritDoc}
     * @see scoreboard.floorball.state.State#initBtnCancelPenaltyGuest1(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnCancelPenaltyGuest1(JScoreboardManagerFrame frame) {
        frame.getBtnCancelPenaltyGuest1().setEnabled(true);
    }

    /** 
     * {@inheritDoc}
     * @see scoreboard.floorball.state.State#initBtnCancelPenaltyHost2(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnCancelPenaltyHost2(JScoreboardManagerFrame frame) {
        frame.getBtnCancelPenaltyHost2().setEnabled(true);
    }

    /** 
     * {@inheritDoc}
     * @see scoreboard.floorball.state.State#initBtnCancelPenaltyHost1(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnCancelPenaltyHost1(JScoreboardManagerFrame frame) {
        frame.getBtnCancelPenaltyHost1().setEnabled(true);
    }

    
    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.State#initBtnTimeoutHost(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnTimeoutGuest(JScoreboardManagerFrame frame) {
        frame.getBtnTimeoutGuest().setEnabled(true);
    }
    
    /** 
     * {@inheritDoc}
     * @see scoreboard.floorball.state.AbstractState#initBtnTimeoutHost(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnTimeoutHost(JScoreboardManagerFrame frame) {
        frame.getBtnTimeoutHost().setEnabled(true);
    }

    /*
     * (non-Javadoc)
     * 
     * @see scoreboard.floorball.state.State#initSpinnerGuest(scoreboard.floorball .JChronometerManagerFrame)
     */
    @Override
    public void initSpinnerGuest(final JScoreboardManagerFrame frame) {
        frame.getSpinnerGuest().setEnabled(true);
    }

    /*
     * (non-Javadoc)
     * 
     * @see scoreboard.floorball.state.State#initBtnGoBackInTime(scoreboard.floorball. JScoreboardManagerFrame)
     */
    @Override
    public void initBtnGoBackInTime(final JScoreboardManagerFrame frame) {
        frame.getBtnGoBackInTime().setEnabled(true);
    }

    /*
     * (non-Javadoc)
     * 
     * @see scoreboard.floorball.state.State#initSpinnerHost(scoreboard.floorball .JChronometerManagerFrame)
     */
    @Override
    public void initSpinnerHost(final JScoreboardManagerFrame frame) {
        frame.getSpinnerHost().setEnabled(true);
    }

    /*
     * (non-Javadoc)
     * 
     * @seecom.ondrejkvasnovsky.chronometer.state.JChronometerManagerFrameState#initSpinnerPeriod(com.ondrejkvasnovsky.
     * chronometer.JChronometerManagerFrame)
     */
    @Override
    public void initSpinnerPeriod(final JScoreboardManagerFrame frame) {
        frame.getSpinnerPeriod().setEnabled(true);
    }

    /*
     * (non-Javadoc)
     * 
     * @seecom.ondrejkvasnovsky.chronometer.state.AbstractState#initBtnContinueMatch(scoreboard.floorball.
     * JScoreboardManagerFrame)
     */
    @Override
    public void initBtnContinueMatch(final JScoreboardManagerFrame frame) {
        frame.getBtnContinueMatch().setEnabled(true);
    }

    /*
     * (non-Javadoc)
     * 
     * @see scoreboard.floorball.state.State#initTxtGuest(scoreboard.floorball .JChronometerManagerFrame)
     */
    @Override
    public void initTxtGuest(final JScoreboardManagerFrame frame) {
        frame.getTxtGuest().setEnabled(true);
    }

    /*
     * (non-Javadoc)
     * 
     * @see scoreboard.floorball.state.State#initTxtGuestPenality1(com.ondrejkvasnovsky
     * .chronometer.JChronometerManagerFrame)
     */
    @Override
    public void initTxtGuestPenality1(final JScoreboardManagerFrame frame) {
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
    public void initTxtGuestPenalty1(final JScoreboardManagerFrame frame) {
        if (":".equals(frame.getTxtGuestPenalty2().getText().trim())) {
            frame.getTxtGuestPenalty2().setEnabled(true);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see scoreboard.floorball.state.State#initTxtHost(scoreboard.floorball .JChronometerManagerFrame)
     */
    @Override
    public void initTxtHost(final JScoreboardManagerFrame frame) {
        frame.getTxtHost().setEnabled(true);
    }

    /*
     * (non-Javadoc)
     * 
     * @see scoreboard.floorball.state.State#initTxtHostPenalty1(com.ondrejkvasnovsky.
     * chronometer.JChronometerManagerFrame)
     */
    @Override
    public void initTxtHostPenalty1(final JScoreboardManagerFrame frame) {
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
    public void initTxtHostPenalty2(final JScoreboardManagerFrame frame) {
        if (":".equals(frame.getTxtHostPenalty2().getText().trim())) {
            frame.getTxtHostPenalty2().setEnabled(true);
        }
    }
}
