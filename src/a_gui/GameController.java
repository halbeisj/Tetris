package a_gui;

import java.util.Observable;
import java.util.Observer;

import b_bl.Game;
import b_bl.GameActionType;
import b_bl.Stopwatch;

/**
 * Dies ist der Controller der Game Klasse. Über Ihn wird auf die Game Klasse
 * zugegriffen.
 * 
 * @author Julia Halbeisen
 */
public class GameController implements IGameController, Observer {
	/**
	 * Ein Objekt, welches Statistiken über das Spiel beinhaltet
	 */
	private IGameStatistics model;
	/**
	 * Das Game, aus welchem die Daten geladen und an das die Befehle
	 * weitergegeben werden.
	 */
	private Game game;

	/**
	 * Ein Objekt um das Spiel darzustellen.
	 */

	private IGameForm view;

	/**
	 * Die View, welche vor dem Spielstart angezeigt wird.
	 */
	private StartForm start_view;

	/**
	 * View, welche nach Beendigung des Spiels anzeigt.
	 */
	private GameOverForm end_view;

	/**
	 * Initialisiert eine neue Instanz der {@link GameController} Klasse.
	 */
	public GameController() {
		this.start_view = new StartForm(this);
		this.game = new Game();
		this.model = new GameStatistics();
		this.view = new GameForm(this, this.model);
		this.model.addObserver(this.view);
		this.game.addObserver(this);
	}

	/**
	 * Verschiebt Figur in Game nach links.
	 */
	public void left() {
		this.game.left();
	}

	/**
	 * Verschiebt Figur in Game nach rechts.
	 */
	public void right() {
		this.game.right();
	}

	/**
	 * Verschiebt Figur in Game nach unten.
	 */
	public void down() {
		this.game.down();
	}

	/**
	 * Lädt das Feld neu aus dem Game in das Model.
	 */
	private void reloadField() {
		this.model.setNextFigure(this.game.reloadNextFigure());
		this.model.reloadField(this.game.reloadField());
	}

	/**
	 * Startet ein neues Spiel.
	 */
	public void newGame() {
		this.game.newGame();
		this.reloadField();
		this.view.activate();
	}

	/**
	 * Beendet das Spiel.
	 */
	public void endGame() {
		this.end_view = new GameOverForm(this);
	}

	/**
	 * Setzt den Name des Spielers.
	 */
	public void setPlayerName(String name) {
		this.model.setName(name);
	}

	/**
	 * Gibt die Breite des Spielfelds zurück.
	 */
	public int getFieldWidth() {
		return game.getWidth();
	}

	/**
	 * Gibt die Höhe de Spielfelds zurück.
	 */
	public int getFieldHeight() {
		return game.getHeight();
	}

	/**
	 * Aktualisiert das Spiel.
	 * 
	 * @param o
	 * Objekt, welches überwacht wird.
	 * 
	 * @param arg
	 * Zusätzliche Informationen.
	 */
	public void update(Observable o, Object arg) {
		if (arg instanceof GameActionType)
		{
			GameActionType type = (GameActionType)arg;
			
			switch(type)
			{
				case Update:
					this.model.setTime(this.game.getTime());
					break;
					
				case Lost:
					this.view.deactivate();
					this.endGame();
					break;
			}
		}
	}
}