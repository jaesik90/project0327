//���� ǥ���� ��ü �� ������
package homework;

import java.awt.Color;
import java.awt.Graphics;

public class CircleThread extends ShapeThread{

	public CircleThread(int x, int y, int width, int height, int interval, Graphics g){
		super(x,y,width,height,interval,g);
	}
	public void render(){
		System.out.println("g="+g);
		//�����
		//����� ����Ʈ�� �����쿡 �����ϰ�
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 700, 600);
		
		
		//�׸���
		x+=5;
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
		
	}
}
