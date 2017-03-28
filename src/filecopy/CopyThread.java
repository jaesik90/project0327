package filecopy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class CopyThread extends Thread{
	JProgressBar bar;
	JTextField ori_path;
	JTextField dest_path;
	FileInputStream fis;
	InputStreamReader reader;
	BufferedReader buff_in;
	FileOutputStream fos;
	OutputStreamWriter writer;
	PrintWriter writer2;
	String ori,dest;
	Long len;
	
	int count=0;
	public CopyThread(JProgressBar bar, JTextField ori_path, JTextField dest_path, String ori, String dest, Long len){
		this.bar=bar;
		this.ori_path=ori_path;
		this.dest_path=dest_path;
		this.ori=ori;
		this.dest=ori;
		
	
	}
	
	public void run(){
		 ori = ori_path.getText();
		 dest = dest_path.getText();
		String data;
		try {
			fis = new FileInputStream(ori);
			reader = new InputStreamReader(fis, "utf-8");
			buff_in = new BufferedReader(reader);
			fos = new FileOutputStream(dest);
			writer = new OutputStreamWriter(fos, "utf-8");
			writer2 = new PrintWriter(writer);
			while(true){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				data=buff_in.readLine();
				if(data==null)break;
				writer2.write(data+"\n");
				count++;
				bar.setValue(count);
				System.out.println(bar.getMaximum());
				
				
				
			}
			//JOptionPane.showMessageDialog(this,"복사완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(buff_in!=null){
				try {
					buff_in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				}
			if(writer2!=null){
				writer2.close();
				}
			
		}

	}
}
