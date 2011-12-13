/**
 * MainTimer.java 18.9.2010
 */
package scoreboard.floorball;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import scoreboard.floorball.state.StateHolder;
import scoreboard.timer.MainTimer;
import scoreboard.timer.TimerTask;
import scoreboard.timer.TimerTaskListener;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class JScoreboardFrame extends javax.swing.JFrame {

	class MainTimerTimeListener implements TimerTaskListener {

		@Override
		public void taskEnded() {
			mainTimer.pause();
			try {
				// Open an input stream to the audio file.
				InputStream is = getClass().getResourceAsStream("horn.au");
				// Create an AudioStream object from the input stream.
				AudioStream as = new AudioStream(is);
				// Use the static class member "player" from class AudioPlayer
				// to play clip.
				AudioPlayer.player.start(as);
				Thread.currentThread().sleep(2000);
				AudioPlayer.player.stop(as);
			} catch (java.net.MalformedURLException e) {
				System.err.println("can't form horn.au URL");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			mainTimer.removeMainTimerListener(mainTimerTask);
			mainTimerTask = null;
			frame.getTxtTime().setText("20:00");
			lblTime.setText("20:00");
			Integer period = Integer.valueOf(lblPeriod.getText()) + 1;
			frame.getSpinnerPeriod().setValue(period.toString());
			frame.setState(StateHolder.STATE_PERIOD_ENDED);
		}

		@Override
		public void timeChanged() {
			lblTime.setText(mainTimerTask.toString("mm:ss"));
			frame.getTxtTime().setText(mainTimerTask.toString("mm:ss"));
		}
	}

	class PenaltyTimeListener implements TimerTaskListener {

		private JLabel lbl;
		private TimerTask timer;
		private JTextField txt;

		/**
		 * @param lbl
		 */
		private PenaltyTimeListener(JLabel lbl, JTextField txt, TimerTask timer) {
			this.lbl = lbl;
			this.txt = txt;
			this.timer = timer;
		}

		@Override
		public void taskEnded() {
			if (this.timer == timerGuestPenalty1) {
				frame.getTxtGuestPenalty1().setText("");
				lblGuestPenalty1.setText(" ");
				mainTimer.removeMainTimerListener(timerGuestPenalty1);
				timerGuestPenalty1 = null;
			} else if (this.timer == timerGuestPenalty2) {
				frame.getTxtGuestPenalty2().setText("");
				lblGuestPenalty2.setText(" ");
				mainTimer.removeMainTimerListener(timerGuestPenalty2);
				timerGuestPenalty2 = null;
			} else if (this.timer == timerHostPenalty1) {
				frame.getTxtHostPenalty1().setText("");
				lblHostPenalty1.setText(" ");
				mainTimer.removeMainTimerListener(timerHostPenalty1);
				timerHostPenalty1 = null;
			} else if (this.timer == timerHostPenalty2) {
				frame.getTxtHostPenalty2().setText("");
				lblHostPenalty2.setText(" ");
				mainTimer.removeMainTimerListener(timerHostPenalty2);
				timerHostPenalty2 = null;
			}
		}

		@Override
		public void timeChanged() {
			this.lbl.setText(this.timer.toString("m:ss"));
			this.txt.setText(this.timer.toString("m:ss"));
		}
	}

	private JScoreboardManagerFrame frame;
	private JLabel lblGuest;
	private JLabel lblGuestPenalty1;
	private JLabel lblGuestPenalty2;
	private JLabel lblGuestScore;
	private JLabel lblHost;
	private JLabel lblHostPenalty1;
	private JLabel lblHostPenalty2;
	private JLabel lblHostScore;
	private JLabel lblPeriod;
	private JLabel lblTime;
	private MainTimer mainTimer = new MainTimer();
	private TimerTask mainTimerTask;
	private JPanel pnlMain;
	private TimerTask timerGuestPenalty1;
	private TimerTask timerGuestPenalty2;
	private TimerTask timerHostPenalty1;
	private TimerTask timerHostPenalty2;

	public JScoreboardFrame(final JScoreboardManagerFrame frame) {
		super();
		initGUI();
		this.frame = frame;
		this.lblTime.setText(frame.getTxtTime().getText());
		this.lblHost.setText(frame.getTxtHost().getText());
		this.lblGuest.setText(frame.getTxtGuest().getText());
		addKeyListener(new PauseContinueMatchKeyListener(frame));
		setFocusable(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	public void continueMatch() {
		this.mainTimer.cont();
	}

	public void goBackInTime(int seconds) {
		this.mainTimer.goBackInTime(seconds);
		updateTimeTaskData();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			GridBagLayout thisLayout = new GridBagLayout();
			this.setTitle("Floorball Scoreboard (by Ondrej Kvasnovsky)");
			thisLayout.rowWeights = new double[] { 0.1, 0.1, 0.1 };
			thisLayout.rowHeights = new int[] { 7, 7, 7 };
			thisLayout.columnWeights = new double[] { 0.1, 0.1, 0.1 };
			thisLayout.columnWidths = new int[] { 7, 7, 7 };
			getContentPane().setLayout(thisLayout);
			getContentPane().setBackground(new java.awt.Color(255, 255, 255));
			{
				pnlMain = new JPanel();
				GridBagLayout pnlMainLayout = new GridBagLayout();
				getContentPane().add(
						pnlMain,
						new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 0), 0, 0));
				pnlMainLayout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
				pnlMainLayout.rowHeights = new int[] { 7, 7, 7, 7 };
				pnlMainLayout.columnWeights = new double[] { 0.6, 0.5, 0.5 };
				pnlMainLayout.columnWidths = new int[] { 220, 200, 220 };
				pnlMain.setLayout(pnlMainLayout);
				pnlMain.setBackground(new java.awt.Color(255, 255, 255));
				{
					lblTime = new JLabel("", JLabel.CENTER);
					pnlMain.add(lblTime, new GridBagConstraints(1, 0, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));
					lblTime.setText("00:00");
					lblTime.setFont(new java.awt.Font("Tahoma", 0, 120));
					lblTime.setForeground(new java.awt.Color(206, 0, 0));
				}
				{
					lblHost = new JLabel("", JLabel.CENTER);
					FlowLayout lblHostLayout = new FlowLayout();
					lblHost.setLayout(lblHostLayout);
					pnlMain.add(lblHost, new GridBagConstraints(0, 0, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));
					lblHost.setFont(new java.awt.Font("Tahoma", 0, 60));
					lblHost.setText("Domaci");
				}
				{
					lblGuest = new JLabel("", JLabel.CENTER);
					FlowLayout lblGuestLayout = new FlowLayout();
					lblGuest.setLayout(lblGuestLayout);
					pnlMain.add(lblGuest, new GridBagConstraints(2, 0, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));
					lblGuest.setFont(new java.awt.Font("Tahoma", 0, 60));
					lblGuest.setText("Hoste");
				}
				{
					lblPeriod = new JLabel("", JLabel.CENTER);
					pnlMain.add(lblPeriod, new GridBagConstraints(1, 1, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));
					lblPeriod.setText("1");
					lblPeriod.setFont(new java.awt.Font("Tahoma", 0, 60));
					lblPeriod.setForeground(new java.awt.Color(0, 179, 0));
				}
				{
					lblHostPenalty1 = new JLabel(" ", JLabel.CENTER);
					pnlMain.add(lblHostPenalty1, new GridBagConstraints(0, 2,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));
					lblHostPenalty1
							.setForeground(new java.awt.Color(255, 0, 0));
					lblHostPenalty1.setFont(new java.awt.Font("Tahoma", 0, 60));
				}
				{
					lblHostPenalty2 = new JLabel(" ", JLabel.CENTER);
					pnlMain.add(lblHostPenalty2, new GridBagConstraints(0, 3,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));
					lblHostPenalty2.setText("");
					lblHostPenalty2
							.setForeground(new java.awt.Color(255, 0, 0));
					lblHostPenalty2.setFont(new java.awt.Font("Tahoma", 0, 60));
				}
				{
					lblGuestPenalty1 = new JLabel(" ", JLabel.CENTER);
					pnlMain.add(lblGuestPenalty1, new GridBagConstraints(2, 2,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));
					lblGuestPenalty1.setText(" ");
					lblGuestPenalty1
							.setForeground(new java.awt.Color(255, 0, 0));
					lblGuestPenalty1
							.setFont(new java.awt.Font("Tahoma", 0, 60));
				}
				{
					lblGuestPenalty2 = new JLabel("", JLabel.CENTER);
					pnlMain.add(lblGuestPenalty2, new GridBagConstraints(2, 3,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));
					lblGuestPenalty2.setText(" ");
					lblGuestPenalty2
							.setForeground(new java.awt.Color(255, 0, 0));
					lblGuestPenalty2
							.setFont(new java.awt.Font("Tahoma", 0, 60));
				}
				{
					lblHostScore = new JLabel("", JLabel.CENTER);
					pnlMain.add(lblHostScore, new GridBagConstraints(0, 1, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));
					lblHostScore.setText("0");
					lblHostScore.setFont(new java.awt.Font("Tahoma", 0, 120));
					lblHostScore.setForeground(new java.awt.Color(255, 128, 0));
				}
				{
					lblGuestScore = new JLabel("", JLabel.CENTER);
					pnlMain.add(lblGuestScore, new GridBagConstraints(2, 1, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));
					lblGuestScore.setText("0");
					lblGuestScore.setFont(new java.awt.Font("Tahoma", 0, 120));
					lblGuestScore
							.setForeground(new java.awt.Color(255, 128, 0));
				}
			}
			pack();
			this.setSize(840, 407);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pauseMatch() {
		this.mainTimer.pause();
	}

	public void penaltyToGuest() {
		if (timerGuestPenalty1 == null
				&& !"".equals(frame.getTxtGuestPenalty1().getText().trim())
				&& !":".equals(frame.getTxtGuestPenalty1().getText().trim())) {
			timerGuestPenalty1 = new TimerTask(frame.getTxtGuestPenalty1()
					.getText());
			this.mainTimer.addMainTimerListener(timerGuestPenalty1);
			PenaltyTimeListener listener = new PenaltyTimeListener(
					lblGuestPenalty1, frame.getTxtGuestPenalty1(),
					timerGuestPenalty1);
			timerGuestPenalty1.add(listener);
		}
		if (timerGuestPenalty2 == null
				&& !"".equals(frame.getTxtGuestPenalty2().getText().trim())
				&& !":".equals(frame.getTxtGuestPenalty2().getText().trim())) {
			timerGuestPenalty2 = new TimerTask(frame.getTxtGuestPenalty2()
					.getText());
			this.mainTimer.addMainTimerListener(timerGuestPenalty2);
			PenaltyTimeListener listener = new PenaltyTimeListener(
					lblGuestPenalty2, frame.getTxtGuestPenalty2(),
					timerGuestPenalty2);
			timerGuestPenalty2.add(listener);
		}
	}

	public void penaltyToHost() {
		if (timerHostPenalty1 == null
				&& !"".equals(frame.getTxtHostPenalty1().getText().trim())
				&& !":".equals(frame.getTxtHostPenalty1().getText().trim())) {
			timerHostPenalty1 = new TimerTask(frame.getTxtHostPenalty1()
					.getText());
			PenaltyTimeListener listener = new PenaltyTimeListener(
					lblHostPenalty1, frame.getTxtHostPenalty1(),
					timerHostPenalty1);
			this.mainTimer.addMainTimerListener(timerHostPenalty1);
			timerHostPenalty1.add(listener);
		}
		if (timerHostPenalty2 == null
				&& !"".equals(frame.getTxtHostPenalty2().getText().trim())
				&& !":".equals(frame.getTxtHostPenalty2().getText().trim())) {
			timerHostPenalty2 = new TimerTask(frame.getTxtHostPenalty2()
					.getText());
			PenaltyTimeListener listener = new PenaltyTimeListener(
					lblHostPenalty2, frame.getTxtHostPenalty2(),
					timerHostPenalty2);
			this.mainTimer.addMainTimerListener(timerHostPenalty2);
			timerHostPenalty2.add(listener);
		}
	}

	public void startMatch() {
		this.mainTimer.start();
		this.mainTimerTask = new TimerTask(frame.getTxtTime().getText());
		this.mainTimer.addMainTimerListener(this.mainTimerTask);
		this.mainTimerTask.add(new MainTimerTimeListener());
	}

	public void startNextPeriod() {
		this.mainTimerTask = new TimerTask(frame.getTxtTime().getText());
		this.mainTimer.addMainTimerListener(this.mainTimerTask);
		this.mainTimerTask.add(new MainTimerTimeListener());
		this.mainTimer.cont();
	}

	public void updateMatchData() {
		lblGuestScore.setText(frame.getSpinnerGuest().getValue().toString());
		lblHostScore.setText(frame.getSpinnerHost().getValue().toString());
		lblPeriod.setText(frame.getSpinnerPeriod().getValue().toString());
		lblHost.setText(frame.getTxtHost().getText());
		lblGuest.setText(frame.getTxtGuest().getText());
	}

	public void updateTimeTaskData() {
		if (mainTimerTask != null) {
			lblTime.setText(mainTimerTask.toString("mm:ss"));
			frame.getTxtTime().setText(mainTimerTask.toString("mm:ss"));
		}
		if (timerGuestPenalty1 != null) {
			frame.getTxtGuestPenalty1().setText(
					this.timerGuestPenalty1.toString("m:ss"));
			lblGuestPenalty1.setText(this.timerGuestPenalty1.toString("m:ss"));
		}
		if (timerGuestPenalty2 != null) {
			frame.getTxtGuestPenalty2().setText(
					this.timerGuestPenalty2.toString("m:ss"));
			lblGuestPenalty2.setText(this.timerGuestPenalty2.toString("m:ss"));
		}
		if (timerHostPenalty1 != null) {
			frame.getTxtHostPenalty1().setText(
					this.timerHostPenalty1.toString("m:ss"));
			lblHostPenalty1.setText(this.timerHostPenalty1.toString("m:ss"));
		}
		if (timerHostPenalty2 != null) {
			frame.getTxtHostPenalty2().setText(
					this.timerHostPenalty2.toString("m:ss"));
			lblHostPenalty2.setText(this.timerHostPenalty2.toString("m:ss"));
		}
	}
}
