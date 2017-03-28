//�г��� �󺧰� ��ư�� ������ �ִ�
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
	
	//�г��� �¾��, �� ��ǰ�� ���� �¾��
	//�ϹǷ�, �����ڿ��� �ʱ�ȭ ����!!
	public MyPanel(String title, Icon icon){
		la = new JLabel(title);
		bt = new JButton(icon);
		
		bt.setBorderPainted(false);//��輱 ����
		bt.setContentAreaFilled(false);//�� ä��� ����
		bt.setFocusPainted(false);//��Ŀ���� ���� �ڱ� ���ֱ�
		bt.setOpaque(false);//����
		
		setLayout(new BorderLayout());
		add(la, BorderLayout.NORTH);
		add(bt);
	}
}
