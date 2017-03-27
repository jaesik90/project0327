/*
 * 
 * */
package file;

import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FileWindow extends JFrame{
	MyIcon folder_on, folder_off;

	public FileWindow(){
		setLayout(new FlowLayout());
		
		//이미지 아이콘을 생성하되, 리소스 폴더로부터...
		//Uniformed Resource Locator(URL) : 
		
		
		folder_on = new MyIcon(this.getClass().getResource("/folder_on.png"),50,50);
		folder_off= new MyIcon(this.getClass().getResource("/folder_off.png"),50,50);
		
		/*
		Image scaledImg=folder_on.getImage();
		
		//크기를 재 조정한 후 결과적으로 이미지 객체를 다시 반환
		Image result=scaledImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		folder_on.setImage(result);
		MyIcon이라는 클래스를 새로 정의하여서 코드의 재사용성을 높였다...
		*/
		
		//제대로 붙을지 테스트
		ArrayList<String> list=getDirList();
		for(int i=0; i<list.size();i++){
		String dirName=list.get(i);
		MyPanel mp = new MyPanel(dirName, folder_off);
		add(mp);
		}
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//원하는 경로의 하위 디렉토리/파일 구하기
	
	public ArrayList getDirList(){
		
		File file = new File("c:/");
		File[] fileList=file.listFiles();
		ArrayList<String> dirList=new ArrayList<String>();
		
		//디렉토리만 골라내자
		for(int i=0; i<fileList.length; i++){
			if(fileList[i].isDirectory()){
				//디렉토리가 발견 될때마다 리스트 추가
				dirList.add(fileList[i].getName());	
			}
			
		}
		return dirList;
		
	}
	public static void main(String[] args) {
		new FileWindow();

	}

}
