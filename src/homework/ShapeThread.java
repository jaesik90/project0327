/*
 * ���̴�, �簢���̴�, � ������ ǥ���� ��ü
 * �̴� ��� ��Ŭ������ �ڽ����� ����..
 * ��? ������ Ư¡�� �����Ƿ�...
 * */
package homework;

import java.awt.Color;
import java.awt.Graphics;

abstract public class ShapeThread extends Thread {
	int x;
	int y;
	int width;
	int height;
	int interval;
	Graphics g;
	
	public ShapeThread(int x, int y, int width, int height, int interval, Graphics g){
		this.g=g;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.interval=interval;
		
		start();
	
	}

	abstract public void render();
	public void run() {
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
		}
	}
}
