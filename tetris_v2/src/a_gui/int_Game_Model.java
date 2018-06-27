package a_gui;

import java.awt.Point;
import java.util.Observer;

import d_dto.Point_DTO;

/**
 * Repr�sentiert Statistiken �ber ein Spiel.
 */
public interface int_Game_Model {
	/**
	 * L�dt das Feld neu.
	 * 
	 * @param field Feld, welches neu eingespeichert werden soll
	 * @param inc Zahl um welche lines erh�ht werden soll
	 */
	public void reloadField(Point_DTO[][] field, int inc);
	
	/**
	 * Inialisiert ein Spiel.
	 */
	public void init(String name);
	
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
	public Point_DTO getPoint(int x, int y);
	
	/**
	 * Speichert die n�chste neue Figur ein
	 * 
	 * @param nextFigure Figur, die eingespeichert werden soll
	 * 
	 * @todo zu "setNextFigure" umbenennen.
	 */
	public void reloadNextFigure(Point_DTO[][] nextFigure);
	
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
	public Point_DTO getPointNextFigure(int x, int y);
	
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