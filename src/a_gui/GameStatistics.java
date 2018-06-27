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
	 * Methode, die das Feld neu lädt und anschliessend alle Observer benachrichtigt
	 * 
	 * @param field Feld, welches neu eingespeichert werden soll
	 * @param inc Zahl um welche lines erhöht werden soll
	 * 
	 * @see Field
	 */
	public void reloadField(Field[][] field, int inc){
		this.field = field;
		
		this.incLine(inc);
		
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Methode, die die Anzahl an beseitigten Linien um den Mitgabewert erhöht
	 * 
	 * @param inc Anzahl der neuen beseitigten Linien
	 */
	private void incLine(int inc){
		this.lines = this.lines + inc;
		if(inc != 0 && this.lines % 10 == 0) {
			this.incLevel();
		}
	}
	
	/**
	 * Methode, die die Anzahl an bestandenen Level um eins erhöht
	 */
	private void incLevel(){
		this.level++;
	}
	
	/**
	 * Methode, welche alle Variablen setzt (zum Beispiel bei Neustart des Spiels)
	 * 
	 * @param name Name des Spielers
	 */
	public void init(String name){
		this.name = name;
		this.lines = 0;
		this.level = 0;
	}
	
	/**
	 * Gibt die verstrichene Zeit seit Rundenbeginn als String zurück
	 * 
	 * @return verstrichene Zeit seit Rundenbeginn als String
	 */
	public String getTime() {
		return Integer.toString(this.time);
	}
	
	/**
	 * Gibt die Anzahl beseitigte Linien als String zurück
	 * 
	 * @return Anzahl beseitigte Linien als String
	 */
	public String getLines() {
		return Integer.toString(this.lines);
	}
	
	/**
	 * Gibt die Anzahl bestandene Levels als String zurück
	 * 
	 * @return Anzahl bestandene Levels als String
	 */
	public String getLevel() {
		return Integer.toString(this.level);
	}
	
	/**
	 * Gibt den konfigiurierten Namen zurück
	 * 
	 * @return konfigurierter Name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gibt einen bestimmten Punkt auf dem Spielfeld zurück
	 * 
	 * @param x X-Koordinate des Punktes
	 * @param y Y-Koordinate des Punktes
	 * 
	 * @return Punkt auf dem Spielfeld
	 * 
	 * @see Field
	 */
	public Field getPoint (int x, int y) {
		return this.field[y][x];
	}

	/**
	 * Speichert die nächste neue Figur ein
	 * 
	 * @param nextFigure Figur, die eingespeichert werden soll
	 * 
	 * @see Field
	 */
	public void reloadNextFigure(Field[][] nextFigure) {
		this.nextFigure = nextFigure;
	}
	
	/**
	 * Gibt einen bestimmten Punkt der nächsten Figur zurück
	 * 
	 * @param x X-Koordinate des Punktes innerhalb der nächsten Figur (nextFigure)
	 * @param y Y-Koordinate des Punktes innerhalb der nächsten Figur (nextFigure)
	 * 
	 * @return Punkt der nächsten Figur
	 * 
	 * @see Field
	 */
	public Field getPointNextFigure (int x, int y) {
		return this.nextFigure[y][x];
	}
	
	/**
	 * Gibt die Grösse der nächsten Figur als Wertetupel zurück
	 * 
	 * @return Grösse der nächsten Figur als Wertetupel
	 */
	public Point getNextFigureSize() {
		return new Point(this.nextFigure[0].length, this.nextFigure.length);
	}
	
	/**
	 * Setzt die verstrichene Zeit auf einen neuen Wert
	 * Informiert anschliessend alle überwachenden Klassen
	 * 
	 * @param time Neue Zeit, die gesetzt werden soll
	 */
	public void setTime(int time) {
		this.time = time;
		this.setChanged();
		this.notifyObservers();
	}
	

}
