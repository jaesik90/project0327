package progressbar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarTest extends JFrame {
	JProgressBar[] bar = new JProgressBar[3];
	MyBar[] mb= new MyBar[3];
	int[] interval={100,500,1000};
	JButton bt;
	int count=0;


	public ProgressBarTest() {
		setLayout(new FlowLayout());
		for(int i=0; i<bar.length; i++){
			bar[i] = new JProgressBar();
			bar[i].setPreferredSize(new Dimension(450, 40));
			add(bar[i]);
			mb[i] = new MyBar(bar[i], interval[i]);
		}
		bt = new JButton("ÀÛµ¿");
		add(bt);
		
		
		
		bt.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		setSize(500, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ProgressBarTest();

	}

}
