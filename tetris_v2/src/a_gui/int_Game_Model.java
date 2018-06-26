package a_gui;

import java.awt.Point;
import java.util.Observer;

import d_dto.Point_DTO;

/**Dies ist das Interface des Game Models.
 * �ber diese Klasse wird auf das Game_Model zugegriffen.
 * 
 * @see Game_Model
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public interface int_Game_Model {
	/**
	 * Methode, die das Feld neu l�dt und anschliessend alle Observer benachrichtigt
	 * 
	 * @param field Feld, welches neu eingespeichert werden soll
	 * @param inc Zahl um welche lines erh�ht werden soll
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
	 * Gibt die Anzahl bestandene Levels als String zur�ck
	 * 
	 * @return Anzahl bestandene Levels als String
	 */
	public String getLevel();
	
	/**
	 * Gibt die verstrichene Zeit seit Rundenbeginn als String zur�ck
	 * 
	 * @return verstrichene Zeit seit Rundenbeginn als String
	 */
	public String getTime();
	
	/**
	 * Gibt den konfigiurierten Namen zur�ck
	 * 
	 * @return konfigurierter Name
	 */
	public String getName();
	
	/**
	 * Gibt die Anzahl beseitigte Linien als String zur�ck
	 * 
	 * @return Anzahl beseitigte Linien als String
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
	 * @see Point_DTO
	 */
	public Point_DTO getPoint(int x, int y);
	
	/**
	 * Speichert die n�chste neue Figur ein
	 * 
	 * @param nextFigure Figur, die eingespeichert werden soll
	 * 
	 * @see Point_DTO
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
	 * @see Point_DTO
	 */
	public Point_DTO getPointNextFigure(int x, int y);
	
	/**
	 * Gibt die Gr�sse der n�chsten Figur als Wertetupel zur�ck
	 * 
	 * @return Gr�sse der n�chsten Figur als Wertetupel
	 */
	public Point getNextFigureSize();
	
	/**
	 * F�gt eine �berwachende Klasse hinzu, welche den Code in ihrer update-Methode ausf�hrt, wenn notifyObservers aufgerufen wird
	 * 
	 * @param o Klasse welche �berwachen soll
	 * 
	 * @see Observer
	 * @see Observable
	 */
	public void addObserver(Observer o);
	
	/**
	 * Setzt die verstrichene Zeit auf einen neuen Wert
	 * Informiert anschliessend alle �berwachenden Klassen
	 * 
	 * @param time Neue Zeit, die gesetzt werden soll
	 */
	public void setTime(int time);
}