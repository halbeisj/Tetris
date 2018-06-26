package c_db;

import java.awt.Point;

import d_dto.Point_DTO;

/**
 * Vorlage f�r alle Figurtypen
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 */
public class Figure {
	/**
	 * Punkte, welche die Figur darstellen in Abh�ngigkeit vom urspr�nglichen Punkt
	 */
	protected Point_DTO[][] figure;
	/**
	 * Linksester Punkt in Abh�ngigkeit vom urspr�nglichen Punkt
	 */
	protected int pointr;
	/**
	 * Unterster Punkt in Abh�ngigkeit vom urspr�nglichen Punkt
	 */
	protected int pointd;
	/**
	 * Urspr�nglicher Punkt auf dem ganzen Feld
	 */
	protected Point source;
	
	/**
	 * Gibt die Figur, als 2d Array von Point_DTO zur�ck
	 * 
	 * @return Figur als 2d Array von Point_DTO
	 * 
	 * @see Point_DTO
	 */
	public Point_DTO[][] getField() {
		return figure;
	}

	/**
	 * Gibt den Abstand zwischen dem Source-Punkt und dem rechten Rand zur�ck
	 * 
	 * @return Abstand zwischen Source-Punkt und rechtem Rand
	 */
	public int getPointR() {
		return this.pointr;
	}
	
	/**
	 * Gibt den Abstand zwischen dem Source-Punkt und dem unteren Rand zur�ck
	 * 
	 * @return Abstand zwischen Source-Punkt und unterem Rand
	 */
	public int getPointD() {
		return this.pointd;
	}
	
	/**
	 * Gibt die Position des Source-Punktes auf dem Spielfeld zur�ck
	 * 
	 * @return Position des Source-Punktes auf dem Spielfeld
	 */
	public Point getSource() {
		return this.source;
	}

	/**
	 * Setzt die Position des Source-Punktes auf dem Spielfeld neu
	 * 
	 * @param point Punkt, auf welchen der Source-Punkt gesetzt wird
	 */
	public void setSource(Point point) {
		this.source = point;
	}
	

}
