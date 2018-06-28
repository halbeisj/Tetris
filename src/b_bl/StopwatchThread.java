package b_bl;

/**
 * Thread, welcher im Sekundentakt die Anzahl verstrichene Sekunden im Game erh�ht
 * 
 * @see Game
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * 
 */
public class StopwatchThread implements Runnable {

	/**
	 * Game wird konfiguriert
	 * 
	 * @param game Game, welches konfiguriert werden soll
	 */
	public StopwatchThread(Game game) {
	}

	/**
	 * Methode, welche 1000 Millisekunden schl�ft und anschliessend die Sekundenzahl im konfigurierten Game um eins erh�ht
	 * Wenn die Methode unterbrochen wird, passiert nichts (es geschieht keine Fehlerbehandlung xD)
	 */
	public void run() {
		System.out.println("Thread started");
		while(true) {
			System.out.println("alive");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
