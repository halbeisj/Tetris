package c_db;

import java.awt.Point;

import d_dto.Point_DTO;

/**
 * Repräsentiert eine Figur.
 * 
 * @author Julia Halbeisen
 */
public class Figure {
	/**
	 * Das Feld, welches die Figur darstellt.
	 */
	protected Point_DTO[][] figure;
	
	/**
	 * Linksester Punkt in Abhängigkeit vom ursprünglichen Punkt
	 * 
	 * @todo Löschen.
	 */
	protected int pointr;
	
	/**
	 * Unterster Punkt in Abhängigkeit vom ursprünglichen Punkt
	 * 
	 * @todo Löschen.
	 */
	protected int pointd;
	
	/**
	 * Der Punkt, welcher die Figur auf dem Spielfeld einnimmt.
	 * 
	 * @todo Zu "position" umbenennen.
	 */
	protected Point source;
	
	/**
	 * Gibt das Feld, welches die Figur darstellt, zurück.
	 * 
	 * @return
	 * Das Feld, welches die Figur darstellt.
	 */
	public Point_DTO[][] getField() {
		return figure;
	}

	/**
	 * Gibt die Breite der Figur zurück.
	 * 
	 * @return
	 * Die Breite der Figur.
	 * 
	 * @todo Umbenennen zu "getWidth".
	 */
	public int getPointR() {
		return this.pointr;
	}
	
	/**
	 * Gibt die Höhe der Figur zurück.
	 * 
	 * @return
	 * Die Höhe der Figur.
	 * 
	 * @todo Umbenennen zu "getHeight".
	 */
	public int getPointD() {
		return this.pointd;
	}
	
	/**
	 * Gibt die Position der Figur auf dem Spielfeld zurück.
	 */
	public Point getSource() {
		return this.source;
	}

	/**
	 * Setzt die Position der Figur auf dem Spielfeld.
	 */
	public void setSource(Point value) {
		this.source = value;
	}
	

}
