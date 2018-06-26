package a_gui;

import b_bl.Game;

/**Dies ist das Interface des Game Controllers.
 * �ber diese Klasse wird auf den Game_Controller zugegriffen.
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
	 * L�dt das Feld neu
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
	 * Gibt die Breite des Spielfeldes zur�ck, welche im Game konfiguriert ist.
	 * 
	 * @return Breite des Spielfeldes
	 * 
	 * @see Game
	 */
	public int getWidth();
	
	/**
	 * Gibt die H�he des Spielfeldes zur�ck, welche im Game konfigureiert ist.
	 * 
	 * @return H�he des Spielfeldes
	 * 
	 * @see Game
	 */
	public int getHeight();
}
