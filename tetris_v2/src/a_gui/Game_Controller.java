package a_gui;

import java.util.Observable;
import java.util.Observer;

import b_bl.Game;
import b_bl.TimeThread;
/**
 * Dies ist der Controller der Game Klasse.
 * �ber Ihn wird auf die Game Klasse zugegriffen.
 * 
 * @author Julia Halbeisen
 */
public class Game_Controller implements int_Game_Controller, Observer {
	/**
	 * Ein Objekt, welches Statistiken �ber das Spiel beinhaltet
	 */
	private int_Game_Model model;
	/**
	 * Das Game, aus welchem die Daten geladen und an das die Befehle weitergegeben werden.
	 */
	private Game game;
	
	/**
	 * Ein Objekt um das Spiel darzustellen.
	 */
	
	private int_Game_View view;
	
	/**
	 * Die View, welche vor dem Spielstart angezeigt wird. 
	 */
	private Start_View start_view;
	
	/**
	 * View, welche nach Beendigung des Spiels anzeigt.
	 */
	private End_View end_view;
	
	/**
	 * @todo Feld l�schen.
	 */
	private int inc;
	
	/**
	 * Initialisiert eine neue Instanz der {@link Game_Controller} Klasse.
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
	 * Verschiebt Figur in Game nach links.
	 */
	public void left(){
		this.game.left();
		this.reloadField();
	}
	
	/**
	 * Verschiebt Figur in Game nach rechts.
	 */
	public void right(){
		this.game.right();
		this.reloadField();
	}
	
	/**
	 * Verschiebt Figur in Game nach unten.
	 */
	public void down(){
		this.inc = this.game.down();
		this.reloadField();
	}
	
	/**
	 * L�dt das Feld neu aus dem Game in das Model.
	 */
	private void reloadField(){
		this.model.reloadNextFigure(this.game.reloadNextFigure());
		this.model.reloadField(this.game.reloadField(), this.inc);
		this.inc = 0;
	}
	
	/**
	 * Startet ein neues Spiel.
	 */
	public void newGame(){
		this.game.newGame();
		this.reloadField();
		this.view.activate();
	}
	
	/**
	 * Beendet das Spiel.
	 */
	public void endGame(){
		this.end_view = new End_View(this);
	}


	/**
	 * @todo Methode l�schen.
	 */
	public void setName(String name) {
		this.model.init(name);
	}
	
	/**
	 * @todo Methode l�schen.
	 */
	public int getWidth() {
		return game.getWidth();
	}
	
	/**
	 * @todo Methode l�schen.
	 */
	public int getHeight() {
		return game.getHeight();
	}

	/**
	 * Wenn mit 1 aufgerufen wird -> endGame() wird aufgerufen
	 * Wenn mit 2 aufgerufen wird -> Zeit wird von Game in Game_Model geladen
	 * 
	 * @param o Objekt, welches �berwacht wird
	 * @param arg Zahl, welche mitgegeben wird
	 * 
     * @todo Argument als Enum handeln.
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