package a_gui;

import java.util.Observable;
import java.util.Observer;

import b_bl.Game;
import b_bl.GameActionType;
import b_bl.MoveDirection;
import b_bl.StopwatchThread;

/**
 * Dies ist der Controller der Game Klasse. Über Ihn wird auf die Game Klasse
 * zugegriffen.
 * 
 * @author Julia Halbeisen
 * 
 * TODO Remove {@link #model}
 * TODO Remove {@link #view}
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
	private StartForm startForm;

	/**
	 * View, welche nach Beendigung des Spiels anzeigt.
	 */
	private GameOverForm gameOverForm;

	/**
	 * Initialisiert eine neue Instanz der {@link GameController} Klasse.
	 */
	public GameController() {
		this.startForm = new StartForm(this);
		this.game = new Game();
		this.model = new GameStatistics();
		this.view = new GameForm(this, this.model);
		this.model.addObserver(this.view);
		this.game.addObserver(this);
		this.game.addObserver(this.view);
	}

	/**
	 * Verschiebt Figur in Game nach links.
	 */
	public void left() {
		game.moveFigure(MoveDirection.Left);
	}

	/**
	 * Verschiebt Figur in Game nach rechts.
	 */
	public void right() {
		game.moveFigure(MoveDirection.Right);
	}

	/**
	 * Verschiebt Figur in Game nach unten.
	 */
	public void down() {
		game.moveFigure(MoveDirection.Down);
	}

	/**
	 * Lädt das Feld neu aus dem Game in das Model.
	 * TODO löschen
	 */
	private void reloadField() {
		this.model.setNextFigure(this.game.reloadNextFigure());
		this.model.reloadField(this.game.getField());
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
		this.gameOverForm = new GameOverForm(this);
	}

	/**
	 * Setzt den Name des Spielers.
	 */
	public void setPlayerName(String name) {
		this.model.setPlayerName(name);
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
	}
}