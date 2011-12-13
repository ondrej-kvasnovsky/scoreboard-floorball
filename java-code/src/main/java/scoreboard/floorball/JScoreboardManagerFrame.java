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
import scoreboard.floorball.action.TimeOutAction;
import scoreboard.floorball.listener.PauseContinueMatchKeyListener;
import scoreboard.floorball.state.State;
import scoreboard.floorball.state.StateHolder;

/**
 * @author Kvasnovsky Ondrej
 */
public class JScoreboardManagerFrame extends JFrame {

    /**
     * Auto-generated main method to display this JFrame
     */
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                final JScoreboardManagerFrame inst = new JScoreboardManagerFrame();
                inst.setLocationRelativeTo(null);
                inst.setVisible(true);
            }
        });
    }

    private JButton btnContinueMatch;
    private JButton btnTimeoutHost;
    private JButton btnTimeoutGuest;
    private JButton btnGoBackInTime;
    private JButton btnPause;
    private JButton btnShowChronometer;
    private JButton btnStart;
    private JButton btnStartNextPeriod;
    final ContinueMatchAction continueMatchAction = new ContinueMatchAction(
            this, "Continue match");
    private JScoreboardFrame currentMatch;
    private final PauseMatchAction pauseMatchAction = new PauseMatchAction(this,
            "Pause match");
    private JPanel pnlMain;
    private JSpinner spinnerGuest;
    private JSpinner spinnerHost;
    private JSpinner spinnerPeriod;
    private final StateHolder stateHolder;
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
            @Override
            public void windowClosing(final WindowEvent e) {
                final int result = JOptionPane.showConfirmDialog(
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

    protected MaskFormatter createFormatter(final String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        }
        catch (final java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
        }
        return formatter;
    }

    public JButton getBtnContinueMatch() {
        if (this.btnContinueMatch == null) {
            this.btnContinueMatch = new JButton();
            this.btnContinueMatch.setText("Continue match");
            this.btnContinueMatch.setAction(this.continueMatchAction);
        }
        return this.btnContinueMatch;
    }

    public JButton getBtnGoBackInTime() {
        if (this.btnGoBackInTime == null) {
            this.btnGoBackInTime = new JButton();
            this.btnGoBackInTime.setText("Go back in time");
            this.btnGoBackInTime.setAction(new GoBackInTimeAction(this,
                    "Go back in time"));
        }
        return this.btnGoBackInTime;
    }

    /**
     * @return the btnPause
     */
    public final JButton getBtnPause() {
        return this.btnPause;
    }

    public JButton getBtnShowChronometer() {
        if (this.btnShowChronometer == null) {
            this.btnShowChronometer = new JButton();
            this.btnShowChronometer.setAction(new ShowChronometerAction(this,
                    "Show chronometer"));
        }
        return this.btnShowChronometer;
    }

    public JButton getBtnTimeoutHost() {
        if (this.btnTimeoutHost == null) {
            this.btnTimeoutHost = new JButton();
            this.btnTimeoutHost.setAction(new TimeOutAction(this,
                    "Time-Out"));
            this.btnTimeoutHost.setActionCommand("TimeoutHost");
        }
        return this.btnTimeoutHost;
    }
    
    public JButton getBtnTimeoutGuest() {
        if (this.btnTimeoutGuest == null) {
            this.btnTimeoutGuest = new JButton();
            this.btnTimeoutGuest.setAction(new TimeOutAction(this,
                    "Time-Out"));
            this.btnTimeoutGuest.setActionCommand("TimeoutGuest");
        }
        return this.btnTimeoutGuest;
    }

    /**
     * @return the btnStart
     */
    public final JButton getBtnStart() {
        return this.btnStart;
    }

    public JButton getBtnStartNextPeriod() {
        if (this.btnStartNextPeriod == null) {
            this.btnStartNextPeriod = new JButton();
            this.btnStartNextPeriod.setText("Start next period");
            this.btnStartNextPeriod.setAction(new StartNextPeriodAction(this,
                    "Start next period"));
        }
        return this.btnStartNextPeriod;
    }

    /**
     * @return the continueMatchAction
     */
    public final ContinueMatchAction getContinueMatchAction() {
        return this.continueMatchAction;
    }

    /**
     * @return the currentMatch
     */
    public final JScoreboardFrame getCurrentMatch() {
        return this.currentMatch;
    }

    /**
     * @return the pauseMatchAction
     */
    public final PauseMatchAction getPauseMatchAction() {
        return this.pauseMatchAction;
    }

    /**
     * @return the pnlMain
     */
    public final JPanel getPnlMain() {
        return this.pnlMain;
    }

    /**
     * @return the spinnerGuest
     */
    public final JSpinner getSpinnerGuest() {
        return this.spinnerGuest;
    }

    /**
     * @return the spinnerHost
     */
    public final JSpinner getSpinnerHost() {
        return this.spinnerHost;
    }

    /**
     * @return the spinnerPeriod
     */
    public final JSpinner getSpinnerPeriod() {
        return this.spinnerPeriod;
    }

    /**
     * @return the stateHolder
     */
    public final StateHolder getStateHolder() {
        return this.stateHolder;
    }

    /**
     * @return the txtGuest
     */
    public final JTextField getTxtGuest() {
        return this.txtGuest;
    }

    /**
     * @return the txtGuestPenalty1
     */
    public final JTextField getTxtGuestPenalty1() {
        return this.txtGuestPenalty1;
    }

    /**
     * @return the txtGuestPenalty2
     */
    public final JTextField getTxtGuestPenalty2() {
        return this.txtGuestPenalty2;
    }

    /**
     * @return the txtHost
     */
    public final JTextField getTxtHost() {
        return this.txtHost;
    }

    /**
     * @return the txtHostPenalty1
     */
    public final JTextField getTxtHostPenalty1() {
        return this.txtHostPenalty1;
    }

    /**
     * @return the txtHostPenalty2
     */
    public final JTextField getTxtHostPenalty2() {
        return this.txtHostPenalty2;
    }

    /**
     * @return the txtTime
     */
    public final JTextField getTxtTime() {
        return this.txtTime;
    }

    private void initGUI() {
        try {
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            this.setTitle("Floorball Scoreboard (by Ondrej Kvasnovsky)");
            {
                this.pnlMain = new JPanel();
                final GridBagLayout pnlMainLayout = new GridBagLayout();
                getContentPane().add(this.pnlMain, BorderLayout.CENTER);
                pnlMainLayout.rowWeights = new double[] {0.0, 0.1, 0.1, 0.1,
                        0.1, 0.1, 0.1};
                pnlMainLayout.rowHeights = new int[] {45, 7, 7, 20, 20, 7, 20};
                pnlMainLayout.columnWeights = new double[] {0.0, 0.0, 0.3};
                pnlMainLayout.columnWidths = new int[] {200, 200, 20};
                this.pnlMain.setLayout(pnlMainLayout);
                Insets insets2 = new Insets(0, 5, 0,
                        5);
                {
                    this.txtTime = new JFormattedTextField(createFormatter("##:##"));
                    this.pnlMain.add(this.txtTime, new GridBagConstraints(1, 0, 1, 1,
                            0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.HORIZONTAL, insets2, 0, 0));
                    this.txtTime.setText("20:00");
                }
                {
                    this.txtHost = new JTextField();
                    this.pnlMain.add(this.txtHost, new GridBagConstraints(0, 0, 1, 1,
                            0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.HORIZONTAL, insets2, 0, 0));
                    this.txtHost.setText("Host");
                }
                {
                    this.txtGuest = new JTextField();
                    this.pnlMain.add(this.txtGuest, new GridBagConstraints(2, 0, 1, 1,
                            0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.HORIZONTAL, insets2, 0, 0));
                    this.txtGuest.setText("Guest");
                }
                Insets insets = new Insets(1, 5, 1,
                        5);
                {
                    final SpinnerListModel spinnerHostModel = new SpinnerListModel(
                            this.values);
                    this.spinnerHost = new JSpinner();
                    this.pnlMain.add(this.spinnerHost, new GridBagConstraints(0, 1, 1, 1,
                            0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, insets, 0,
                            0));
                    this.spinnerHost.setModel(spinnerHostModel);
                    this.spinnerHost.getEditor().setFont(
                            new java.awt.Font("Dialog", 0, 18));
                }
                {
                    final SpinnerListModel spinnerGuestModel = new SpinnerListModel(
                            this.values);
                    this.spinnerGuest = new JSpinner();
                    this.pnlMain.add(this.spinnerGuest, new GridBagConstraints(2, 1, 1,
                            1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, insets, 0,
                            0));
                    this.spinnerGuest.setModel(spinnerGuestModel);
                    this.spinnerGuest.getEditor().setFont(
                            new java.awt.Font("Dialog", 0, 18));
                }
                {
                    final SpinnerListModel spinnerPeriodModel = new SpinnerListModel(
                            new String[] {"1", "2", "3"});
                    this.spinnerPeriod = new JSpinner();
                    this.pnlMain.add(this.spinnerPeriod, new GridBagConstraints(1, 1, 1,
                            1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, insets, 0,
                            0));
                    this.spinnerPeriod.setModel(spinnerPeriodModel);
                }
                {
                    this.btnStart = new JButton();
                    this.pnlMain.add(this.btnStart, new GridBagConstraints(0, 6, 1, 1,
                            0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.HORIZONTAL, new Insets(1, 5, 0,
                                    5), 0, 0));
                    this.btnStart.setText("Start match");
                    this.btnStart.setAction(new StartMatchAction(this, "Start match"));
                }
                {
                    this.btnPause = new JButton();
                    this.pnlMain.add(this.btnPause, new GridBagConstraints(1, 6, 1, 1,
                            0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.HORIZONTAL, insets2, 0, 0));
                    this.btnPause.setText("Pause match");
                    this.btnPause.setAction(this.pauseMatchAction);
                }
                {
                    this.txtHostPenalty1 = new JFormattedTextField(
                            createFormatter("#:##"));
                    this.pnlMain.add(this.txtHostPenalty1, new GridBagConstraints(0, 2,
                            1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.HORIZONTAL, insets, 0, 0));
                }
                {
                    this.txtHostPenalty2 = new JFormattedTextField(
                            createFormatter("#:##"));
                    this.pnlMain.add(this.txtHostPenalty2, new GridBagConstraints(0, 3,
                            1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.HORIZONTAL, insets, 0, 0));
                }
                {
                    this.txtGuestPenalty2 = new JFormattedTextField(
                            createFormatter("#:##"));
                    this.pnlMain.add(this.txtGuestPenalty2, new GridBagConstraints(2, 3,
                            1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.HORIZONTAL, insets, 0, 0));
                }
                {
                    this.txtGuestPenalty1 = new JFormattedTextField(
                            createFormatter("#:##"));

                    this.pnlMain.add(this.txtGuestPenalty1, new GridBagConstraints(2, 2,
                            1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.HORIZONTAL, insets, 0, 0));
                }
                {
                    this.pnlMain.add(getBtnShowChronometer(),
                            new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER,
                                    GridBagConstraints.HORIZONTAL, new Insets(
                                            0, 5, 1, 5), 0, 0));
                }
                {
                    this.pnlMain.add(getBtnContinueMatch(), new GridBagConstraints(
                            2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.HORIZONTAL, insets2, 0, 0));
                }
                {
                    this.pnlMain.add(getBtnTimeoutHost(),
                            new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER,
                                    GridBagConstraints.HORIZONTAL, insets, 0, 0));
                }
                {
                    this.pnlMain.add(getBtnTimeoutGuest(),
                            new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER,
                                    GridBagConstraints.HORIZONTAL, insets, 0, 0));
                }
                {
                    this.pnlMain.add(getBtnStartNextPeriod(),
                            new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER,
                                    GridBagConstraints.HORIZONTAL, insets, 0, 0));
                }
                {
                    this.pnlMain.add(getBtnGoBackInTime(), new GridBagConstraints(2,
                            5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.HORIZONTAL, insets, 0, 0));
                }
            }
            pack();
            setSize(600, 220);
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param currentMatch the currentMatch to set
     */
    public final void setCurrentMatch(final JScoreboardFrame currentMatch) {
        this.currentMatch = currentMatch;
    }

    /**
     * @param state
     * @see scoreboard.floorball.state.StateHolder#setState(scoreboard.floorball.state.State)
     */
    public final void setState(final State state) {
        this.stateHolder.setState(state);
    }

}
