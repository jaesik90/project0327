package count;

public class RightThread extends Thread {
	int count = 0;

	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
		}
	}
}
