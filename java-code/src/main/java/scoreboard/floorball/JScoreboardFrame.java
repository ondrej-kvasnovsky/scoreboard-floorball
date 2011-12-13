/**
 * MainTimer.java 18.9.2010
 */
package scoreboard.floorball;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import scoreboard.floorball.listener.MainTimerTimeListener;
import scoreboard.floorball.listener.PauseContinueMatchKeyListener;
import scoreboard.floorball.listener.PenaltyTimeListener;
import scoreboard.floorball.listener.TimeOutTimeListener;
import scoreboard.timer.MainTimer;
import scoreboard.timer.TimerTask;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * @author Kvasnovsky Ondrej
 */
public class JScoreboardFrame extends javax.swing.JFrame {

    private final JScoreboardManagerFrame frameManager;
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
    private JLabel lblTimeOut;
    private final MainTimer mainTimer = new MainTimer();
    private MainTimer timeoutTimer = new MainTimer();
    private TimerTask timerTimeOutGuest;
    private TimerTask timerTimeOutHost;
    private TimerTask mainTimerTask;
    /**
     * Sets the timeoutTimer.
     * 
     * @param timeoutTimer the timeoutTimer to set
     */
    public void setTimeoutTimer(MainTimer timeoutTimer) {
        this.timeoutTimer = timeoutTimer;
    }

    private JPanel pnlMain;
    private TimerTask timerGuestPenalty1;
    private TimerTask timerGuestPenalty2;
    private TimerTask timerHostPenalty1;
    private JLabel lblTimeOutGuest;
    private JLabel lblTimeOutHost;
    private TimerTask timerHostPenalty2;

    public JScoreboardFrame(final JScoreboardManagerFrame frame) {
        super();
        initGUI();
        this.frameManager = frame;
        this.getLblTime().setText(frame.getTxtTime().getText());
        this.lblHost.setText(frame.getTxtHost().getText());
        this.lblGuest.setText(frame.getTxtGuest().getText());
        addKeyListener(new PauseContinueMatchKeyListener(frame));
        setFocusable(true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    public void continueMatch() {
        this.getMainTimer().cont();
    }

    public void goBackInTime(final Integer seconds) {
        this.getMainTimer().goBackInTime(seconds);
        updateTimeTaskData();
    }

    private void initGUI() {
        try {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            final GridBagLayout thisLayout = new GridBagLayout();
            this.setTitle("Floorball Scoreboard (by Ondrej Kvasnovsky)");
            thisLayout.rowWeights = new double[] {0.1, 0.1, 0.1};
            thisLayout.rowHeights = new int[] {7, 7, 7};
            thisLayout.columnWeights = new double[] {0.1, 0.1, 0.1};
            thisLayout.columnWidths = new int[] {7, 7, 7};
            getContentPane().setLayout(thisLayout);
            getContentPane().setBackground(new java.awt.Color(255, 255, 255));
            {
                this.pnlMain = new JPanel();
                GridBagLayout pnlMainLayout = new GridBagLayout();
                getContentPane().add(
                        this.pnlMain,
                        new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                pnlMainLayout.rowWeights = new double[] {0.1, 0.0, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
                pnlMainLayout.rowHeights = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7};
                pnlMainLayout.columnWeights = new double[] {0.6, 0.5, 0.5};
                pnlMainLayout.columnWidths = new int[] {220, 200, 220};
                pnlMain.setLayout(pnlMainLayout);
                this.pnlMain.setBackground(new java.awt.Color(255, 255, 255));
                {
                    this.setLblTime(new JLabel("", SwingConstants.CENTER));
                    this.pnlMain.add(this.getLblTime(), new GridBagConstraints(1, 0, 1, 1,
                            0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
                            0));
                    this.getLblTime().setText("00:00");
                    this.getLblTime().setFont(new java.awt.Font("Tahoma", 0, 120));
                    this.getLblTime().setForeground(new java.awt.Color(206, 0, 0));
                }
                {
                    this.lblHost = new JLabel("", SwingConstants.CENTER);
                    final FlowLayout lblHostLayout = new FlowLayout();
                    this.lblHost.setLayout(lblHostLayout);
                    this.pnlMain.add(this.lblHost, new GridBagConstraints(0, 0, 1, 1,
                            0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
                            0));
                    this.lblHost.setFont(new java.awt.Font("Tahoma", 0, 60));
                    this.lblHost.setText("Host");
                }
                {
                    this.lblGuest = new JLabel("", SwingConstants.CENTER);
                    final FlowLayout lblGuestLayout = new FlowLayout();
                    this.lblGuest.setLayout(lblGuestLayout);
                    this.pnlMain.add(this.lblGuest, new GridBagConstraints(2, 0, 1, 1,
                            0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
                            0));
                    this.lblGuest.setFont(new java.awt.Font("Tahoma", 0, 60));
                    this.lblGuest.setText("Guest");
                }
                {
                    this.setLblPeriod(new JLabel("", SwingConstants.CENTER));
                    pnlMain.add(getLblPeriod(), new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                    this.getLblPeriod().setText("1");
                    this.getLblPeriod().setFont(new java.awt.Font("Tahoma", 0, 60));
                    this.getLblPeriod().setForeground(new java.awt.Color(0, 179, 0));
                }
                {
                    this.setLblHostPenalty1(new JLabel(" ", SwingConstants.CENTER));
                    pnlMain.add(getLblHostPenalty1(), new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                    this.getLblHostPenalty1()
                            .setForeground(new java.awt.Color(255, 0, 0));
                    this.getLblHostPenalty1().setFont(new java.awt.Font("Tahoma", 0, 60));
                }
                {
                    this.setLblHostPenalty2(new JLabel(" ", SwingConstants.CENTER));
                    pnlMain.add(getLblHostPenalty2(), new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                    this.getLblHostPenalty2().setText("");
                    this.getLblHostPenalty2()
                            .setForeground(new java.awt.Color(255, 0, 0));
                    this.getLblHostPenalty2().setFont(new java.awt.Font("Tahoma", 0, 60));
                }
                {
                    this.setLblGuestPenalty1(new JLabel(" ", SwingConstants.CENTER));
                    pnlMain.add(getLblGuestPenalty1(), new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                    this.getLblGuestPenalty1().setText(" ");
                    this.getLblGuestPenalty1()
                            .setForeground(new java.awt.Color(255, 0, 0));
                    this.getLblGuestPenalty1()
                            .setFont(new java.awt.Font("Tahoma", 0, 60));
                }
                {
                    this.setLblGuestPenalty2(new JLabel("", SwingConstants.CENTER));
                    pnlMain.add(getLblGuestPenalty2(), new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                    this.getLblGuestPenalty2().setText(" ");
                    this.getLblGuestPenalty2()
                            .setForeground(new java.awt.Color(255, 0, 0));
                    this.getLblGuestPenalty2()
                            .setFont(new java.awt.Font("Tahoma", 0, 60));
                }
                {
                    this.lblHostScore = new JLabel("", SwingConstants.CENTER);
                    pnlMain.add(lblHostScore, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                    this.lblHostScore.setText("0");
                    this.lblHostScore.setFont(new java.awt.Font("Tahoma", 0, 120));
                    lblHostScore.setForeground(new java.awt.Color(0, 0, 0));
                }
                {
                    this.lblGuestScore = new JLabel("", SwingConstants.CENTER);
                    pnlMain.add(lblGuestScore, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                    this.lblGuestScore.setText("0");
                    this.lblGuestScore.setFont(new java.awt.Font("Tahoma", 0, 120));
                    lblGuestScore.setForeground(new java.awt.Color(0, 0, 0));
                }
                {
                    this.lblTimeOut = new JLabel();
                    pnlMain.add(lblTimeOut, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
                    lblTimeOut.setText("");
                    this.lblTimeOut.setFont(new java.awt.Font("Tahoma", 0, 60));
                    lblTimeOut.setForeground(new java.awt.Color(128, 0, 255));
                }
                {
                    lblTimeOutHost = new JLabel();
                    pnlMain.add(lblTimeOutHost, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                            GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    lblTimeOutHost.setText("");
                    lblTimeOutHost.setFont(new java.awt.Font("Tahoma", 0, 48));
                    lblTimeOutHost.setForeground(new java.awt.Color(128, 0, 255));
                }
                {
                    lblTimeOutGuest = new JLabel();
                    pnlMain.add(lblTimeOutGuest, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                            GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    lblTimeOutGuest.setText("");
                    lblTimeOutGuest.setForeground(new java.awt.Color(128, 0, 255));
                    lblTimeOutGuest.setFont(new java.awt.Font("Tahoma", 0, 48));
                }
            }
            pack();
            this.setSize(910, 606);
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void pauseMatch() {
        this.getMainTimer().pause();
    }

    public void penaltyToGuest() {
        if (this.getTimerGuestPenalty1() == null
                && !"".equals(this.getFrameManager().getTxtGuestPenalty1().getText().trim())
                && !":".equals(this.getFrameManager().getTxtGuestPenalty1().getText().trim())) {
            this.setTimerGuestPenalty1(new TimerTask(this.getFrameManager().getTxtGuestPenalty1()
                    .getText()));
            this.getMainTimer().addMainTimerListener(this.getTimerGuestPenalty1());
            final PenaltyTimeListener listener = new PenaltyTimeListener(
                    this, this.getLblGuestPenalty1(), this.getFrameManager().getTxtGuestPenalty1(),
                    this.getTimerGuestPenalty1());
            this.getTimerGuestPenalty1().add(listener);
        }
        if (this.getTimerGuestPenalty2() == null
                && !"".equals(this.getFrameManager().getTxtGuestPenalty2().getText().trim())
                && !":".equals(this.getFrameManager().getTxtGuestPenalty2().getText().trim())) {
            this.setTimerGuestPenalty2(new TimerTask(this.getFrameManager().getTxtGuestPenalty2()
                    .getText()));
            this.getMainTimer().addMainTimerListener(this.getTimerGuestPenalty2());
            final PenaltyTimeListener listener = new PenaltyTimeListener(
                    this, this.getLblGuestPenalty2(), this.getFrameManager().getTxtGuestPenalty2(),
                    this.getTimerGuestPenalty2());
            this.getTimerGuestPenalty2().add(listener);
        }
    }

    public void penaltyToHost() {
        if (this.getTimerHostPenalty1() == null
                && !"".equals(this.getFrameManager().getTxtHostPenalty1().getText().trim())
                && !":".equals(this.getFrameManager().getTxtHostPenalty1().getText().trim())) {
            this.setTimerHostPenalty1(new TimerTask(this.getFrameManager().getTxtHostPenalty1()
                    .getText()));
            final PenaltyTimeListener listener = new PenaltyTimeListener(
                    this, this.getLblHostPenalty1(), this.getFrameManager().getTxtHostPenalty1(),
                    this.getTimerHostPenalty1());
            this.getMainTimer().addMainTimerListener(this.getTimerHostPenalty1());
            this.getTimerHostPenalty1().add(listener);
        }
        if (this.getTimerHostPenalty2() == null
                && !"".equals(this.getFrameManager().getTxtHostPenalty2().getText().trim())
                && !":".equals(this.getFrameManager().getTxtHostPenalty2().getText().trim())) {
            this.setTimerHostPenalty2(new TimerTask(this.getFrameManager().getTxtHostPenalty2()
                    .getText()));
            final PenaltyTimeListener listener = new PenaltyTimeListener(
                    this, this.getLblHostPenalty2(), this.getFrameManager().getTxtHostPenalty2(),
                    this.getTimerHostPenalty2());
            this.getMainTimer().addMainTimerListener(this.getTimerHostPenalty2());
            this.getTimerHostPenalty2().add(listener);
        }
    }


    /**
     * Returns the timeoutTimer.
     * 
     * @return the timeoutTimer
     */
    public MainTimer getTimeoutTimer() {
        return timeoutTimer;
    }

    /**
     * Returns the timerTimeOutGuest.
     * 
     * @return the timerTimeOutGuest
     */
    public TimerTask getTimerTimeOutGuest() {
        return timerTimeOutGuest;
    }

    /**
     * Returns the timerTimeOutHost.
     * 
     * @return the timerTimeOutHost
     */
    public TimerTask getTimerTimeOutHost() {
        return timerTimeOutHost;
    }

    /**
     * Returns the lblTimeOut.
     * 
     * @return the lblTimeOut
     */
    public JLabel getLblTimeOut() {
        return lblTimeOut;
    }

    private final String timeoutTime = "00:30";
    
    public void startTimeOutForHost() {
        this.lblTimeOutHost.setText("T");
        this.lblTimeOut.setText(timeoutTime);
        this.timerTimeOutHost = new TimerTask(timeoutTime);
        this.timerTimeOutHost.add(new TimeOutTimeListener(this, TimeOutTimeListener.Type.Host));
        this.timeoutTimer.addMainTimerListener(timerTimeOutHost);
        this.timeoutTimer.start();
    }
    

    public void startTimeOutForGuest() {
        this.lblTimeOutGuest.setText("T");
        this.lblTimeOut.setText(timeoutTime);
        this.timerTimeOutGuest = new TimerTask(timeoutTime);
        this.timerTimeOutGuest.add(new TimeOutTimeListener(this, TimeOutTimeListener.Type.Guest));
        this.timeoutTimer.addMainTimerListener(timerTimeOutGuest);
        this.timeoutTimer.start();
    }

    public void startMatch() {
        this.getMainTimer().start();
        this.setMainTimerTask(new TimerTask(this.getFrameManager().getTxtTime().getText()));
        this.getMainTimer().addMainTimerListener(this.getMainTimerTask());
        this.getMainTimerTask().add(new MainTimerTimeListener(this));
    }

    public void startNextPeriod() {
        this.setMainTimerTask(new TimerTask(this.getFrameManager().getTxtTime().getText()));
        this.getMainTimer().addMainTimerListener(this.getMainTimerTask());
        this.getMainTimerTask().add(new MainTimerTimeListener(this));
        this.getMainTimer().cont();
    }

    public void updateMatchData() {
        this.lblGuestScore.setText(this.getFrameManager().getSpinnerGuest().getValue().toString());
        this.lblHostScore.setText(this.getFrameManager().getSpinnerHost().getValue().toString());
        this.getLblPeriod().setText(this.getFrameManager().getSpinnerPeriod().getValue().toString());
        this.lblHost.setText(this.getFrameManager().getTxtHost().getText());
        this.lblGuest.setText(this.getFrameManager().getTxtGuest().getText());
    }

    public void updateTimeTaskData() {
        if (this.getMainTimerTask() != null) {
            this.getLblTime().setText(this.getMainTimerTask().toString("mm:ss"));
            this.getFrameManager().getTxtTime().setText(this.getMainTimerTask().toString("mm:ss"));
        }
        if (this.getTimerGuestPenalty1() != null) {
            this.getFrameManager().getTxtGuestPenalty1().setText(
                    this.getTimerGuestPenalty1().toString("m:ss"));
            this.getLblGuestPenalty1().setText(this.getTimerGuestPenalty1().toString("m:ss"));
        }
        if (this.getTimerGuestPenalty2() != null) {
            this.getFrameManager().getTxtGuestPenalty2().setText(
                    this.getTimerGuestPenalty2().toString("m:ss"));
            this.getLblGuestPenalty2().setText(this.getTimerGuestPenalty2().toString("m:ss"));
        }
        if (this.getTimerHostPenalty1() != null) {
            this.getFrameManager().getTxtHostPenalty1().setText(
                    this.getTimerHostPenalty1().toString("m:ss"));
            this.getLblHostPenalty1().setText(this.getTimerHostPenalty1().toString("m:ss"));
        }
        if (this.getTimerHostPenalty2() != null) {
            this.getFrameManager().getTxtHostPenalty2().setText(
                    this.getTimerHostPenalty2().toString("m:ss"));
            this.getLblHostPenalty2().setText(this.getTimerHostPenalty2().toString("m:ss"));
        }
    }

    public JLabel getLblTimeOutHost() {
        return lblTimeOutHost;
    }

    public JLabel getLblTimeOutGuest() {
        return lblTimeOutGuest;
    }

    /**
     * Returns the mainTimer.
     * 
     * @return the mainTimer
     */
    public MainTimer getMainTimer() {
        return mainTimer;
    }

    /**
     * Returns the mainTimerTask.
     * 
     * @return the mainTimerTask
     */
    public TimerTask getMainTimerTask() {
        return mainTimerTask;
    }

    /**
     * Sets the mainTimerTask.
     * 
     * @param mainTimerTask the mainTimerTask to set
     */
    public void setMainTimerTask(TimerTask mainTimerTask) {
        this.mainTimerTask = mainTimerTask;
    }

    /**
     * Returns the frame.
     * 
     * @return the frame
     */
    public JScoreboardManagerFrame getFrameManager() {
        return frameManager;
    }

    /**
     * Returns the lblTime.
     * 
     * @return the lblTime
     */
    public JLabel getLblTime() {
        return lblTime;
    }

    /**
     * Sets the lblTime.
     * 
     * @param lblTime the lblTime to set
     */
    public void setLblTime(JLabel lblTime) {
        this.lblTime = lblTime;
    }

    /**
     * Returns the lblPeriod.
     * 
     * @return the lblPeriod
     */
    public JLabel getLblPeriod() {
        return lblPeriod;
    }

    /**
     * Sets the lblPeriod.
     * 
     * @param lblPeriod the lblPeriod to set
     */
    public void setLblPeriod(JLabel lblPeriod) {
        this.lblPeriod = lblPeriod;
    }

    /**
     * Returns the timerGuestPenalty1.
     * 
     * @return the timerGuestPenalty1
     */
    public TimerTask getTimerGuestPenalty1() {
        return timerGuestPenalty1;
    }

    /**
     * Sets the timerGuestPenalty1.
     * 
     * @param timerGuestPenalty1 the timerGuestPenalty1 to set
     */
    public void setTimerGuestPenalty1(TimerTask timerGuestPenalty1) {
        this.timerGuestPenalty1 = timerGuestPenalty1;
    }

    /**
     * Returns the lblGuestPenalty1.
     * 
     * @return the lblGuestPenalty1
     */
    public JLabel getLblGuestPenalty1() {
        return lblGuestPenalty1;
    }

    /**
     * Sets the lblGuestPenalty1.
     * 
     * @param lblGuestPenalty1 the lblGuestPenalty1 to set
     */
    public void setLblGuestPenalty1(JLabel lblGuestPenalty1) {
        this.lblGuestPenalty1 = lblGuestPenalty1;
    }

    /**
     * Returns the timerGuestPenalty2.
     * 
     * @return the timerGuestPenalty2
     */
    public TimerTask getTimerGuestPenalty2() {
        return timerGuestPenalty2;
    }

    /**
     * Sets the timerGuestPenalty2.
     * 
     * @param timerGuestPenalty2 the timerGuestPenalty2 to set
     */
    public void setTimerGuestPenalty2(TimerTask timerGuestPenalty2) {
        this.timerGuestPenalty2 = timerGuestPenalty2;
    }

    /**
     * Returns the lblGuestPenalty2.
     * 
     * @return the lblGuestPenalty2
     */
    public JLabel getLblGuestPenalty2() {
        return lblGuestPenalty2;
    }

    /**
     * Sets the lblGuestPenalty2.
     * 
     * @param lblGuestPenalty2 the lblGuestPenalty2 to set
     */
    public void setLblGuestPenalty2(JLabel lblGuestPenalty2) {
        this.lblGuestPenalty2 = lblGuestPenalty2;
    }

    /**
     * Returns the timerHostPenalty1.
     * 
     * @return the timerHostPenalty1
     */
    public TimerTask getTimerHostPenalty1() {
        return timerHostPenalty1;
    }

    /**
     * Sets the timerHostPenalty1.
     * 
     * @param timerHostPenalty1 the timerHostPenalty1 to set
     */
    public void setTimerHostPenalty1(TimerTask timerHostPenalty1) {
        this.timerHostPenalty1 = timerHostPenalty1;
    }

    /**
     * Returns the lblHostPenalty1.
     * 
     * @return the lblHostPenalty1
     */
    public JLabel getLblHostPenalty1() {
        return lblHostPenalty1;
    }

    /**
     * Sets the lblHostPenalty1.
     * 
     * @param lblHostPenalty1 the lblHostPenalty1 to set
     */
    public void setLblHostPenalty1(JLabel lblHostPenalty1) {
        this.lblHostPenalty1 = lblHostPenalty1;
    }

    /**
     * Returns the timerHostPenalty2.
     * 
     * @return the timerHostPenalty2
     */
    public TimerTask getTimerHostPenalty2() {
        return timerHostPenalty2;
    }

    /**
     * Sets the timerHostPenalty2.
     * 
     * @param timerHostPenalty2 the timerHostPenalty2 to set
     */
    public void setTimerHostPenalty2(TimerTask timerHostPenalty2) {
        this.timerHostPenalty2 = timerHostPenalty2;
    }

    /**
     * Returns the lblHostPenalty2.
     * 
     * @return the lblHostPenalty2
     */
    public JLabel getLblHostPenalty2() {
        return lblHostPenalty2;
    }

    /**
     * Sets the lblHostPenalty2.
     * 
     * @param lblHostPenalty2 the lblHostPenalty2 to set
     */
    public void setLblHostPenalty2(JLabel lblHostPenalty2) {
        this.lblHostPenalty2 = lblHostPenalty2;
    }

}
