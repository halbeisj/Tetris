package b_bl;

import java.awt.Point;

import c_db.Figure;

import d_dto.Point_DTO;

/**
 * Diese Klasse ist für das Spiel und den Spielstand verantwortlich. 
 * Hier werden das aktuelle Feld, die momentan fallende Figur und die nächste Figur gespeichert. 
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */

/* Tetrisfeld
 * ###################
 * # 0|2 # 1|2 # 2|2 #
 * ###################
 * # 0|1 # 1|1 # 2|1 #
 * ###################
 * # 0|0 # 1|0 # 2|0 #
 * ###################
 */

public class Game {
	private Point_DTO[][] field;
	private Figure figure;
	private Figure figure_next;

	/***/
	public void left() {
		if(this.figure.getPointL().x > 0 && this.field[this.figure.getPointL().x - 1][this.figure.getPointL().y].getStatus() != 1) {
			this.figure.setSource(new Point(this.figure.getPointL().x - 1, this.figure.getPointL().y));
		}
	}

	/***/
	public void right() {
		if(this.figure.getPointR().x < 5 && this.field[this.figure.getPointR().x + 1][this.figure.getPointR().y].getStatus() != 1) {
			this.figure.setSource(new Point(this.figure.getPointL().x + 1, this.figure.getPointL().y));
		}
	}

	/***/
	public boolean down() {
		for(Point_DTO point : this.figure.getFigure()[0]) {
			if(point != null && field[point.getPoint().x][point.getPoint().y - 1].getStatus() == 1 || this.figure.getPoint().y == 0) {
				return false;
			}
		}
		this.figure.setSource(new Point(this.figure.getPointL().x, this.figure.getPointL().y - 1));
		return true;
	}

	/***/
	public void createNewFigure() {

	}

	/***/
	public void newGame() {

	}

	/***/
	public void endGame() {

	}
	
	private boolean checkCollision(Figure figure) {		
		for(Point_DTO point : figure.getFigure()[0]) {
			if(point != null && field[point.getPoint().x][point.getPoint().y - 1].getStatus() != 1) {
				return true;
				//this.figure.setPoint(new Point(this.figure.getPoint().x, this.figure.getPoint().y - 1));
			}
		}
		
		return false;
	}

}
