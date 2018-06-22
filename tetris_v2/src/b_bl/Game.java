package b_bl;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import c_db.Figure;
import c_db.Figure_Z;
import c_db.Figure_I;
import c_db.Figure_J;
import c_db.Figure_L;
import c_db.Figure_O;
import c_db.Figure_S;
import c_db.Figure_T;
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
	private int field_height = 14;
	private int field_width = 9;
	private Figure[] figure_templates = new Figure[7];

	
	public Game() {
		this.field = new Point_DTO[this.field_height][this.field_width];
		this.endGame();
	}
	
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
		if(this.figure.getSource().y + this.figure.getPointR() < this.field_width) {
			for(int i = 0; i < this.figure.getColumn(this.figure.getPointR()).length; i++) {
				if(this.field[this.figure.getSource().x + i][this.figure.getSource().y + this.figure.getPointR() + 1].getStatus() == 1 && this.figure.getFigure()[i][this.figure.getPointR()] != null){
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
		if(this.figure.getSource().x == field_height) {
			this.addFigure(this.figure);
			return false;
		}
		
		for(int i = 0; i < this.figure.getFigure()[this.figure.getPointD()].length; i++) {
			if(this.field[this.figure.getSource().x + this.figure.getPointD() + 1][this.figure.getSource().y + i].getStatus() == 0) {
				this.addFigure(this.figure);
				return false;
			}
		}
		
		this.figure.setSource(new Point(this.figure.getSource().x + 1, this.figure.getSource().y));
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
	private void createNewFigure() {
		if(this.figure_next == null) {
			this.figure_next = this.createRandomFigure();
		}
		this.figure = this.figure_next;
		this.figure_next = this.createRandomFigure();
	}
	
	private Figure createRandomFigure() {
		Random r = new Random();
		int figure_number = r.nextInt(7);
		
		switch (figure_number) {
		case 0: return new Figure_I();
		case 1: return new Figure_J();
		case 2: return new Figure_L();
		case 3: return new Figure_O();
		case 4: return new Figure_S();
		case 5: return new Figure_T();
		case 6: return new Figure_Z();
		default: return new Figure_I();
		}
	}
	
	/**Hiermit kann man das Spiel neustarten*/
	public void newGame() {
		this.endGame();
		this.createNewFigure();
	}

	/**Hiermit kann man das Spiel beenden*/
	public void endGame() {
		for(int i = 0; i < this.field_width; i++) {
			for(int y = 0; y < this.field_height; y++) {
				this.field[y][i] = new Point_DTO(new Point(y,i), Color.black, 0);
			}
		}
	}
	private void addFigure(Figure figure) {
		for(int i = 0; i < this.figure.getFigure().length; i++) {
			for(int y = 0; y < this.figure.getFigure()[i].length; y++) {
				if(this.figure.getFigure()[i][y] != null) {
					this.field[this.figure.getSource().x + i][this.figure.getSource().y + y].setStatus(1);
				}
			}
		}
	}
	
	public Point_DTO[][] reloadField() {
		
		/*Point_DTO[][] retfield = new Point_DTO[this.field_height][this.field_width];
		
		for(int i = 0; i < this.field_width; i++) {
			for(int y = 0; y < this.field_height; y++) {
				retfield[y][i] = this.field[y][i];
			}
		}
		
		return retfield;*/
		System.out.println("test2");
		return this.field;
	}

	public int getWidth() {
		return this.field_width;
	}
	
	public int getHeight() {
		return this.field_height;
	}
	
}
