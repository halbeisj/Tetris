package a_gui;

import java.awt.Point;
import java.util.Observer;

import d_dto.Point_DTO;

/**
 * Repräsentiert Statistiken über ein Spiel.
 */
public interface int_Game_Model {
	/**
	 * Lädt das Feld neu.
	 * 
	 * @param field Feld, welches neu eingespeichert werden soll
	 * @param inc Zahl um welche lines erhöht werden soll
	 */
	public void reloadField(Point_DTO[][] field, int inc);
	
	/**
	 * Inialisiert ein Spiel.
	 */
	public void init(String name);
	
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
	public Point_DTO getPoint(int x, int y);
	
	/**
	 * Speichert die nächste neue Figur ein
	 * 
	 * @param nextFigure Figur, die eingespeichert werden soll
	 * 
	 * @todo zu "setNextFigure" umbenennen.
	 */
	public void reloadNextFigure(Point_DTO[][] nextFigure);
	
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
	public Point_DTO getPointNextFigure(int x, int y);
	
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