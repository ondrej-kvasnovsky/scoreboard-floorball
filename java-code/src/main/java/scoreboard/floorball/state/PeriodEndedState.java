/**
 * PeriodEndedState.java 19.9.2010
 */
package scoreboard.floorball.state;

import scoreboard.floorball.JScoreboardManagerFrame;

/**
 * @author Kvasnovsky Ondrej
 */
public class PeriodEndedState extends AbstractState {

    /*
     * (non-Javadoc)
     * 
     * @see scoreboard.floorball.state.AbstractState#initBtnStartNextPeriod(scoreboard.floorball.
     * JScoreboardManagerFrame)
     */
    @Override
    public void initBtnStartNextPeriod(final JScoreboardManagerFrame frame) {
        frame.getBtnStartNextPeriod().setEnabled(true);
    }

    /*
     * (non-Javadoc)
     * 
     * @seecom.ondrejkvasnovsky.chronometer.state.AbstractState#initTxtTime(scoreboard.floorball.
     * JScoreboardManagerFrame)
     */
    @Override
    public void initTxtTime(final JScoreboardManagerFrame frame) {
        frame.getTxtTime().setEnabled(true);
    }
}
