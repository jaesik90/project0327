//패널이 라벨과 버튼을 가지고 있다
//JPanel has a JLabel & JButton
package file;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	JLabel la;
	JButton bt;
	
	//패널이 태어날때, 그 부품도 같이 태어나야
	//하므로, 생성자에서 초기화 하자!!
	public MyPanel(String title, Icon icon){
		la = new JLabel(title);
		bt = new JButton(icon);
		
		bt.setBorderPainted(false);//경계선 없음
		bt.setContentAreaFilled(false);//색 채우기 없음
		bt.setFocusPainted(false);//포커스에 의한 자국 없애기
		bt.setOpaque(false);//투명
		
		setLayout(new BorderLayout());
		add(la, BorderLayout.NORTH);
		add(bt);
	}
}
