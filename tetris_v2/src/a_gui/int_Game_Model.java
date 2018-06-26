package a_gui;

import java.awt.Point;
import java.util.Observer;

import d_dto.Point_DTO;

/**Dies ist das Interface des Game Models.
 * Über diese Klasse wird auf das Game_Model zugegriffen.
 * 
 * @see Game_Model
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public interface int_Game_Model {
	/**
	 * Methode, die das Feld neu lädt und anschliessend alle Observer benachrichtigt
	 * 
	 * @param field Feld, welches neu eingespeichert werden soll
	 * @param inc Zahl um welche lines erhöht werden soll
	 * 
	 * @see Point_DTO
	 */
	public void reloadField(Point_DTO[][] field, int inc);
	
	/**
	 * Methode, welche alle Variablen setzt (zum Beispiel bei Neustart des Spiels)
	 * 
	 * @param name Name des Spielers
	 */
	public void init(String name);
	
	/**
	 * Gibt die Anzahl bestandene Levels als String zurück
	 * 
	 * @return Anzahl bestandene Levels als String
	 */
	public String getLevel();
	
	/**
	 * Gibt die verstrichene Zeit seit Rundenbeginn als String zurück
	 * 
	 * @return verstrichene Zeit seit Rundenbeginn als String
	 */
	public String getTime();
	
	/**
	 * Gibt den konfigiurierten Namen zurück
	 * 
	 * @return konfigurierter Name
	 */
	public String getName();
	
	/**
	 * Gibt die Anzahl beseitigte Linien als String zurück
	 * 
	 * @return Anzahl beseitigte Linien als String
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
	 * @see Point_DTO
	 */
	public Point_DTO getPoint(int x, int y);
	
	/**
	 * Speichert die nächste neue Figur ein
	 * 
	 * @param nextFigure Figur, die eingespeichert werden soll
	 * 
	 * @see Point_DTO
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
	 * @see Point_DTO
	 */
	public Point_DTO getPointNextFigure(int x, int y);
	
	/**
	 * Gibt die Grösse der nächsten Figur als Wertetupel zurück
	 * 
	 * @return Grösse der nächsten Figur als Wertetupel
	 */
	public Point getNextFigureSize();
	
	/**
	 * Fügt eine überwachende Klasse hinzu, welche den Code in ihrer update-Methode ausführt, wenn notifyObservers aufgerufen wird
	 * 
	 * @param o Klasse welche überwachen soll
	 * 
	 * @see Observer
	 * @see Observable
	 */
	public void addObserver(Observer o);
	
	/**
	 * Setzt die verstrichene Zeit auf einen neuen Wert
	 * Informiert anschliessend alle überwachenden Klassen
	 * 
	 * @param time Neue Zeit, die gesetzt werden soll
	 */
	public void setTime(int time);
}