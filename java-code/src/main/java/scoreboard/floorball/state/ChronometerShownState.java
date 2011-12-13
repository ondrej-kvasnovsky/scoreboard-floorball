/**
 * ChronometerShownState.java 16.9.2010
 */
package scoreboard.floorball.state;

import scoreboard.floorball.JScoreboardManagerFrame;

/**
 * @author Kvasnovsky Ondrej
 * 
 */
public class ChronometerShownState extends AbstractState {

    /*
     * (non-Javadoc)
     * 
     * @see scoreboard.floorball.state.AbstractState#initBtnStart(com.ondrejkvasnovsky
     * .chronometer.JChronometerManagerFrame)
     */
    @Override
    public void initBtnStart(final JScoreboardManagerFrame frame) {
        frame.getBtnStart().setEnabled(true);
    }

}
