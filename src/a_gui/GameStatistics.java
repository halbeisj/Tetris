package a_gui;

import java.awt.Point;
import java.util.Observable;

import d_dto.Field;

/**
 * Repräsentiert die Statistiken eines Spiels.
 * 
 * @author Julia Halbeisen
 */
public class GameStatistics extends Observable implements IGameStatistics {
	/**
	 * Spielfeld, welches die verschiedenen Farben speichert
	 */
	private Field[][] field;

	/**
	 * Feld in welchem die nächste Figur dargestellt wird
	 */
	private Field[][] nextFigure;

	/**
	 * Zeit, die seit Beginn der Runde verstrichen ist
	 */
	private int time;

	/**
	 * Anzahl Linien, die schon entfernt wurden
	 */
	private int lines;

	/**
	 * Anzahl Levels, die schon bestanden wurden
	 */
	private int level;

	/**
	 * Name des Spielers
	 */
	private String name;

	/**
	 * Initialisiert eine neue Instanz der {@link GameStatistics} Klasse.
	 */
	public GameStatistics() {
		this.name = "";
		this.lines = 0;
		this.level = 0;
	}

	/**
	 * Setzt den Name des Spielers.
	 */
	public void setPlayerName(String value) {
		this.name = value;
	}

	/**
	 * Methode, die das Feld neu lädt und anschliessend alle Observer
	 * benachrichtigt
	 * 
	 * @param field
	 *            Feld, welches neu eingespeichert werden soll
	 * 
	 * @todo Löschen.
	 */
	public void reloadField(Field[][] field) {
		this.field = field;

		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Methode, die die Anzahl an beseitigten Linien um den Mitgabewert erhöht
	 * 
	 * @param inc
	 *            Anzahl der neuen beseitigten Linien
	 * 
	 * @todo löschen und durch "update" ersetzen.
	 */
	private void incLine(int inc) {
		this.lines = this.lines + inc;
		if (inc != 0 && this.lines % 10 == 0) {
			this.incLevel();
		}
	}

	/**
	 * Methode, die die Anzahl an bestandenen Level um eins erhöht
	 * 
	 * @todo löschen und durch "update" ersetzen.
	 */
	private void incLevel() {
		this.level++;
	}

	/**
	 * Gibt die verstrichene Zeit seit Rundenbeginn zurück.
	 * 
	 * 
	 * @todo als int
	 * @todo löschen und durch "Stopwatch" ersetzen.
	 */
	public String getTime() {
		return Integer.toString(this.time);
	}

	/**
	 * Gibt die Anzahl beseitigter Linien als zurück.
	 * 
	 * @todo als int
	 */
	public String getLines() {
		return Integer.toString(this.lines);
	}

	/**
	 * Gibt die Anzahl bestandener Levels zurück.
	 * 
	 * @todo als int
	 */
	public String getLevel() {
		return Integer.toString(this.level);
	}

	/**
	 * Gibt den Namen des Spielers zurück.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setzt den Name des Spielers.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gibt einen bestimmten Punkt auf dem Spielfeld zurück
	 * 
	 * @param x
	 *            X-Koordinate des Punktes
	 * @param y
	 *            Y-Koordinate des Punktes
	 * 
	 * @return Punkt auf dem Spielfeld
	 * 
	 * @todo Durch GetField ersetzen.
	 */
	public Field getPoint(int x, int y) {
		return this.field[y][x];
	}

	/**
	 * Speichert die nächste neue Figur ein
	 * 
	 * @param nextFigure
	 *            Figur, die eingespeichert werden soll
	 * 
	 * @todo löschen und durch "update" ersetzen.
	 */
	public void reloadNextFigure(Field[][] nextFigure) {
		this.nextFigure = nextFigure;
	}

	/**
	 * Gibt einen bestimmten Punkt der nächsten Figur zurück
	 * 
	 * @param x
	 *            X-Koordinate des Punktes innerhalb der nächsten Figur
	 *            (nextFigure)
	 * @param y
	 *            Y-Koordinate des Punktes innerhalb der nächsten Figur
	 *            (nextFigure)
	 * 
	 * @return Punkt der nächsten Figur
	 * 
	 * @todo löschen und durch "getNextFigure" ersetzen.
	 */
	public Field getPointNextFigure(int x, int y) {
		return this.nextFigure[y][x];
	}

	/**
	 * Gibt die Grösse der nächsten Figur als Wertetupel zurück
	 * 
	 * @return Grösse der nächsten Figur als Wertetupel
	 * 
	 * @todo löschen und durch "getNextFigure" ersetzen.
	 */
	public Point getNextFigureSize() {
		return new Point(this.nextFigure[0].length, this.nextFigure.length);
	}

	/**
	 * Setzt die verstrichene Zeit auf einen neuen Wert Informiert anschliessend
	 * alle überwachenden Klassen
	 * 
	 * @param time
	 *            Neue Zeit, die gesetzt werden soll
	 * 
	 * @todo löschen und durch "Stopwatch" ersetzen.
	 */
	public void setTime(int time) {
		this.time = time;
		this.setChanged();
		this.notifyObservers();
	}

}
