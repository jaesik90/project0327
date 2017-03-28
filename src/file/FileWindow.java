/*
 * 
 * */
package file;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import javax.lang.model.element.Element;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FileWindow extends JFrame{
	MyIcon folder_on, folder_off;
	ArrayList btList;
	
	

	public FileWindow(){
		setLayout(new FlowLayout());
		btList = new ArrayList();
		
		//�̹��� �������� �����ϵ�, ���ҽ� �����κ���...
		//Uniformed Resource Locator(URL) : 
		
		
		folder_on = new MyIcon(this.getClass().getResource("/folder_on.png"),50,50);
		folder_off= new MyIcon(this.getClass().getResource("/folder_off.png"),50,50);
		
		/*
		Image scaledImg=folder_on.getImage();
		
		//ũ�⸦ �� ������ �� ��������� �̹��� ��ü�� �ٽ� ��ȯ
		Image result=scaledImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		folder_on.setImage(result);
		MyIcon�̶�� Ŭ������ ���� �����Ͽ��� �ڵ��� ���뼺�� ������...
		*/
		
		//����� ������ �׽�Ʈ
		ArrayList<String> list=getDirList();
		for(int i=0; i<list.size();i++){
		String dirName=list.get(i);
		MyPanel mp = new MyPanel(dirName, folder_off);
		btList.add(mp);
		add(mp);
		
		System.out.println("i�� :"+i+btList.get(i));
		//System.out.println(btList.get(0));
		//System.out.println(btList.size());
		
		mp.bt.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();//�̺�Ʈ�� ����Ų ������Ʈ
				
				JButton btn=(JButton) obj;
				btn.setIcon(folder_on);
				System.out.println(btn);
			}
		});
		
		}
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//���ϴ� ����� ���� ���丮/���� ���ϱ�
	
	public ArrayList getDirList(){
		
		File file = new File("C:/java_workspace2/project0327");
		File[] fileList=file.listFiles();
		ArrayList<String> dirList=new ArrayList<String>();
		
		//���丮�� �����
		for(int i=0; i<fileList.length; i++){
			if(fileList[i].isDirectory()){
				//���丮�� �߰� �ɶ����� ����Ʈ �߰�
				dirList.add(fileList[i].getName());	
			}
			
		}
		return dirList;
		
	}
	public static void main(String[] args) {
		new FileWindow();

	}

}
