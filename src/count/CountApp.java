package count;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CountApp extends JFrame{
	JLabel left_la, right_la;
	JPanel p;
	LeftThread lt;
	RightThread rt;
	
	public CountApp(){
		p = new JPanel();
		lt = new LeftThread();
		rt = new RightThread();
		
		System.out.println(lt);
	
		left_la = new JLabel("0");
		right_la = new JLabel("0");
		
		lt.start();
		rt.start();
		
		left_la.setText(Integer.toString(lt.count));
			
		
		add(p);
		p.add(left_la);
		p.add(right_la);
		
		setVisible(true);
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args){
		new CountApp();
		
	}
}
