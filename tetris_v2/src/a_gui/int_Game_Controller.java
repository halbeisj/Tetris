package a_gui;

import b_bl.Game;

/**Dies ist das Interface des Game Controllers.
 * Über diese Klasse wird auf den Game_Controller zugegriffen.
 * 
 * @see Game_Controller
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public interface int_Game_Controller {
	
	/**
	 * Verschiebt Figur in Game nach links
	 * 
	 * @see Game
	 */
	public void left();

	/**
	 * Verschiebt Figur in Game nach rechts
	 * 
	 * @see Game
	 */
	public void right();
	
	/**
	 * Verschiebt Figur in Game nach unten
	 * 
	 * @see Game
	 */
	public void down();
	
	/**
	 * Startet ein neues Spiel in der Klasse Game
	 * Lädt das Feld neu
	 * Aktiviert das Fenster Game_View
	 * 
	 * @see Game
	 * @see int_Game_View
	 */
	public void newGame();
	
	/**
	 * Startet die End_View mit diesem Controller als Mitgabeparameter
	 */
	public void endGame();
	
	/**
	 * Setzt den Namen im Game_Model.
	 * 
	 * @param name Name der gesetzt werden soll
	 * 
	 * @see int_Game_Model
	 */
	public void setName(String name);
	
	/**
	 * Gibt die Breite des Spielfeldes zurück, welche im Game konfiguriert ist.
	 * 
	 * @return Breite des Spielfeldes
	 * 
	 * @see Game
	 */
	public int getWidth();
	
	/**
	 * Gibt die Höhe des Spielfeldes zurück, welche im Game konfigureiert ist.
	 * 
	 * @return Höhe des Spielfeldes
	 * 
	 * @see Game
	 */
	public int getHeight();
}
