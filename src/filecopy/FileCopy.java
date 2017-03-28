package filecopy;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class FileCopy extends JFrame{
	JProgressBar bar;
	JButton open_bt, save_bt, copy_bt;
	JTextField ori_path, dest_path;
	FileInputStream fis;
	FileOutputStream fos;
	JFileChooser chooser;
	InputStreamReader reader;
	OutputStreamWriter writer;
	BufferedReader buff_in;
	PrintWriter writer2;
	public FileCopy(){
		setLayout(new FlowLayout());
		
		bar = new JProgressBar();
		open_bt = new JButton("����");
		save_bt = new JButton("����");
		copy_bt = new JButton("����");
		ori_path = new JTextField(35);
		dest_path = new JTextField(35);
		chooser = new JFileChooser("C:/java_workspace2/project0327");
		
		
		
		bar.setPreferredSize(new Dimension(450, 50));
		
		add(bar);
		add(open_bt);
		add(ori_path);
		add(save_bt);
		add(dest_path);
		add(copy_bt);
		
		open_bt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				open();
				
			}
		});
		
		copy_bt.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				copy();
				
			}
		});
		
		save_bt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		setVisible(true);
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void open(){
		int state=chooser.showOpenDialog(this);
		if(state==chooser.APPROVE_OPTION){
			File file=chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			ori_path.setText(path);
			
		}
	}
	
	public void copy(){
		String ori = ori_path.getText();
		String dest = dest_path.getText();
		String data;
		try {
			fis = new FileInputStream(ori);
			reader = new InputStreamReader(fis, "utf-8");
			buff_in = new BufferedReader(reader);
			fos = new FileOutputStream(dest);
			writer = new OutputStreamWriter(fos, "utf-8");
			writer2 = new PrintWriter(writer);
			while(true){
				data=buff_in.readLine();
				if(data==null)break;
				writer2.write(data+"\n");
				
			}
			JOptionPane.showMessageDialog(this,"����Ϸ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				}
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				}
			
		}
	}
	
	public void save(){
		int state=chooser.showOpenDialog(this);
		chooser.setApproveButtonText("�����ϱ�");
		if(state==chooser.APPROVE_OPTION){
			File file=chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			dest_path.setText(path);
		}
	}
	public static void main(String[] args) {
		new FileCopy();

	}

}