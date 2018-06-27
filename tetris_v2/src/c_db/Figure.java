package c_db;

import java.awt.Point;

import d_dto.Point_DTO;

/**
 * Repr�sentiert eine Figur.
 * 
 * @author Julia Halbeisen
 */
public class Figure {
	/**
	 * Das Feld, welches die Figur darstellt.
	 */
	protected Point_DTO[][] figure;
	
	/**
	 * Linksester Punkt in Abh�ngigkeit vom urspr�nglichen Punkt
	 * 
	 * @todo L�schen.
	 */
	protected int pointr;
	
	/**
	 * Unterster Punkt in Abh�ngigkeit vom urspr�nglichen Punkt
	 * 
	 * @todo L�schen.
	 */
	protected int pointd;
	
	/**
	 * Der Punkt, welcher die Figur auf dem Spielfeld einnimmt.
	 * 
	 * @todo Zu "position" umbenennen.
	 */
	protected Point source;
	
	/**
	 * Gibt das Feld, welches die Figur darstellt, zur�ck.
	 * 
	 * @return
	 * Das Feld, welches die Figur darstellt.
	 */
	public Point_DTO[][] getField() {
		return figure;
	}

	/**
	 * Gibt die Breite der Figur zur�ck.
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
	 * Gibt die H�he der Figur zur�ck.
	 * 
	 * @return
	 * Die H�he der Figur.
	 * 
	 * @todo Umbenennen zu "getHeight".
	 */
	public int getPointD() {
		return this.pointd;
	}
	
	/**
	 * Gibt die Position der Figur auf dem Spielfeld zur�ck.
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
