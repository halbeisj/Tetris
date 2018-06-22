package c_db;

import java.awt.Point;

import d_dto.Point_DTO;

/***/
public class Figure {
	/**
	 * Punkte, welche die Figur darstellen in Abhängigkeit vom ursprünglichen Punkt
	 * */
	protected Point_DTO[][] figure;
	/**
	 * Linksester Punkt in Abhängigkeit vom ursprünglichen Punkt
	 * */
	protected int pointl;
	/**
	 * Rechtsester Punkt in Abhängigkeit vom ursprünglichen Punkt
	 * */
	protected int pointr;
	/**
	 * Unterster Punkt in Abhängigkeit vom ursprünglichen Punkt
	 */
	protected int pointd;
	/**
	 * Ursprünglicher Punkt auf dem ganzen Feld
	 * */
	protected Point source;

	/***/
	public Point_DTO[][] getFigure() {
		return figure;
	}

	/***/
	public int getPointL() {
		return this.pointl;
	}

	/***/
	public int getPointR() {
		return this.pointr;
	}
	
	public int getPointD() {
		return this.pointd;
	}
	
	public Point getSource() {
		return this.source;
	}

	/**
	 * @param direction: true = horizontal; false = vertikal
	 * */
	public void setSource(Point point) {
		this.source = point;
		/*int movement;
		movement =*/ 
	}
	
	public Point_DTO[] getColumn(int index){
	    Point_DTO[] column = new Point_DTO[this.figure[0].length]; 
	    for(int i = 0; i < column.length; i++){
	       column[i] = figure[i][index];
	    }
	    return column;
	}
	

}
