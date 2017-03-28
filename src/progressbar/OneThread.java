package progressbar;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JProgressBar;

public class OneThread extends Thread {
	JProgressBar bar;
	int count = 0;
	int interval;

	public OneThread(int interval, JProgressBar bar) {
		this.interval = interval;
		this.bar = bar;
		bar.setPreferredSize(new Dimension(450, 40));
		this.start();
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			bar.setValue(count);
		}
	}
}
