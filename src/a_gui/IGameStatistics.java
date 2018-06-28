package a_gui;

import java.awt.Point;
import java.util.Observer;

import d_dto.Field;

/**
 * Repr�sentiert Statistiken �ber ein Spiel.
 */
public interface IGameStatistics {
	/**
	 * L�dt das Feld neu.
	 * 
	 * @param field Feld, welches neu eingespeichert werden soll
	 */
	public void reloadField(Field[][] field);
	
	/**
	 * Gibt die Anzahl bestandener Levels zur�ck.
	 * 
	 * @return
	 * Die Anzahl bestandener Levels.
	 * 
	 * @todo Als Zahl zur�ckgeben.
	 */
	public String getLevel();
	
	/**
	 * Gibt die verstrichene Zeit seit Rundenbeginn als String zur�ck
	 * 
	 * @return verstrichene Zeit seit Rundenbeginn als String
	 * 
	 * @todo Als Zahl zur�ckgeben.
	 */
	public String getTime();
	
	/**
	 * Gibt den Spielernamen zur�ck.
	 * 
	 * @return
	 * Der Name des Spielers.
	 */
	public String getName();

	/**
	 * Setzt den Name des Spielers.
	 */
	public void setName(String value);
	
	/**
	 * Gibt die Anzahl beseitigter Linien zur�ck.
	 * 
	 * @return
	 * Die Anzahl der beseitigten Linien.
	 * 
	 * @todo Als Zahl zur�ckgeben.
	 */
	public String getLines();
	
	/**
	 * Gibt einen bestimmten Punkt auf dem Spielfeld zur�ck
	 * 
	 * @param x X-Koordinate des Punktes
	 * @param y Y-Koordinate des Punktes
	 * 
	 * @return Punkt auf dem Spielfeld
	 * 
	 * @todo Methode l�schen.
	 */
	public Field getPoint(int x, int y);
	
	/**
	 * Speichert die n�chste neue Figur ein
	 * 
	 * @param nextFigure Figur, die eingespeichert werden soll
	 * 
	 */
	public void setNextFigure(Field[][] nextFigure);
	
	/**
	 * Gibt einen bestimmten Punkt der n�chsten Figur zur�ck
	 * 
	 * @param x X-Koordinate des Punktes innerhalb der n�chsten Figur (nextFigure)
	 * @param y Y-Koordinate des Punktes innerhalb der n�chsten Figur (nextFigure)
	 * 
	 * @return Punkt der n�chsten Figur
	 * 
	 * @todo Methode l�schen - stattdessen "getNextFigure" hinzuf�gen.
	 */
	public Field getPointNextFigure(int x, int y);
	
	/**
	 * Gibt die Gr�sse der n�chsten Figur als Wertetupel zur�ck
	 * 
	 * @return Gr�sse der n�chsten Figur als Wertetupel
	 * 
	 * @todo Methode l�schen - stattdessen "getNextFigure" hinzuf�gen.
	 */
	public Point getNextFigureSize();
	
	/**
	 * F�gt eine �berwachende Klasse hinzu, welche den Code in ihrer update-Methode ausf�hrt, wenn notifyObservers aufgerufen wird
	 * 
	 * @param o Klasse welche �berwachen soll
	 * 
	 * @see Observer
	 * @see Observable
	 * 
	 * @todo Methode l�schen - geh�rt zu Observable.
	 */
	public void addObserver(Observer o);
	
	/**
	 * Setzt die verstrichene Zeit auf einen neuen Wert
	 * Informiert anschliessend alle �berwachenden Klassen
	 * 
	 * @param time Neue Zeit, die gesetzt werden soll
	 * 
	 * @todo Methode l�schen.
	 */
	public void setTime(int time);
}