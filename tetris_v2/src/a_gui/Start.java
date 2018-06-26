package a_gui;

/**
 * In dieser Klasse wird das Spiel gestartet.
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 */
public class Start {
	/**
	 * Controller welcher konfiguriert und gestartet wird
	 */
	private int_Game_Controller controller;
	
	/**Diese Methode ist für den Start des Spiels verantwortlich
	 * Der Controller wird initialisiert
	 * 
	 * @see int_Game_Controller
	 */
	public static void main(String[] args) {
		int_Game_Controller controller = new Game_Controller();
	}
}
