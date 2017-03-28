package thread3;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//개발자가 쓰레드를 상속하여 개발할 수 있으나
//이미 다른 클래스의 자식일 경우, 상속은 불가하다
//이럴때, 사용할 수 있는 객체가 바로
//Runnable 인터페이스이다!!
public class AniMain extends JFrame implements Runnable {
	JButton bt;
	Canvas can;
	int x, y;
	Thread thread;// 내부익명 스타일로 개발

	public AniMain() {
		// Runnable인 객체를 인수로 넘긴다
		// 그러면, run 메서드의 호출은 Runnable을
		// 재정의한 객체의 run을 호출한다
		thread = new Thread(this);
		bt = new JButton("물체이동");
		add(bt, BorderLayout.NORTH);

		can = new Canvas() {

			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);

			}
		};
		can.setBackground(Color.YELLOW);
		add(can);

		// 버튼과 리스너 연결
		bt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// 이동 메서드 호출!!!
				// 동생 쓰레드를 만들어서 일 시키자!!
				thread.start();
			}
		});

		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void move() {
		x += 5;
		can.repaint();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			move();
		}

	}

	public static void main(String[] args) {
		new AniMain();
	}

	

}

/*
 * 쓰레드를 .java로 빼면 장점 : 재사용성이 높다 단점 : main의 주소값을 주는것이 힘들다... 내부익명으로 사용하면 장점 :
 * 멤버변수를 사용할수있다 단점 : 재사용성이 떨어진다 runnable 장점 : 멤버변수를 사용할수 있고 다중상속을 피할수 있다 단점 :
 * 재사용성이 떨어진다
 */
