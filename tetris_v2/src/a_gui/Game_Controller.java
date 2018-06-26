package a_gui;

import java.util.Observable;
import java.util.Observer;

import b_bl.Game;
import b_bl.TimeThread;
/**
 * Dies ist der Controller der Game Klasse.
 * Über Ihn wird auf die Game Klasse zugegriffen.
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public class Game_Controller implements int_Game_Controller, Observer {
	/**
	 * Model in welches die Daten geladen werden sollen
	 */
	private int_Game_Model model;
	/**
	 * Game an welches die Befehle weitergegeben werden sollen
	 * Game aus welchem die Daten geladen werden sollen
	 */
	private Game game;
	/**
	 * View (stellt das Game dar), welche gemanaged werden soll
	 */
	private int_Game_View view;
	/**
	 * View (stellt den Einstieg in das Game dar), welche gemanaged werden soll
	 */
	private Start_View start_view;
	/**
	 * View (stellt das Ende des Games dar), welche gemanaged werden soll
	 */
	private End_View end_view;
	/**
	 * Anzahl Lines, welche im Model erhöht werden sollen
	 */
	private int inc;
	
	/**
	 * Variablen werden gesetzt
	 * Weitere Objekte in der GUI-Schicht werden erstellt
	 * Observers werden konfiguriert (view überwacht model) (controller überwacht game)
	 * 
	 * @see int_Game_View
	 * @see int_Game_Model
	 */
	public Game_Controller() {
		this.start_view = new Start_View(this);
		this.game = new Game();
		this.model = new Game_Model();
		this.view = new Game_View(this, this.model);
		this.model.addObserver(this.view);
		this.game.addObserver(this);
	}
	
	/**
	 * Verschiebt Figur in Game nach links
	 * 
	 * @see Game
	 */
	public void left(){
		this.game.left();
		this.reloadField();
	}
	
	/**
	 * Verschiebt Figur in Game nach rechts
	 * 
	 * @see Game
	 */
	public void right(){
		this.game.right();
		this.reloadField();
	}
	
	/**
	 * Verschiebt Figur in Game nach unten
	 * 
	 * @see Game
	 */
	public void down(){
		this.inc = this.game.down();
		this.reloadField();
	}
	
	/**
	 * Lädt das Feld neu aus dem Game in das Model
	 * 
	 * @see Game
	 * @see int_Game_Model
	 */
	private void reloadField(){
		this.model.reloadNextFigure(this.game.reloadNextFigure());
		this.model.reloadField(this.game.reloadField(), this.inc);
		this.inc = 0;
	}
	
	/**
	 * Startet ein neues Spiel in der Klasse Game
	 * Lädt das Feld neu
	 * Aktiviert das Fenster Game_View
	 * 
	 * @see Game
	 * @see int_Game_View
	 */
	public void newGame(){
		this.game.newGame();
		this.reloadField();
		this.view.activate();
	}
	
	/**
	 * Startet die End_View mit diesem Controller als Mitgabeparameter
	 */
	public void endGame(){
		this.end_view = new End_View(this);
	}
	
	/**
	 * Setzt den Namen im Game_Model.
	 * 
	 * @param name Name der gesetzt werden soll
	 * 
	 * @see int_Game_Model
	 */
	public void setName(String name) {
		this.model.init(name);
	}
	
	/**
	 * Gibt die Breite des Spielfeldes zurück, welche im Game konfiguriert ist.
	 * 
	 * @return Breite des Spielfeldes
	 * 
	 * @see Game
	 */
	public int getWidth() {
		return game.getWidth();
	}
	
	/**
	 * Gibt die Höhe des Spielfeldes zurück, welche im Game konfigureiert ist.
	 * 
	 * @return Höhe des Spielfeldes
	 * 
	 * @see Game
	 */
	public int getHeight() {
		return game.getHeight();
	}

	/**
	 * Wenn mit 1 aufgerufen wird -> endGame() wird aufgerufen
	 * Wenn mit 2 aufgerufen wird -> Zeit wird von Game in Game_Model geladen
	 * 
	 * @param o Objekt, welches überwacht wird
	 * @param arg Zahl, welche mitgegeben wird
	 * 
	 * @see Game
	 * @see End_View
	 * @see int_Game_Model
	 */
	public void update(Observable o, Object arg) {
		if((int) arg == 1) {
			this.view.deactivate();
			this.endGame();
		}
		else if((int) arg == 2) {
			this.model.setTime(this.game.getTime());
		}
	}
}