//������ ������ ��� �� ������!!
package thread;

public class MyMoveThread extends Thread{
	AniMain aniMain;
	
	public MyMoveThread(AniMain aniMain){
		this.aniMain=aniMain;
		
	}
	//�����ڴ� ���� ������ �ڵ带 run�� ����
	//JVM�� run�� �˾Ƽ� ȣ�����ش�!!!
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aniMain.move();
		}
	}
}
