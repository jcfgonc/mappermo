package jcfgonc.mapper.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import org.apache.commons.lang3.time.DurationFormatUtils;

import structures.Ticker;
import utils.VariousUtils;

public class StatusPanel extends JPanel {
	private static final long serialVersionUID = -3946006228924064009L;
	private JLabel algorithmStatus;
	private JLabel objectivesStatus;
	private JLabel constraintsStatus;
	private JLabel populationSizeStatus;
	private JLabel numEpochsStatus;
	private JLabel epochStatus;
	private JLabel numRunsStatus;
	private JLabel currentRunStatus;
	private JLabel ndsSizeStatus;
	private JLabel usedMemoryStatus;
	private JLabel lastEpochDuration;
	private JLabel currentRunTimeStatus;
	private JLabel totalRunTimeStatus;
	private Ticker currentRunTimeCounter;
	private Ticker totalRunTimeCounter;
	private boolean countersInitialized = false;
	private TimerThread timeCountingThread;
	private JLabel runTimeLimitStatus;

	public StatusPanel() {
		setLayout(new GridLayout(0, 2, 0, 0));
		setBorder(new TitledBorder(null, "Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel algorithmLabel = new JLabel("Algorithm: ");
		algorithmLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(algorithmLabel);

		algorithmStatus = new JLabel("");
		algorithmStatus.setHorizontalAlignment(SwingConstants.LEFT);
		add(algorithmStatus);

		JLabel objectivesLabel = new JLabel("Objectives: ");
		objectivesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(objectivesLabel);

		objectivesStatus = new JLabel("");
		objectivesStatus.setHorizontalAlignment(SwingConstants.LEFT);
		add(objectivesStatus);

		JLabel constraintsLabel = new JLabel("Constraints: ");
		constraintsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(constraintsLabel);

		constraintsStatus = new JLabel("");
		constraintsStatus.setHorizontalAlignment(SwingConstants.LEFT);
		add(constraintsStatus);

		JLabel populationSizeLabel = new JLabel("Population Size: ");
		populationSizeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(populationSizeLabel);

		populationSizeStatus = new JLabel("");
		populationSizeStatus.setHorizontalAlignment(SwingConstants.LEFT);
		add(populationSizeStatus);

		JLabel numEpochsLabel = new JLabel("Number of Epochs: ");
		numEpochsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(numEpochsLabel);

		numEpochsStatus = new JLabel("");
		numEpochsStatus.setHorizontalAlignment(SwingConstants.LEFT);
		add(numEpochsStatus);

		JLabel epochLabel = new JLabel("Epoch: ");
		epochLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(epochLabel);

		epochStatus = new JLabel("");
		epochStatus.setHorizontalAlignment(SwingConstants.LEFT);
		add(epochStatus);

		JLabel numRunsLabel = new JLabel("Number of Runs: ");
		numRunsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(numRunsLabel);

		numRunsStatus = new JLabel("");
		numRunsStatus.setHorizontalAlignment(SwingConstants.LEFT);
		add(numRunsStatus);

		JLabel runLabel = new JLabel("Run: ");
		runLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(runLabel);

		currentRunStatus = new JLabel("");
		currentRunStatus.setHorizontalAlignment(SwingConstants.LEFT);
		add(currentRunStatus);
//
		JLabel runTimeLimitLabel = new JLabel("Run Time Limit (minutes): ");
		runTimeLimitLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(runTimeLimitLabel);

		runTimeLimitStatus = new JLabel("");
		runTimeLimitStatus.setHorizontalAlignment(SwingConstants.LEFT);
		add(runTimeLimitStatus);
//
		JLabel runTimeLabel = new JLabel("Current Run Time: ");
		runTimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(runTimeLabel);

		currentRunTimeStatus = new JLabel("");
		currentRunTimeStatus.setHorizontalAlignment(SwingConstants.LEFT);
		add(currentRunTimeStatus);

		JLabel totalRunTimeLabel = new JLabel("Total Run Time: ");
		totalRunTimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(totalRunTimeLabel);

		totalRunTimeStatus = new JLabel("");
		totalRunTimeStatus.setHorizontalAlignment(SwingConstants.LEFT);
		add(totalRunTimeStatus);

		JLabel lastEpochDurationLabel = new JLabel("Last Epoch Duration: ");
		lastEpochDurationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lastEpochDurationLabel);

		lastEpochDuration = new JLabel("");
		lastEpochDuration.setHorizontalAlignment(SwingConstants.LEFT);
		add(lastEpochDuration);

		JLabel ndsSizeLabel = new JLabel("Non-Dominated Set Size: ");
		ndsSizeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(ndsSizeLabel);

		ndsSizeStatus = new JLabel("");
		ndsSizeStatus.setHorizontalAlignment(SwingConstants.LEFT);
		add(ndsSizeStatus);

		JLabel usedMemoryLabel = new JLabel("Used Memory (MB): ");
		usedMemoryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(usedMemoryLabel);

		usedMemoryStatus = new JLabel("");
		usedMemoryStatus.setHorizontalAlignment(SwingConstants.LEFT);
		add(usedMemoryStatus);
	}

	public void setEpoch(int val) {
		epochStatus.setText(Integer.toString(val));
	}

	public void setNumberEpochs(int val) {
		numEpochsStatus.setText(Integer.toString(val));
	}

	public void setNumberRuns(int val) {
		numRunsStatus.setText(Integer.toString(val));
	}

	public void setNDS_Size(int val) {
		ndsSizeStatus.setText(Integer.toString(val));
	}

	public void setObjectives(int val) {
		objectivesStatus.setText(Integer.toString(val));
	}

	public void setConstraints(int val) {
		constraintsStatus.setText(Integer.toString(val));
	}

	public void setPopulationSize(int val) {
		populationSizeStatus.setText(Integer.toString(val));
	}

	public void setCurrentRun(int val) {
		currentRunStatus.setText(Integer.toString(val));
	}

	public void setAlgorithm(String text) {
		algorithmStatus.setText(text);
	}

	public void setRunTimeLimit(String text) {
		runTimeLimitStatus.setText(text);
	}

	public void setCurrentRunTime(double seconds) {
		double millis = seconds * 1000.0;
		String text = DurationFormatUtils.formatDuration((long) millis, "HH:mm:ss", true);
		// String text = String.format("%s s", timeFormat.format(seconds));
		currentRunTimeStatus.setText(text);
	}

	public void setTotalRunTimeStatus(double seconds) {
		double millis = seconds * 1000.0;
		String text = DurationFormatUtils.formatDuration((long) millis, "HH:mm:ss", true);
		// String text = String.format("%s s", timeFormat.format(seconds));
		totalRunTimeStatus.setText(text);
	}

	public void setLastEpochDuration(double seconds) {
		lastEpochDuration.setText(String.format("%.3f s", seconds));
	}

	public void resetCurrentRunTime() {
		this.currentRunTimeCounter.resetTicker();
	}

	public void initializedTimeCounters() {
		this.currentRunTimeCounter = new Ticker();
		this.totalRunTimeCounter = new Ticker();
		countersInitialized = true;
		timeCountingThread = new TimerThread();
		timeCountingThread.setDaemon(true);
		timeCountingThread.start();
	}

	public boolean areCountersInitialized() {
		return countersInitialized;
	}

	public class TimerThread extends Thread {

		private boolean isRunning;

		public TimerThread() {
			this.isRunning = true;
		}

		@Override
		public void run() {
			while (isRunning) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						if (areCountersInitialized()) {
							setCurrentRunTime(currentRunTimeCounter.getElapsedTime());
							setTotalRunTimeStatus(totalRunTimeCounter.getElapsedTime());
						}
						usedMemoryStatus.setText(String.format("%.2f", VariousUtils.getUsedMemoryMB()));
					}
				});

				try {
					Thread.sleep(500L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void setRunning(boolean isRunning) {
			this.isRunning = isRunning;
		}

	}

}
