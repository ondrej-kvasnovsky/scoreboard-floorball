package scoreboard.floorball.state;

import javax.swing.JButton;

import scoreboard.floorball.JScoreboardManagerFrame;

public interface State {

    public void initPnlMain(JScoreboardManagerFrame frame);

    public void initTxtHost(JScoreboardManagerFrame frame);

    public void initBtnStart(JScoreboardManagerFrame frame);

    public void initTxtGuestPenalty1(JScoreboardManagerFrame frame);

    public void initTxtGuestPenality1(JScoreboardManagerFrame frame);

    public void initTxtHostPenalty2(JScoreboardManagerFrame frame);

    public void initTxtHostPenalty1(JScoreboardManagerFrame frame);

    public void initBtnPause(JScoreboardManagerFrame frame);

    public void initSpinnerPeriod(JScoreboardManagerFrame frame);

    public void initSpinnerGuest(JScoreboardManagerFrame frame);

    public void initSpinnerHost(JScoreboardManagerFrame frame);

    public void initTxtGuest(JScoreboardManagerFrame frame);

    public void initTxtTime(JScoreboardManagerFrame frame);

    public void initBtnShowChronometer(JScoreboardManagerFrame frame);

    public void initBtnContinueMatch(JScoreboardManagerFrame frame);

    public void initBtnStartNextPeriod(JScoreboardManagerFrame frame);

    public void initBtnGoBackInTime(JScoreboardManagerFrame frame);

    public void initBtnTimeoutGuest(JScoreboardManagerFrame frame);

    public void initBtnTimeoutHost(JScoreboardManagerFrame frame);

    public void initBtnCancelPenaltyGuest2(JScoreboardManagerFrame frame);

    public void initBtnCancelPenaltyGuest1(JScoreboardManagerFrame frame);

    public void initBtnCancelPenaltyHost2(JScoreboardManagerFrame frame);

    public void initBtnCancelPenaltyHost1(JScoreboardManagerFrame frame);
}
