package a_gui;

import java.awt.Point;
import java.util.Observable;

import d_dto.Field;

/**
 * Repr�sentiert die Statistiken eines Spiels.
 * 
 * @author Julia Halbeisen
 */
public class GameStatistics extends Observable implements IGameStatistics {
	/**
	 * Spielfeld, welches die verschiedenen Farben speichert
	 */
	private Field[][] field;

	/**
	 * Feld in welchem die n�chste Figur dargestellt wird
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
	 * Methode, die das Feld neu l�dt und anschliessend alle Observer
	 * benachrichtigt
	 * 
	 * @param field
	 *            Feld, welches neu eingespeichert werden soll
	 * 
	 * @todo L�schen.
	 */
	public void reloadField(Field[][] field) {
		this.field = field;

		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Methode, die die Anzahl an beseitigten Linien um den Mitgabewert erh�ht
	 * 
	 * @param inc
	 *            Anzahl der neuen beseitigten Linien
	 * 
	 * @todo l�schen und durch "update" ersetzen.
	 */
	private void incLine(int inc) {
		this.lines = this.lines + inc;
		if (inc != 0 && this.lines % 10 == 0) {
			this.incLevel();
		}
	}

	/**
	 * Methode, die die Anzahl an bestandenen Level um eins erh�ht
	 * 
	 * @todo l�schen und durch "update" ersetzen.
	 */
	private void incLevel() {
		this.level++;
	}

	/**
	 * Gibt die verstrichene Zeit seit Rundenbeginn zur�ck.
	 * 
	 * 
	 * @todo als int
	 * @todo l�schen und durch "Stopwatch" ersetzen.
	 */
	public String getTime() {
		return Integer.toString(this.time);
	}

	/**
	 * Gibt die Anzahl beseitigter Linien als zur�ck.
	 * 
	 * @todo als int
	 */
	public String getLines() {
		return Integer.toString(this.lines);
	}

	/**
	 * Gibt die Anzahl bestandener Levels zur�ck.
	 * 
	 * @todo als int
	 */
	public String getLevel() {
		return Integer.toString(this.level);
	}

	/**
	 * Gibt den Namen des Spielers zur�ck.
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
	 * Gibt einen bestimmten Punkt auf dem Spielfeld zur�ck
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
	 * Speichert die n�chste neue Figur ein
	 * 
	 * @param nextFigure
	 *            Figur, die eingespeichert werden soll
	 * 
	 * @todo l�schen und durch "update" ersetzen.
	 */
	public void reloadNextFigure(Field[][] nextFigure) {
		this.nextFigure = nextFigure;
	}

	/**
	 * Gibt einen bestimmten Punkt der n�chsten Figur zur�ck
	 * 
	 * @param x
	 *            X-Koordinate des Punktes innerhalb der n�chsten Figur
	 *            (nextFigure)
	 * @param y
	 *            Y-Koordinate des Punktes innerhalb der n�chsten Figur
	 *            (nextFigure)
	 * 
	 * @return Punkt der n�chsten Figur
	 * 
	 * @todo l�schen und durch "getNextFigure" ersetzen.
	 */
	public Field getPointNextFigure(int x, int y) {
		return this.nextFigure[y][x];
	}

	/**
	 * Gibt die Gr�sse der n�chsten Figur als Wertetupel zur�ck
	 * 
	 * @return Gr�sse der n�chsten Figur als Wertetupel
	 * 
	 * @todo l�schen und durch "getNextFigure" ersetzen.
	 */
	public Point getNextFigureSize() {
		return new Point(this.nextFigure[0].length, this.nextFigure.length);
	}

	/**
	 * Setzt die verstrichene Zeit auf einen neuen Wert Informiert anschliessend
	 * alle �berwachenden Klassen
	 * 
	 * @param time
	 *            Neue Zeit, die gesetzt werden soll
	 * 
	 * @todo l�schen und durch "Stopwatch" ersetzen.
	 */
	public void setTime(int time) {
		this.time = time;
		this.setChanged();
		this.notifyObservers();
	}

}
