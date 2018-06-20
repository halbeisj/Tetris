package b_bl;

import java.awt.Point;

import c_db.Figure;

import d_dto.Point_DTO;

/**
 * Diese Klasse ist f�r das Spiel und den Spielstand verantwortlich. 
 * Hier werden das aktuelle Feld, die momentan fallende Figur und die n�chste Figur gespeichert. 
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

	/**Mit dieser Methode, kann man die Figur nach links verschieben*/
	public void left() {
		if(this.figure.getSource().x + this.figure.getPointL() > 0) {
			//Point_DTO[][] f= figure.getFigure();
			
			for(int i = 0; i < this.figure.getColumn(this.figure.getPointL()).length; i++) {
				if(this.field[this.figure.getSource().x + this.figure.getPointL() - 1][this.figure.getSource().y + i].getStatus() == 1 && this.figure.getFigure()[this.figure.getSource().x + this.figure.getPointL()][i] != null) {
					return;
				}
			}
			
			this.figure.setSource(new Point(this.figure.getSource().x - 1, this.figure.getSource().y));
		}
		
		/*if(this.figure.getPointL() > 0 && this.field[this.figure.getPointL().x - 1][this.figure.getPointL().y].getStatus() != 1) {this.figure.setSource(new Point(this.figure.getPointL().x - 1, this.figure.getPointL().y));}*/
		/*if(this.figure.getSource().x + this.figure.getPointL() > 0 && this.field[this.figure.getSource().x + this.figure.getPointL() - 1][this.figure.getSource().y].getStatus() != 1) {this.figure.setSource(new Point(this.figure.getSource().x - 1, this.figure.getSource().y));*/
	}

	/**Mit dieser Methode, kann man die Figur nach rechts verschieben*/
	public void right() {
		if(this.figure.getSource().x + this.figure.getPointR() < 5) {
			for(int i = 0; i < this.figure.getColumn(this.figure.getPointR()).length; i++) {
				if(this.field[this.figure.getSource().x + this.figure.getPointR() + 1][this.figure.getSource().y + i].getStatus() == 1 && this.figure.getFigure()[this.figure.getSource().x + this.figure.getPointR()][i] != null){
					return;
				}
			}
			this.figure.setSource(new Point(this.figure.getSource().x + 1, this.figure.getSource().y));
		}
		
		/*if(this.figure.getSource().x + this.figure.getPointR() < 5 && this.field[this.figure.getSource().x + this.figure.getPointR() + 1][])*/
		/*if(this.figure.getPointR().x < 5 && this.field[this.figure.getPointR().x + 1][this.figure.getPointR().y].getStatus() != 1) {this.figure.setSource(new Point(this.figure.getPointL().x + 1, this.figure.getPointL().y));}*/
	}

	/**Mit dieser Methode, kann man die Figur nach unten verschieben*/
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

	/**Hiermit kann man das Spiel neustarten*/
	public void newGame() {

	}

	/**Hiermit kann man das Spiel beenden*/
	public void endGame() {

	}
	
	/**Diese Methode kontrolliert ob es eine Kollision gibt, oder ob die Figur verschoben werden kann.
	 * @param Figure
	 * */
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
