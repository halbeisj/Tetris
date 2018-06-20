package c_db;

import java.awt.Point;

import d_dto.Point_DTO;

/***/
public class Figure {
	/**
	 * Punkte, welche die Figur darstellen in Abhängigkeit vom ursprünglichen Punkt
	 * */
	private Point_DTO[][] figure;
	/**
	 * Linksester Punkt in Abhängigkeit vom ursprünglichen Punkt
	 * */
	private Point pointl;
	/**
	 * Rechtsester Punkt in Abhängigkeit vom ursprünglichen Punkt
	 * */
	private Point pointr;
	/**
	 * Ursprünglicher Punkt auf dem ganzen Feld
	 * */
	private Point source;

	/***/
	public Point_DTO[][] getFigure() {
		return figure;
	}

	/***/
	public int getPointL() {
		return this.pointl.x;
	}

	public int getPointR() {
		return this.pointr.x;
	}
	
	public Point getSource() {
		
	}

	/**
	 * @param direction: true = horizontal; false = vertikal
	 * */
	public void setSource(Point point) {
		this.source = point;
		/*int movement;
		movement =*/ 
	}

}
