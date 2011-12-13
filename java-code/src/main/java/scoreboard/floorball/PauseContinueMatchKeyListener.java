/**
 * PauseContinueMatchKeyListener.java 20.9.2010
 */
package scoreboard.floorball;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import scoreboard.floorball.state.StateHolder;

/**
 * @author Kvasnovsky Ondrej
 */
final class PauseContinueMatchKeyListener implements KeyListener {

	/**
    * 
    */
	private final JScoreboardManagerFrame frame;

	/**
	 * @param jScoreboardManagerFrame
	 */
	PauseContinueMatchKeyListener(
			JScoreboardManagerFrame jScoreboardManagerFrame) {
		frame = jScoreboardManagerFrame;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (frame.getCurrentMatch() != null) {
			System.out.println("key - " + e.getKeyCode());
			if (frame.getStateHolder().getState() == StateHolder.STATE_MATCH_PAUSED) {
				if (37 == e.getKeyCode()) {
					frame.getCurrentMatch().goBackInTime(-1);
				}
				if (39 == e.getKeyCode()) {
					frame.getCurrentMatch().goBackInTime(1);
				}
			}
			final int keyCodeSpace = 32;
			if (keyCodeSpace == e.getKeyCode()) {
				if (frame.getStateHolder().getState() == StateHolder.STATE_MATCH_STARTED) {
					frame.pauseMatchAction.actionPerformed(new ActionEvent(
							frame.getBtnPause(), 0, "space pressed"));
				} else {
					frame.continueMatchAction.actionPerformed(new ActionEvent(
							frame.getBtnContinueMatch(), 0, "space pressed"));
				}
			}
		}
	}
}