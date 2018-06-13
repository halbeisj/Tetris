package c_db;

import java.awt.Point;

import d_dto.Point_DTO;

/***/
public class Figure {
	private Point_DTO[][] figure;
	private Point pointl;
	private Point pointr;

	/***/
	public Point_DTO[][] getFigure() {
		return figure;
	}

	/***/
	public Point getPointL() {
		return this.pointl;
	}

	public Point getPointR() {
		return this.pointr;
	}

	/**
	 * @param direction: true = horizontal; false = vertikal
	 * */
	public void setPoint(Point point, boolean direction) {
		int movement;
		movement = 
	}

}
