/**
 * MainTimer.java 18.9.2010
 */
package scoreboard.floorball;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import scoreboard.floorball.state.StateHolder;
import scoreboard.timer.MainTimer;
import scoreboard.timer.TimerTask;
import scoreboard.timer.TimerTaskListener;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * @author Kvasnovsky Ondrej
 */
public class JScoreboardFrame extends javax.swing.JFrame {

    class MainTimerTimeListener implements TimerTaskListener {

        @Override
        public void taskEnded() {
            JScoreboardFrame.this.mainTimer.pause();
            try {
                // Open an input stream to the audio file.
                final InputStream is = getClass().getResourceAsStream("horn.au");
                // Create an AudioStream object from the input stream.
                final AudioStream as = new AudioStream(is);
                // Use the static class member "player" from class AudioPlayer
                // to play clip.
                AudioPlayer.player.start(as);
                Thread.currentThread();
                Thread.sleep(2000);
                AudioPlayer.player.stop(as);
            }
            catch (final java.net.MalformedURLException e) {
                System.err.println("can't form horn.au URL");
            }
            catch (final IOException e) {
                System.out.println(e.getMessage());
            }
            catch (final InterruptedException e) {
                System.out.println(e.getMessage());
            }
            JScoreboardFrame.this.mainTimer.removeMainTimerListener(JScoreboardFrame.this.mainTimerTask);
            JScoreboardFrame.this.mainTimerTask = null;
            JScoreboardFrame.this.frame.getTxtTime().setText("20:00");
            JScoreboardFrame.this.lblTime.setText("20:00");
            final Integer period = Integer.valueOf(JScoreboardFrame.this.lblPeriod.getText()) + 1;
            JScoreboardFrame.this.frame.getSpinnerPeriod().setValue(period.toString());
            JScoreboardFrame.this.frame.setState(StateHolder.STATE_PERIOD_ENDED);
        }

        @Override
        public void timeChanged() {
            JScoreboardFrame.this.lblTime.setText(JScoreboardFrame.this.mainTimerTask.toString("mm:ss"));
            JScoreboardFrame.this.frame.getTxtTime().setText(JScoreboardFrame.this.mainTimerTask.toString("mm:ss"));
        }
    }

    class PenaltyTimeListener implements TimerTaskListener {

        private final JLabel lbl;
        private final TimerTask timer;
        private final JTextField txt;

        /**
         * @param lbl
         */
        private PenaltyTimeListener(final JLabel lbl, final JTextField txt, final TimerTask timer) {
            this.lbl = lbl;
            this.txt = txt;
            this.timer = timer;
        }

        @Override
        public void taskEnded() {
            if (this.timer == JScoreboardFrame.this.timerGuestPenalty1) {
                JScoreboardFrame.this.frame.getTxtGuestPenalty1().setText("");
                JScoreboardFrame.this.lblGuestPenalty1.setText(" ");
                JScoreboardFrame.this.mainTimer.removeMainTimerListener(JScoreboardFrame.this.timerGuestPenalty1);
                JScoreboardFrame.this.timerGuestPenalty1 = null;
            }
            else if (this.timer == JScoreboardFrame.this.timerGuestPenalty2) {
                JScoreboardFrame.this.frame.getTxtGuestPenalty2().setText("");
                JScoreboardFrame.this.lblGuestPenalty2.setText(" ");
                JScoreboardFrame.this.mainTimer.removeMainTimerListener(JScoreboardFrame.this.timerGuestPenalty2);
                JScoreboardFrame.this.timerGuestPenalty2 = null;
            }
            else if (this.timer == JScoreboardFrame.this.timerHostPenalty1) {
                JScoreboardFrame.this.frame.getTxtHostPenalty1().setText("");
                JScoreboardFrame.this.lblHostPenalty1.setText(" ");
                JScoreboardFrame.this.mainTimer.removeMainTimerListener(JScoreboardFrame.this.timerHostPenalty1);
                JScoreboardFrame.this.timerHostPenalty1 = null;
            }
            else if (this.timer == JScoreboardFrame.this.timerHostPenalty2) {
                JScoreboardFrame.this.frame.getTxtHostPenalty2().setText("");
                JScoreboardFrame.this.lblHostPenalty2.setText(" ");
                JScoreboardFrame.this.mainTimer.removeMainTimerListener(JScoreboardFrame.this.timerHostPenalty2);
                JScoreboardFrame.this.timerHostPenalty2 = null;
            }
        }

        @Override
        public void timeChanged() {
            this.lbl.setText(this.timer.toString("m:ss"));
            this.txt.setText(this.timer.toString("m:ss"));
        }
    }

    private final JScoreboardManagerFrame frame;
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
    private final MainTimer mainTimer = new MainTimer();
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
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    public void continueMatch() {
        this.mainTimer.cont();
    }

    public void goBackInTime(final int seconds) {
        this.mainTimer.goBackInTime(seconds);
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
                final GridBagLayout pnlMainLayout = new GridBagLayout();
                getContentPane().add(
                        this.pnlMain,
                        new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                pnlMainLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
                pnlMainLayout.rowHeights = new int[] {7, 7, 7, 7};
                pnlMainLayout.columnWeights = new double[] {0.6, 0.5, 0.5};
                pnlMainLayout.columnWidths = new int[] {220, 200, 220};
                this.pnlMain.setLayout(pnlMainLayout);
                this.pnlMain.setBackground(new java.awt.Color(255, 255, 255));
                {
                    this.lblTime = new JLabel("", SwingConstants.CENTER);
                    this.pnlMain.add(this.lblTime, new GridBagConstraints(1, 0, 1, 1,
                            0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
                            0));
                    this.lblTime.setText("00:00");
                    this.lblTime.setFont(new java.awt.Font("Tahoma", 0, 120));
                    this.lblTime.setForeground(new java.awt.Color(206, 0, 0));
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
                    this.lblHost.setText("Domaci");
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
                    this.lblGuest.setText("Hoste");
                }
                {
                    this.lblPeriod = new JLabel("", SwingConstants.CENTER);
                    this.pnlMain.add(this.lblPeriod, new GridBagConstraints(1, 1, 1, 1,
                            0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
                            0));
                    this.lblPeriod.setText("1");
                    this.lblPeriod.setFont(new java.awt.Font("Tahoma", 0, 60));
                    this.lblPeriod.setForeground(new java.awt.Color(0, 179, 0));
                }
                {
                    this.lblHostPenalty1 = new JLabel(" ", SwingConstants.CENTER);
                    this.pnlMain.add(this.lblHostPenalty1, new GridBagConstraints(0, 2,
                            1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
                            0));
                    this.lblHostPenalty1
                            .setForeground(new java.awt.Color(255, 0, 0));
                    this.lblHostPenalty1.setFont(new java.awt.Font("Tahoma", 0, 60));
                }
                {
                    this.lblHostPenalty2 = new JLabel(" ", SwingConstants.CENTER);
                    this.pnlMain.add(this.lblHostPenalty2, new GridBagConstraints(0, 3,
                            1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
                            0));
                    this.lblHostPenalty2.setText("");
                    this.lblHostPenalty2
                            .setForeground(new java.awt.Color(255, 0, 0));
                    this.lblHostPenalty2.setFont(new java.awt.Font("Tahoma", 0, 60));
                }
                {
                    this.lblGuestPenalty1 = new JLabel(" ", SwingConstants.CENTER);
                    this.pnlMain.add(this.lblGuestPenalty1, new GridBagConstraints(2, 2,
                            1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
                            0));
                    this.lblGuestPenalty1.setText(" ");
                    this.lblGuestPenalty1
                            .setForeground(new java.awt.Color(255, 0, 0));
                    this.lblGuestPenalty1
                            .setFont(new java.awt.Font("Tahoma", 0, 60));
                }
                {
                    this.lblGuestPenalty2 = new JLabel("", SwingConstants.CENTER);
                    this.pnlMain.add(this.lblGuestPenalty2, new GridBagConstraints(2, 3,
                            1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
                            0));
                    this.lblGuestPenalty2.setText(" ");
                    this.lblGuestPenalty2
                            .setForeground(new java.awt.Color(255, 0, 0));
                    this.lblGuestPenalty2
                            .setFont(new java.awt.Font("Tahoma", 0, 60));
                }
                {
                    this.lblHostScore = new JLabel("", SwingConstants.CENTER);
                    this.pnlMain.add(this.lblHostScore, new GridBagConstraints(0, 1, 1,
                            1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
                            0));
                    this.lblHostScore.setText("0");
                    this.lblHostScore.setFont(new java.awt.Font("Tahoma", 0, 120));
                    this.lblHostScore.setForeground(new java.awt.Color(255, 128, 0));
                }
                {
                    this.lblGuestScore = new JLabel("", SwingConstants.CENTER);
                    this.pnlMain.add(this.lblGuestScore, new GridBagConstraints(2, 1, 1,
                            1, 0.0, 0.0, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
                            0));
                    this.lblGuestScore.setText("0");
                    this.lblGuestScore.setFont(new java.awt.Font("Tahoma", 0, 120));
                    this.lblGuestScore
                            .setForeground(new java.awt.Color(255, 128, 0));
                }
            }
            pack();
            this.setSize(840, 407);
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void pauseMatch() {
        this.mainTimer.pause();
    }

    public void penaltyToGuest() {
        if (this.timerGuestPenalty1 == null
                && !"".equals(this.frame.getTxtGuestPenalty1().getText().trim())
                && !":".equals(this.frame.getTxtGuestPenalty1().getText().trim())) {
            this.timerGuestPenalty1 = new TimerTask(this.frame.getTxtGuestPenalty1()
                    .getText());
            this.mainTimer.addMainTimerListener(this.timerGuestPenalty1);
            final PenaltyTimeListener listener = new PenaltyTimeListener(
                    this.lblGuestPenalty1, this.frame.getTxtGuestPenalty1(),
                    this.timerGuestPenalty1);
            this.timerGuestPenalty1.add(listener);
        }
        if (this.timerGuestPenalty2 == null
                && !"".equals(this.frame.getTxtGuestPenalty2().getText().trim())
                && !":".equals(this.frame.getTxtGuestPenalty2().getText().trim())) {
            this.timerGuestPenalty2 = new TimerTask(this.frame.getTxtGuestPenalty2()
                    .getText());
            this.mainTimer.addMainTimerListener(this.timerGuestPenalty2);
            final PenaltyTimeListener listener = new PenaltyTimeListener(
                    this.lblGuestPenalty2, this.frame.getTxtGuestPenalty2(),
                    this.timerGuestPenalty2);
            this.timerGuestPenalty2.add(listener);
        }
    }

    public void penaltyToHost() {
        if (this.timerHostPenalty1 == null
                && !"".equals(this.frame.getTxtHostPenalty1().getText().trim())
                && !":".equals(this.frame.getTxtHostPenalty1().getText().trim())) {
            this.timerHostPenalty1 = new TimerTask(this.frame.getTxtHostPenalty1()
                    .getText());
            final PenaltyTimeListener listener = new PenaltyTimeListener(
                    this.lblHostPenalty1, this.frame.getTxtHostPenalty1(),
                    this.timerHostPenalty1);
            this.mainTimer.addMainTimerListener(this.timerHostPenalty1);
            this.timerHostPenalty1.add(listener);
        }
        if (this.timerHostPenalty2 == null
                && !"".equals(this.frame.getTxtHostPenalty2().getText().trim())
                && !":".equals(this.frame.getTxtHostPenalty2().getText().trim())) {
            this.timerHostPenalty2 = new TimerTask(this.frame.getTxtHostPenalty2()
                    .getText());
            final PenaltyTimeListener listener = new PenaltyTimeListener(
                    this.lblHostPenalty2, this.frame.getTxtHostPenalty2(),
                    this.timerHostPenalty2);
            this.mainTimer.addMainTimerListener(this.timerHostPenalty2);
            this.timerHostPenalty2.add(listener);
        }
    }

    public void startMatch() {
        this.mainTimer.start();
        this.mainTimerTask = new TimerTask(this.frame.getTxtTime().getText());
        this.mainTimer.addMainTimerListener(this.mainTimerTask);
        this.mainTimerTask.add(new MainTimerTimeListener());
    }

    public void startNextPeriod() {
        this.mainTimerTask = new TimerTask(this.frame.getTxtTime().getText());
        this.mainTimer.addMainTimerListener(this.mainTimerTask);
        this.mainTimerTask.add(new MainTimerTimeListener());
        this.mainTimer.cont();
    }

    public void updateMatchData() {
        this.lblGuestScore.setText(this.frame.getSpinnerGuest().getValue().toString());
        this.lblHostScore.setText(this.frame.getSpinnerHost().getValue().toString());
        this.lblPeriod.setText(this.frame.getSpinnerPeriod().getValue().toString());
        this.lblHost.setText(this.frame.getTxtHost().getText());
        this.lblGuest.setText(this.frame.getTxtGuest().getText());
    }

    public void updateTimeTaskData() {
        if (this.mainTimerTask != null) {
            this.lblTime.setText(this.mainTimerTask.toString("mm:ss"));
            this.frame.getTxtTime().setText(this.mainTimerTask.toString("mm:ss"));
        }
        if (this.timerGuestPenalty1 != null) {
            this.frame.getTxtGuestPenalty1().setText(
                    this.timerGuestPenalty1.toString("m:ss"));
            this.lblGuestPenalty1.setText(this.timerGuestPenalty1.toString("m:ss"));
        }
        if (this.timerGuestPenalty2 != null) {
            this.frame.getTxtGuestPenalty2().setText(
                    this.timerGuestPenalty2.toString("m:ss"));
            this.lblGuestPenalty2.setText(this.timerGuestPenalty2.toString("m:ss"));
        }
        if (this.timerHostPenalty1 != null) {
            this.frame.getTxtHostPenalty1().setText(
                    this.timerHostPenalty1.toString("m:ss"));
            this.lblHostPenalty1.setText(this.timerHostPenalty1.toString("m:ss"));
        }
        if (this.timerHostPenalty2 != null) {
            this.frame.getTxtHostPenalty2().setText(
                    this.timerHostPenalty2.toString("m:ss"));
            this.lblHostPenalty2.setText(this.timerHostPenalty2.toString("m:ss"));
        }
    }
}
