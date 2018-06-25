package b_bl;

import java.util.Observable;

public class TimeThread extends Observable implements Runnable{
private int time = 0;
private Game game;

	public TimeThread(Game game) {
		this.game = game;
	}

	public void run() {
		this.time = 0;
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.game.incTime();
		}
	}
	/*public int getTime() {
		return this.time;
	}*/

}
