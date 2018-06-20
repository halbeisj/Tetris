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
 * # 0|0 # 0|1 # 0|2 #
 * ###################
 * # 1|0 # 1|1 # 1|2 #
 * ###################
 * # 2|0 # 2|1 # 2|2 #
 * ###################
 */

public class Game {
	private Point_DTO[][] field;
	private Figure figure;
	private Figure figure_next;

	/**Mit dieser Methode, kann man die Figur nach links verschieben*/
	public void left() {
		if(this.figure.getSource().y + this.figure.getPointL() > 0) {
			//Point_DTO[][] f= figure.getFigure();
			for(int i = 0; i < this.figure.getColumn(this.figure.getPointL()).length; i++) {
				if(this.field[this.figure.getSource().x + i][this.figure.getSource().y + this.figure.getPointL() - 1].getStatus() == 1 && this.figure.getFigure()[i][this.figure.getPointL()] != null) {
					return;
				}
			}
			this.figure.setSource(new Point(this.figure.getSource().x - 1, this.figure.getSource().y));
		}
		else {return;}
		/*if(this.field[this.figure.getSource().y + this.figure.getPointL() - 1][this.figure.getSource().x + i].getStatus() == 1 && this.figure.getFigure()[this.figure.getSource().y + this.figure.getPointL()][i] != null)*/
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
		if(this.figure.getSource().y == 0) {
			this.addFigure(this.figure);
			return false;
		}
		
		for(int i = 0; i < this.figure.getFigure()[this.figure.getSource().y + this.figure.getPointD()].length; i++) {
			if(this.field[this.figure.getSource().y + this.figure.getPointD()][i + 1].getStatus() == 0) {
				this.addFigure(this.figure);
				return false;
			}
		}
		
		this.figure.setSource(new Point(this.figure.getSource().x, this.figure.getSource().y + 1));
		return true;
		
		
		/*for(Point_DTO point : this.figure.getFigure()[0]) {
			if(point != null && field[point.getPoint().x][point.getPoint().y - 1].getStatus() == 1 || this.figure.getPoint().y == 0) {
				return false;
			}
		}
		this.figure.setSource(new Point(this.figure.getPointL().x, this.figure.getPointL().y - 1));
		return true;*/
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
	
	private void addFigure(Figure figure) {
		for(int i = 0; i < this.figure.getFigure().length; i++) {
			for(int y = 0; i < this.figure.getFigure()[i].length; i++) {
				this.field[this.figure.getSource().][]
			}
		}
	}
	
	

}
