package a_gui;

import b_bl.Game;

/**
 * Stellt ein Objekt dar, welches ein Spiel steuern kann.
 * 
 * @author Julia Halbeisen
 */
public interface IGameController {
	/**
	 * Verschiebt Figur in Game nach links.
	 */
	public void left();

	/**
	 * Verschiebt Figur in Game nach rechts.
	 */
	public void right();
	
	/**
	 * Verschiebt Figur in Game nach unten.
	 */
	public void down();
	
	/**
	 * Startet ein neues Spiel.
	 */
	public void newGame();
	
	/**
	 * Beendet das Spiel.
	 */
	public void endGame();

	/**
	 * Setzt den Name des Spielers.
	 */
	public void setPlayerName(String name);
	
	/**
	 * Gibt die Breite des Spielfelds zurück.
	 */
	public int getFieldWidth();
	
	/**
	 * Gibt die Höhe des Spielfelds zurück.
	 */
	public int getFieldHeight();
}
