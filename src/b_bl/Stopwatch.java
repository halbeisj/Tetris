package b_bl;

/**
 * Thread, welcher im Sekundentakt die Anzahl verstrichene Sekunden im Game erhöht
 * 
 * @see Game
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * 
 * @todo Klasse zu "StopwatchThread" umbenennen.
 */
public class Stopwatch implements Runnable {
	
	/**
	 * Game in welchem die Sekundenzahl erhöht wird
	 */
	private Game game;

	/**
	 * Game wird konfiguriert
	 * 
	 * @param game Game, welches konfiguriert werden soll
	 */
	public Stopwatch(Game game) {
		this.game = game;
	}

	/**
	 * Methode, welche 1000 Millisekunden schläft und anschliessend die Sekundenzahl im konfigurierten Game um eins erhöht
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
			this.game.incTime();
		}
	}
}
