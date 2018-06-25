package b_bl;

public class TimeThread implements Runnable {
private Game game;

	public TimeThread(Game game) {
		this.game = game;
	}

	public void run() {
		System.out.println("Thread started");
		while(true) {
			System.out.println("alive");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			this.game.incTime();
		}
	}
}
