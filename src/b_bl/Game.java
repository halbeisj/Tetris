package b_bl;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import java.util.Observable;
import java.util.Random;

import a_gui.GameStatistics;
import c_db.Figure;
import c_db.ZFigure;
import c_db.IFigure;
import c_db.JFigure;
import c_db.LFigure;
import c_db.CubeFigure;
import c_db.SFigure;
import c_db.TFigure;
import d_dto.Field;
import d_dto.FieldState;

/**
 * Repräsentiert ein Tetris-Spiel.
 * 
 * @author Julia Halbeisen TODO down, right, left in eine Methode TODO neuer
 *         Konstruktor mit höhe und breite des Felds
 */
public class Game extends Observable {

	/**
	 * Die Auflistung aller Felder.
	 * 
	 * @todo Variable umbenennen.
	 */
	private Field[][] field;

	/**
	 * Die Aktuelle Figur.
	 */
	private Figure figure;

	/**
	 * Die nächste Figur.
	 */
	private Figure nextFigure;

	/**
	 * Die höhe des Spielfeldes.
	 * 
	 * @todo Löschen.
	 */
	private int field_height = 11;

	/**
	 * Breite des Spielfeldes
	 * 
	 * @todo Löschen.
	 */
	private int field_width = 11;

	/**
	 * Verstrichene Zeit seit Beginn der Runde
	 * 
	 * @todo Löschen und zu {@link GameStatistics} verschieben.
	 */
	private int timeInt = 0;

	/**
	 * Thread, der all Sekunde die Anzahl verstrichenen Sekunden seit Beginn der
	 * Runde erhöht
	 * 
	 * @todo Löschen und zu {@link GameStatistics} verschieben.
	 */
	private Thread timeThread;

	/**
	 * Initialisiert eine neue Instanz der {@link Game} Klasse.
	 */
	public Game() {
		this.timeThread = new Thread(new StopwatchThread(this));
		this.field = new Field[this.field_height][this.field_width];
		this.endGame();
	}

	/**
	 * Bewegt die Figur in die gewünschte Richtung.
	 * 
	 * @param moveDirection
	 *            Die Richtung, in die die Figur sich bewegen soll.
	 */
	public void moveFigure(MoveDirection moveDirection) {
		Point newPosition = new Point(getFigure().getPosition());

		switch (moveDirection) {
			case None:
				break;
			case Left:
				newPosition.translate(-1, 0);
				break;
	
			case Right:
				newPosition.translate(1, 0);
				break;
	
			case Down:
				newPosition.translate(0, 1);
				break;
		}
		
		if ((moveDirection == MoveDirection.Down && newPosition.y + getFigure().getHeight() > getHeight())){
			this.putFigure();
		}
		else if (
				newPosition.y + getFigure().getHeight() > getHeight() ||
				newPosition.x + getFigure().getWidth() > getWidth() ||
				newPosition.x < 0) {
		}
		else {
			for (int y = 0; y < this.getFigure().getHeight(); y++) {
				for (int x = 0; x < this.getFigure().getWidth(); x++) {
					if (this.getFigure().getField()[y][x] != null
							&& this.getField()[newPosition.y + y][newPosition.x + x].getState() == FieldState.Taken) {
						if (moveDirection == MoveDirection.Down) {
							this.putFigure();
						}
						
						return;
					}
				}
			}
		
			for (int y = 0; y < this.getFigure().getHeight(); y++) {
				for (int x = 0; x < this.getFigure().getWidth(); x++) {
					if (this.getFigure().getField()[y][x] != null) {
						Field field = this.getField()[this.getFigure().getPosition().y + y][this.getFigure().getPosition().x + x];
						field.setColor(Color.darkGray);
						field.setState(FieldState.Free);
					}
				}
			}
			
			getFigure().setPosition(newPosition);
			
			for (int y = 0; y < this.getFigure().getHeight(); y++) {
				for (int x = 0; x < this.getFigure().getWidth(); x++) {
					if (this.getFigure().getField()[y][x] != null) {
						Field field = this.getField()[this.getFigure().getPosition().y + y][this.getFigure().getPosition().x + x];
						field.setColor(getFigure().getField()[y][x].getColor());
						field.setState(getFigure().getField()[y][x].getState());
					}
				}
			}
			
			this.setChanged();
			this.notifyObservers(GameActionType.MoveFigure);
		}
	}

	/**
	 * Erstellt eine neue Figur in der Warteschlange.
	 */
	private void createNewFigure() {
		if (this.nextFigure == null) {
			this.nextFigure = this.createRandomFigure();
			this.nextFigure.setPosition(new Point((int)(this.field_width / 2 + 0.5), 0));
		}
		this.figure = this.nextFigure;
		for (int x = 0; x < this.figure.getWidth(); x++) {
			for (int y = 0; y < this.figure.getHeight(); y++) {
				if (this.field[this.figure.getPosition().y + y][this.figure.getPosition().x + x].getState() == FieldState.Taken
						&& this.figure.getField()[y][x] != null) {
					this.setChanged();
					this.notifyObservers(GameActionType.Lost);
					return;
				}
			}
		}
		
		this.nextFigure = this.createRandomFigure();
		this.nextFigure.setPosition(new Point((int) (this.field_width / 2 + 0.5), 0));
		this.moveFigure(MoveDirection.None);
	}

	/**
	 * Gibt eine zufällige Figur zurück.
	 * 
	 * @return Eine zufällig generierte Figur.
	 * 
	 *         TODO in createNewFigure Methode
	 */
	private Figure createRandomFigure() {
		Random r = new Random();
		int figure_number = r.nextInt(7);

		switch (figure_number) {
		case 0:
			return new IFigure();
		case 1:
			return new JFigure();
		case 2:
			return new LFigure();
		case 3:
			return new CubeFigure();
		case 4:
			return new SFigure();
		case 5:
			return new TFigure();
		case 6:
			return new ZFigure();
		default:
			return new IFigure();
		}
	}

	/**
	 * Startet das Spiel neu.
	 */
	public void newGame() {
		this.endGame();
		if (!this.timeThread.isAlive()) {
			this.timeThread.start();
		}
		this.createNewFigure();
		this.timeInt = 0;
	}

	/**
	 * Beendet das Spiel.
	 */
	public void endGame() {
		for (int i = 0; i < this.field_width; i++) {
			for (int y = 0; y < this.field_height; y++) {
				this.field[y][i] = new Field(Color.darkGray, FieldState.Free);
			}
		}
		this.figure = null;
		this.nextFigure = null;
	}

	/**
	 * Aktuelle Figur wird dem Spielfeld hinzugefügt Felder an Position werden
	 * als besetzt markiert
	 * 
	 * @return Anzahl Linien, die beim Hinzufügen entfernt wurden
	 * 
	 * @todo - Das Überprüfen der Reihen in {@link #down()} durchführen.
	 */
	private int putFigure() {
		for (int y = 0; y < this.figure.getHeight(); y++) {
			for (int x = 0; x < this.figure.getWidth(); x++) {
				if (this.figure.getField()[y][x] != null) {
					this.field[this.figure.getPosition().y + y][this.figure.getPosition().x + x].setState(FieldState.Taken);
				}
			}
		}
		int temp = this.checkFullRow();
		this.createNewFigure();
		return temp;
	}

	/**
	 * Gibt das Feld zurück.
	 * 
	 * @return Das Feld.
	 * 
	 */
	public Field[][] getField() {
		return this.field;
	}

	/**
	 * Gibt die nächste Figur zurück.
	 * 
	 * @return Die nächste Figur.
	 * 
	 *         TODO löschen
	 */
	public Field[][] reloadNextFigure() {
		return this.nextFigure.getField();
	}

	/**
	 * Gibt die Breite des Spielfeldes zurück.
	 * 
	 * @return Die Breite des Spielfeldes.
	 */
	public int getWidth() {
		return this.field_width;
	}

	/**
	 * Gibt die Höhe des Spielfelds zurück.
	 * 
	 * @return Die Höhe des Spielfelds.
	 */
	public int getHeight() {
		return this.field_height;
	}

	/**
	 * Gibt die Figur zurück.
	 */
	public Figure getFigure() {
		return figure;
	}
	
	/**
	 * Gibt die nächste Figur zurück.
	 */
	public Figure getNextFigure() {
		return nextFigure;
	}

	/**
	 * Überprüft, ob eine Reihe vollständig ist.
	 * 
	 * TODO in down Methode
	 */
	private int checkFullRow() {
		boolean full;
		int rows = 0;
		for (int y = 0; y < this.field_height; y++) {
			full = true;
			for (int x = 0; x < this.field_width; x++) {
				if (this.field[y][x].getState() == FieldState.Free) {
					full = false;
					break;
				}
			}
			if (full) {
				rows++;
				for (int x = 0; x < getWidth(); x++) {
					for (int y2 = y; y2 > 0; y2--) {
						this.field[y2][x].setState(this.field[y2 - 1][x].getState());
						this.field[y2][x].setColor(this.field[y2 - 1][x].getColor());
					}
				}
			}
		}
		return rows;
	}

	/**
	 * Zeit wird erhöht Observers werden benachrichtigt
	 * 
	 * @todo Methode löschen.
	 */
	public void incTime() {
		this.timeInt++;
		this.setChanged();
		this.notifyObservers(GameActionType.Update);
	}

	/**
	 * Zeit, die seit Beginn der Runde verstrichen ist, wird zurückgegeben
	 * 
	 * @return Zeit
	 * 
	 * @todo Methode löschen.
	 */
	public int getTime() {
		return this.timeInt;
	}
}