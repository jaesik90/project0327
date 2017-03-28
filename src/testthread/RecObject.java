package testthread;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class RecObject {
	Canvas can;
	int x = 0;
	TestThread tt;
	RecObject ro;

	public RecObject(TestThread tt){
		this.tt =tt;
	can =new Canvas(){
	public void paint(Graphics g) {
		g.drawRect(x, 0, 50, 50);
		g.drawOval(x, 100, 50, 50);
		g.drawRoundRect(x, 200, 50, 50, 10, 10);
	}
	};
	}
}
