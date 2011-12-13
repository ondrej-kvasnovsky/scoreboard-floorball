/**
 * TimeOutState.java, 13.12.2011 13:09:42 
 */
package scoreboard.floorball.state;

import scoreboard.floorball.JScoreboardManagerFrame;

/**
 * @author Ondrej Kvasnovsky
 */
public class TimeOutState extends MatchStartedState {

    /**
     * {@inheritDoc}
     * 
     * @see scoreboard.floorball.state.MatchStartedState#initBtnPause(scoreboard.floorball.JScoreboardManagerFrame)
     */
    @Override
    public void initBtnPause(final JScoreboardManagerFrame frame) {
        frame.getBtnPause().setEnabled(false);
    }
}
