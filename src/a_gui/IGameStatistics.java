package a_gui;

import java.awt.Point;
import java.util.Observer;

import d_dto.Field;

/**
 * Repräsentiert Statistiken über ein Spiel.
 */
public interface IGameStatistics {
	/**
	 * Lädt das Feld neu.
	 * 
	 * @param field Feld, welches neu eingespeichert werden soll
	 */
	public void reloadField(Field[][] field);
	
	/**
	 * Gibt die Anzahl bestandener Levels zurück.
	 * 
	 * @return
	 * Die Anzahl bestandener Levels.
	 * 
	 * @todo Als Zahl zurückgeben.
	 */
	public String getLevel();
	
	/**
	 * Gibt die verstrichene Zeit seit Rundenbeginn als String zurück
	 * 
	 * @return verstrichene Zeit seit Rundenbeginn als String
	 * 
	 * @todo Als Zahl zurückgeben.
	 */
	public String getTime();
	
	/**
	 * Gibt den Spielernamen zurück.
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
	 * Gibt die Anzahl beseitigter Linien zurück.
	 * 
	 * @return
	 * Die Anzahl der beseitigten Linien.
	 * 
	 * @todo Als Zahl zurückgeben.
	 */
	public String getLines();
	
	/**
	 * Gibt einen bestimmten Punkt auf dem Spielfeld zurück
	 * 
	 * @param x X-Koordinate des Punktes
	 * @param y Y-Koordinate des Punktes
	 * 
	 * @return Punkt auf dem Spielfeld
	 * 
	 * @todo Methode löschen.
	 */
	public Field getPoint(int x, int y);
	
	/**
	 * Speichert die nächste neue Figur ein
	 * 
	 * @param nextFigure Figur, die eingespeichert werden soll
	 * 
	 */
	public void setNextFigure(Field[][] nextFigure);
	
	/**
	 * Gibt einen bestimmten Punkt der nächsten Figur zurück
	 * 
	 * @param x X-Koordinate des Punktes innerhalb der nächsten Figur (nextFigure)
	 * @param y Y-Koordinate des Punktes innerhalb der nächsten Figur (nextFigure)
	 * 
	 * @return Punkt der nächsten Figur
	 * 
	 * @todo Methode löschen - stattdessen "getNextFigure" hinzufügen.
	 */
	public Field getPointNextFigure(int x, int y);
	
	/**
	 * Gibt die Grösse der nächsten Figur als Wertetupel zurück
	 * 
	 * @return Grösse der nächsten Figur als Wertetupel
	 * 
	 * @todo Methode löschen - stattdessen "getNextFigure" hinzufügen.
	 */
	public Point getNextFigureSize();
	
	/**
	 * Fügt eine überwachende Klasse hinzu, welche den Code in ihrer update-Methode ausführt, wenn notifyObservers aufgerufen wird
	 * 
	 * @param o Klasse welche überwachen soll
	 * 
	 * @see Observer
	 * @see Observable
	 * 
	 * @todo Methode löschen - gehört zu Observable.
	 */
	public void addObserver(Observer o);
	
	/**
	 * Setzt die verstrichene Zeit auf einen neuen Wert
	 * Informiert anschliessend alle überwachenden Klassen
	 * 
	 * @param time Neue Zeit, die gesetzt werden soll
	 * 
	 * @todo Methode löschen.
	 */
	public void setTime(int time);
}