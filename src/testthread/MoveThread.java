package testthread;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class MoveThread extends Thread{
	TestThread tt;
	
	
	public MoveThread(TestThread tt){
		this.tt=tt;
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tt.move();
		}
	}
}
