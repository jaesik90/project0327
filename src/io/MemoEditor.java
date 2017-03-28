package io;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame {
	JPanel p_north;
	JButton bt_open, bt_save;
	ImageIcon icon;//�Ϲ� Ŭ����!!
	JTextArea area;
	JScrollPane scroll;

	String ori = "C:/java_workspace2/project0327/res/memo.txt";// ����
	String dest = "C:/java_workspace2/project0327/res/memo_copy.txt";// �ٸ� ������
																		// ������
	FileInputStream fis;
	FileOutputStream fos;

	InputStreamReader reader;// ���ڱ�� �Է½�Ʈ��
	BufferedReader buffer; // ����ó���� ���ڱ�� �Է½�Ʈ��

	// ���ڱ���� ��½�Ʈ��
	OutputStreamWriter writer;
	PrintWriter writer2;// ��������� ��½�Ʈ��

	public MemoEditor() {
		p_north = new JPanel();
		icon = new ImageIcon("C:/java_workspace2/project0327/res/folder_on.png");
		bt_open = new JButton(icon);
		bt_save = new JButton("����");
		area = new JTextArea();
		scroll = new JScrollPane(area);

		add(p_north, BorderLayout.NORTH);
		p_north.add(bt_open);
		p_north.add(bt_save);
		add(scroll);

		// ��ư 2�� �����͸����� ����~!!
		bt_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});

		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		bt_open.setBorderPainted(false);
		bt_open.setContentAreaFilled(false);
		bt_open.setFocusPainted(false);
		bt_open.setOpaque(false);

		setVisible(true);
		setSize(700, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	// ����
	public void open() {

		try {
			fis = new FileInputStream(ori);
			// ���ڱ�� ��Ʈ������ �������ڵ� �Ӽ��� ������ �� �ִ�..
			reader = new InputStreamReader(fis, "utf-8");
			buffer = new BufferedReader(reader);// �Ѷ��ξ� �о����

			String data;
			int count = 0;// read Ƚ���� �˱�����!!

			while (true) {
				data = buffer.readLine(); // 1byte�� �о���δ�!!
				count++;
				if (data == null)
					break;
				area.append(data + "\n");
			}
			System.out.println("count=" + count);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�");
			// ������ ���ñ����� �ؿ��� ���� ���δ�..
			e.printStackTrace();// �����ڸ� ���� ���� �α� ����
		} catch (IOException e) {

		}
	}

	// �����ϱ�
	public void save() {
		try {// FileOutputStream�� ������ ����� ������
				// ������ ������(ũ��� 0����Ʈ�� empty�� ����)
			fos = new FileOutputStream(dest);
			// writer = new OutputStreamWriter(fos, "utf-8");
			writer2 = new PrintWriter(fos);
			writer2.write(area.getText());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ������� ��Ʈ���� ���� �ݴ� ó��...
			if (writer2 != null) {
					writer2.close();
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		new MemoEditor();

	}

}
