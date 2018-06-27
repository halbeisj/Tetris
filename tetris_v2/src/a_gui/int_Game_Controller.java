package a_gui;

import b_bl.Game;

/**
 * Stellt ein Objekt dar, welches ein Spiel steuern kann.
 * 
 * @author Julia Halbeisen
 */
public interface int_Game_Controller {
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
	 * @todo Methode l�schen.
	 */
	public void setName(String name);
	
	/**
	 * @todo Methode l�schen.
	 */
	public int getWidth();
	
	/**
	 * @todo Methode l�schen.
	 */
	public int getHeight();
}
