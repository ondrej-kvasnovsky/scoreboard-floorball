/**
 * JScoreboardManagerFrame.java 18.9.2010
 */
package scoreboard.floorball;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;

import scoreboard.floorball.action.ContinueMatchAction;
import scoreboard.floorball.action.GoBackInTimeAction;
import scoreboard.floorball.action.PauseMatchAction;
import scoreboard.floorball.action.ShowChronometerAction;
import scoreboard.floorball.action.StartMatchAction;
import scoreboard.floorball.action.StartNextPeriodAction;
import scoreboard.floorball.state.State;
import scoreboard.floorball.state.StateHolder;

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
public class JScoreboardManagerFrame extends JFrame {

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JScoreboardManagerFrame inst = new JScoreboardManagerFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	private JButton btnContinueMatch;
	private JButton btnGoBackInTime;
	private JButton btnPause;
	private JButton btnShowChronometer;
	private JButton btnStart;
	private JButton btnStartNextPeriod;
	final ContinueMatchAction continueMatchAction = new ContinueMatchAction(
			this, "Continue match");
	private JScoreboardFrame currentMatch;
	final PauseMatchAction pauseMatchAction = new PauseMatchAction(this,
			"Pause match");
	private JPanel pnlMain;
	private JSpinner spinnerGuest;
	private JSpinner spinnerHost;
	private JSpinner spinnerPeriod;
	final StateHolder stateHolder;
	private JTextField txtGuest;
	private JFormattedTextField txtGuestPenalty1;
	private JFormattedTextField txtGuestPenalty2;
	private JTextField txtHost;
	private JFormattedTextField txtHostPenalty1;
	private JFormattedTextField txtHostPenalty2;
	private JFormattedTextField txtTime;
	private final Integer[] values;

	public JScoreboardManagerFrame() {
		super();
		this.stateHolder = new StateHolder(this);
		// init values for score spinner
		this.values = new Integer[100];
		for (int i = 0; i < 100; i++) {
			this.values[i] = i;
		}
		// init gui
		initGUI();
		// setup default state (start state)
		setState(StateHolder.STATE_DEFAULT);
		// make key listener active
		addKeyListener(new PauseContinueMatchKeyListener(this));
		setFocusable(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(
						JScoreboardManagerFrame.this,
						"Do you really want to close the scoreboard?",
						"Exit scoreboard?", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}

	protected MaskFormatter createFormatter(String s) {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(s);
		} catch (java.text.ParseException exc) {
			System.err.println("formatter is bad: " + exc.getMessage());
		}
		return formatter;
	}

	public JButton getBtnContinueMatch() {
		if (btnContinueMatch == null) {
			btnContinueMatch = new JButton();
			btnContinueMatch.setText("Continue match");
			btnContinueMatch.setAction(continueMatchAction);
		}
		return btnContinueMatch;
	}

	public JButton getBtnGoBackInTime() {
		if (btnGoBackInTime == null) {
			btnGoBackInTime = new JButton();
			btnGoBackInTime.setText("Go back in time");
			btnGoBackInTime.setAction(new GoBackInTimeAction(this,
					"Go back in time"));
		}
		return btnGoBackInTime;
	}

	/**
	 * @return the btnPause
	 */
	public final JButton getBtnPause() {
		return btnPause;
	}

	public JButton getBtnShowChronometer() {
		if (btnShowChronometer == null) {
			btnShowChronometer = new JButton();
			btnShowChronometer.setText("Show chronometer");
			btnShowChronometer.setAction(new ShowChronometerAction(this,
					"Show chronometer"));
		}
		return btnShowChronometer;
	}

	/**
	 * @return the btnStart
	 */
	public final JButton getBtnStart() {
		return btnStart;
	}

	public JButton getBtnStartNextPeriod() {
		if (btnStartNextPeriod == null) {
			btnStartNextPeriod = new JButton();
			btnStartNextPeriod.setText("Start next period");
			btnStartNextPeriod.setAction(new StartNextPeriodAction(this,
					"Start next period"));
		}
		return btnStartNextPeriod;
	}

	/**
	 * @return the continueMatchAction
	 */
	public final ContinueMatchAction getContinueMatchAction() {
		return continueMatchAction;
	}

	/**
	 * @return the currentMatch
	 */
	public final JScoreboardFrame getCurrentMatch() {
		return currentMatch;
	}

	/**
	 * @return the pauseMatchAction
	 */
	public final PauseMatchAction getPauseMatchAction() {
		return pauseMatchAction;
	}

	/**
	 * @return the pnlMain
	 */
	public final JPanel getPnlMain() {
		return pnlMain;
	}

	/**
	 * @return the spinnerGuest
	 */
	public final JSpinner getSpinnerGuest() {
		return spinnerGuest;
	}

	/**
	 * @return the spinnerHost
	 */
	public final JSpinner getSpinnerHost() {
		return spinnerHost;
	}

	/**
	 * @return the spinnerPeriod
	 */
	public final JSpinner getSpinnerPeriod() {
		return spinnerPeriod;
	}

	/**
	 * @return the stateHolder
	 */
	public final StateHolder getStateHolder() {
		return stateHolder;
	}

	/**
	 * @return the txtGuest
	 */
	public final JTextField getTxtGuest() {
		return txtGuest;
	}

	/**
	 * @return the txtGuestPenalty1
	 */
	public final JTextField getTxtGuestPenalty1() {
		return txtGuestPenalty1;
	}

	/**
	 * @return the txtGuestPenalty2
	 */
	public final JTextField getTxtGuestPenalty2() {
		return txtGuestPenalty2;
	}

	/**
	 * @return the txtHost
	 */
	public final JTextField getTxtHost() {
		return txtHost;
	}

	/**
	 * @return the txtHostPenalty1
	 */
	public final JTextField getTxtHostPenalty1() {
		return txtHostPenalty1;
	}

	/**
	 * @return the txtHostPenalty2
	 */
	public final JTextField getTxtHostPenalty2() {
		return txtHostPenalty2;
	}

	/**
	 * @return the txtTime
	 */
	public final JTextField getTxtTime() {
		return txtTime;
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			this.setTitle("Floorball Scoreboard (by Ondrej Kvasnovsky)");
			{
				pnlMain = new JPanel();
				GridBagLayout pnlMainLayout = new GridBagLayout();
				getContentPane().add(pnlMain, BorderLayout.CENTER);
				pnlMainLayout.rowWeights = new double[] { 0.0, 0.1, 0.1, 0.1,
						0.1, 0.1, 0.1 };
				pnlMainLayout.rowHeights = new int[] { 45, 7, 7, 20, 20, 7, 20 };
				pnlMainLayout.columnWeights = new double[] { 0.0, 0.0, 0.3 };
				pnlMainLayout.columnWidths = new int[] { 200, 200, 20 };
				pnlMain.setLayout(pnlMainLayout);
				{
					txtTime = new JFormattedTextField(createFormatter("##:##"));
					pnlMain.add(txtTime, new GridBagConstraints(1, 0, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0,
									5), 0, 0));
					txtTime.setText("20:00");
				}
				{
					txtHost = new JTextField();
					pnlMain.add(txtHost, new GridBagConstraints(0, 0, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0,
									5), 0, 0));
					txtHost.setText("Host");
				}
				{
					txtGuest = new JTextField();
					pnlMain.add(txtGuest, new GridBagConstraints(2, 0, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0,
									5), 0, 0));
					txtGuest.setText("Guest");
				}
				{
					SpinnerListModel spinnerHostModel = new SpinnerListModel(
							values);
					spinnerHost = new JSpinner();
					pnlMain.add(spinnerHost, new GridBagConstraints(0, 1, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0,
							0));
					spinnerHost.setModel(spinnerHostModel);
					spinnerHost.getEditor().setFont(
							new java.awt.Font("Dialog", 0, 18));
				}
				{
					SpinnerListModel spinnerGuestModel = new SpinnerListModel(
							values);
					spinnerGuest = new JSpinner();
					pnlMain.add(spinnerGuest, new GridBagConstraints(2, 1, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0,
							0));
					spinnerGuest.setModel(spinnerGuestModel);
					spinnerGuest.getEditor().setFont(
							new java.awt.Font("Dialog", 0, 18));
				}
				{
					SpinnerListModel spinnerPeriodModel = new SpinnerListModel(
							new String[] { "1", "2", "3" });
					spinnerPeriod = new JSpinner();
					pnlMain.add(spinnerPeriod, new GridBagConstraints(1, 1, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0,
							0));
					spinnerPeriod.setModel(spinnerPeriodModel);
				}
				{
					btnStart = new JButton();
					pnlMain.add(btnStart, new GridBagConstraints(0, 6, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(1, 5, 0,
									5), 0, 0));
					btnStart.setText("Start match");
					btnStart.setAction(new StartMatchAction(this, "Start match"));
				}
				{
					btnPause = new JButton();
					pnlMain.add(btnPause, new GridBagConstraints(1, 6, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0,
									5), 0, 0));
					btnPause.setText("Pause match");
					btnPause.setAction(pauseMatchAction);
				}
				{
					txtHostPenalty1 = new JFormattedTextField(
							createFormatter("#:##"));
					pnlMain.add(txtHostPenalty1, new GridBagConstraints(0, 2,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(1, 5, 1,
									5), 0, 0));
				}
				{
					txtHostPenalty2 = new JFormattedTextField(
							createFormatter("#:##"));
					pnlMain.add(txtHostPenalty2, new GridBagConstraints(0, 3,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(1, 5, 1,
									5), 0, 0));
				}
				{
					txtGuestPenalty2 = new JFormattedTextField(
							createFormatter("#:##"));
					pnlMain.add(txtGuestPenalty2, new GridBagConstraints(2, 3,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(1, 5, 1,
									5), 0, 0));
				}
				{
					txtGuestPenalty1 = new JFormattedTextField(
							createFormatter("#:##"));
					pnlMain.add(txtGuestPenalty1, new GridBagConstraints(2, 2,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(1, 5, 1,
									5), 0, 0));
					pnlMain.add(getBtnShowChronometer(),
							new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER,
									GridBagConstraints.HORIZONTAL, new Insets(
											0, 5, 1, 5), 0, 0));
					pnlMain.add(getBtnContinueMatch(), new GridBagConstraints(
							2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0,
									5), 0, 0));
					pnlMain.add(getBtnStartNextPeriod(),
							new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER,
									GridBagConstraints.HORIZONTAL, new Insets(
											1, 5, 1, 5), 0, 0));
					pnlMain.add(getBtnGoBackInTime(), new GridBagConstraints(2,
							5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(1, 5, 1,
									5), 0, 0));
				}
			}
			pack();
			setSize(600, 220);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param currentMatch
	 *            the currentMatch to set
	 */
	public final void setCurrentMatch(JScoreboardFrame currentMatch) {
		this.currentMatch = currentMatch;
	}

	/**
	 * @param state
	 * @see scoreboard.floorball.state.StateHolder#setState(scoreboard.floorball.state.State)
	 */
	public final void setState(State state) {
		stateHolder.setState(state);
	}
}
