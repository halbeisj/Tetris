package a_gui;

import java.util.Observer;

/**
 * Dies ist das Interface für die Game View.
 * Über diese Klasse wird auf die Game_View zugegriffen.
 * 
 * @see Game_View
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public interface int_Game_View extends Observer {
	/**
	 * Methode, welche das Fenster sichtbar macht und den Namen konfiguriert
	 * Das Model wird zum ersten Mal neu geladen und der Name wird gesetzt
	 * 
	 * @see int_Game_Model
	 */
	public void activate();
	
	/**
	 * Methode, welche das Fenster unsichtbar macht und zerstört
	 */
	public void deactivate();
}
