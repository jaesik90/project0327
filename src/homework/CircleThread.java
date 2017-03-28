//원을 표현한 객체 및 움직임
package homework;

import java.awt.Color;
import java.awt.Graphics;

public class CircleThread extends ShapeThread{

	public CircleThread(int x, int y, int width, int height, int interval, Graphics g){
		super(x,y,width,height,interval,g);
	}
	public void render(){
		System.out.println("g="+g);
		//지우고
		//노란색 페인트로 윈도우에 적용하고
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 700, 600);
		
		
		//그리자
		x+=5;
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
		
	}
}
