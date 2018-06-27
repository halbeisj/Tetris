package a_gui;

import java.util.Observer;

/**
 * Dies ist das Interface für die Game View.
 * Über diese Klasse wird auf die Game_View zugegriffen.
 * 
 * @author Julia Halbeisen
 * */
public interface int_Game_View extends Observer {
	/**
	 * Initialisiert die Spielanzeige.
	 */
	public void activate();
	
	/**
	 * Löscht die Spielanzeige.
	 */
	public void deactivate();
}
