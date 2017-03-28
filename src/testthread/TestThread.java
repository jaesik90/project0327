package testthread;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestThread extends JFrame{
	JButton bt;
	TestThread tt;
	static RecObject ro;
	
	public TestThread(RecObject ro){
		this.ro=ro;
		tt=this;
		bt = new JButton("½ÇÇà");
		add(bt, BorderLayout.NORTH);	
		add(ro.can);
		
		
		bt.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				MoveThread mt = new MoveThread(tt);
				mt.start();
				
			}
		});
		
		setVisible(true);
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void move(){
		ro.x+=5;
		ro.can.repaint();
		
	}
	public static void main(String[] args) {
		new TestThread(ro);

	}

}
