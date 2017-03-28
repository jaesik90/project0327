//움직임 로직을 담게 될 쓰레드!!
package thread;

public class MyMoveThread extends Thread{
	AniMain aniMain;
	
	public MyMoveThread(AniMain aniMain){
		this.aniMain=aniMain;
		
	}
	//개발자는 독립 실행할 코드를 run에 기재
	//JVM이 run을 알아서 호출해준다!!!
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
