package file;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileExplorer extends JFrame {

	JPanel p;
	ImageIcon icon, sel_icon;
	JButton bt;
	JLabel label;
	File file;
	ArrayList list;
	

	public FileExplorer() {
		setLayout(new FlowLayout());
		p = new JPanel();
		icon = new ImageIcon("C:/java_workspace2/project0327/res/folder_off.png");
		sel_icon = new ImageIcon("C:/java_workspace2/project0327/res/folder_on.png");
		file = new File("C:/java_workspace2/project0327");
		label = new JLabel("¶óº§");
		bt = new JButton(icon);
		list = new ArrayList();
		//add(p);
		//p.setLayout(new BorderLayout());

		File[] dir = file.listFiles();
		for (int i = 0; i < dir.length; i++) {
			if (dir[i].isDirectory()) {
				System.out.println(dir[i].getName());
				p = new JPanel();
				add(p);
				label = new JLabel(dir[i].getName());
				bt = new JButton(icon);
				list.add(bt);
				p.setLayout(new BorderLayout());
				p.add(label, BorderLayout.NORTH);
				p.add(bt, BorderLayout.CENTER);
				p.setBackground(Color.yellow);
				bt.setBorderPainted(false);
				bt.setContentAreaFilled(false);
				bt.setFocusPainted(false);
				bt.setOpaque(false);
				
			}
		}
		bt.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				icon=sel_icon;
				System.out.println(icon);
				bt.setIcon(icon);
			}
		});

	

	

	

		setVisible(true);
		setSize(600, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new FileExplorer();

	}

}
