package c_db;

import java.awt.Point;

import d_dto.Point_DTO;

/***/
public class Figure {
	/**
	 * Punkte, welche die Figur darstellen in Abh�ngigkeit vom urspr�nglichen Punkt
	 * */
	protected Point_DTO[][] figure;
	/**
	 * Linksester Punkt in Abh�ngigkeit vom urspr�nglichen Punkt
	 * */
	protected int pointl;
	/**
	 * Rechtsester Punkt in Abh�ngigkeit vom urspr�nglichen Punkt
	 * */
	protected int pointr;
	/**
	 * Unterster Punkt in Abh�ngigkeit vom urspr�nglichen Punkt
	 */
	protected int pointd;
	/**
	 * Urspr�nglicher Punkt auf dem ganzen Feld
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
