package b_bl;

import java.awt.Color;
import java.awt.Point;
import java.util.Observable;
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

public class Game extends Observable {
	private Point_DTO[][] field;
	private Figure figure;
	private Figure figure_next;
	private int field_height = 11;
	private int field_width = 11;
	private int timeInt = 0;
	private Thread timeThread;
	
	public Game() {
		this.timeThread = new Thread(new TimeThread(this));
		this.field = new Point_DTO[this.field_height][this.field_width];
		this.endGame();		
	}
	
	/**Mit dieser Methode, kann man die Figur nach links verschieben*/
	public void left() {
		if(this.figure.getSource().y + this.figure.getPointL() > 0) {
			/*for(int i = 0; i < this.figure.getColumn(this.figure.getPointL()).length; i++) {
				if(this.field[this.figure.getSource().x + i][this.figure.getSource().y + this.figure.getPointL() - 1].getStatus() == 1 && this.figure.getFigure()[i][this.figure.getPointL()] != null) {
					return;
				}
			}*/
			for(int x = 0; x < this.figure.getField().length; x++) {
				for (int y = 0; y < this.figure.getField()[0].length; y++) {
					if(this.figure.getField()[x][y] != null && this.field[this.figure.getSource().x + x][this.figure.getSource().y + y - 1].getStatus() == 1) {
						return;
					}
				}
			}
			this.figure.setSource(new Point(this.figure.getSource().x, this.figure.getSource().y - 1));
			this.reloadFigure(1);
		}
		else {return;}
	}

	/**Mit dieser Methode, kann man die Figur nach rechts verschieben*/
	public void right() {
		if(this.figure.getSource().y + this.figure.getPointR() < this.field_width - 1) {
			//Point_DTO[][] f= figure.getFigure();
			/*for(int i = 0; i < this.figure.getColumn(this.figure.getPointR()).length; i++) {
				if(this.field[this.figure.getSource().x + i][this.figure.getSource().y + this.figure.getPointR() + 1].getStatus() == 1 && this.figure.getFigure()[i][this.figure.getPointR()] != null) {
					return;
				}
			}*/
			for(int x = 0; x < this.figure.getField().length; x++) {
				for(int y = 0; y < this.figure.getField()[0].length; y++) {
					if(this.figure.getField()[x][y] != null && this.field[this.figure.getSource().x + x][this.figure.getSource().y + y + 1].getStatus() == 1) {
						return;
					}
				}
			}
			this.figure.setSource(new Point(this.figure.getSource().x, this.figure.getSource().y + 1));
			this.reloadFigure(-1);
		}
		else {return;}
		
		
		
		/*if(this.figure.getSource().y + this.figure.getPointR() < this.field_width) {
			for(int i = 0; i < this.figure.getColumn(this.figure.getPointR()).length; i++) {
				if(this.field[this.figure.getSource().x + i][this.figure.getSource().y + this.figure.getPointR() + 1].getStatus() == 1 && this.figure.getFigure()[i][this.figure.getPointR()] != null){
					return;
				}
			}
			this.figure.setSource(new Point(this.figure.getSource().x + 1, this.figure.getSource().y));
		}*/
		
		/*if(this.figure.getSource().x + this.figure.getPointR() < 5 && this.field[this.figure.getSource().x + this.figure.getPointR() + 1][])*/
		/*if(this.figure.getPointR().x < 5 && this.field[this.figure.getPointR().x + 1][this.figure.getPointR().y].getStatus() != 1) {this.figure.setSource(new Point(this.figure.getPointL().x + 1, this.figure.getPointL().y));}*/
	}

	/**Mit dieser Methode, kann man die Figur nach unten verschieben*/
	public int down() {
		if(this.figure.getSource().x == this.field_height - this.figure.getPointD() - 1) {
			return this.addFigure();
		}
		else {
			for(int x = 0; x < this.figure.getField().length; x++) {
				for(int y = 0; y < this.figure.getField()[0].length; y++) {
					if(this.figure.getField()[x][y] != null && this.field[this.figure.getSource().x + x + 1][this.figure.getSource().y + y].getStatus() == 1) {
						return this.addFigure();
					}
				}
			}
			
			
			
			/*for(int i = 0; i < this.figure.getFigure()[this.figure.getPointD()].length; i++) {
				if(this.field[this.figure.getSource().x + this.figure.getPointD() + 1][this.figure.getSource().y + i].getStatus() == 0) {
					this.addFigure(this.figure);
					return false;
				}
			}*/
		}
		
		this.figure.setSource(new Point(this.figure.getSource().x + 1, this.figure.getSource().y));
		this.reloadFigure(0);
		return 0;
		
		
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
			this.figure_next.setSource(new Point(0, (int) (this.field_width / 2 + 0.5)));
		}
		this.figure = this.figure_next;
		for(int x = 0; x < this.figure.getField().length; x++) {
			for(int y = 0; y < this.figure.getField()[0].length; y++) {
				if(this.field[this.figure.getSource().x + x][this.figure.getSource().y].getStatus() == 1 && this.figure.getField()[x][y] != null) {
					this.setChanged();
					this.notifyObservers(1);
					return;
				}
			}
		}
		this.figure_next = this.createRandomFigure();
		this.figure_next.setSource(new Point(0, (int) (this.field_width / 2 + 0.5)));
		this.reloadFigure(2);
		
		/*for(int y = 0; y < this.figure.getFigure().length; y++) {
			for(int x = 0; x < this.figure.getFigure()[0].length; x++) {
				this.nextFigure[x][y] = this.figure_next.getFigure()[x][y];
			}
		}*/
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
		if(!this.timeThread.isAlive()) {
			this.timeThread.start();
			System.out.println(this.timeThread);
		}
		this.createNewFigure();
		this.timeInt = 0;
	}

	/**Hiermit kann man das Spiel beenden*/
	public void endGame() {
		for(int i = 0; i < this.field_width; i++) {
			for(int y = 0; y < this.field_height; y++) {
				this.field[y][i] = new Point_DTO(new Point(y,i), Color.darkGray, 0);
			}
		}
		this.figure = null;
		this.figure_next = null;
	}
	private int addFigure() {
		for(int x = 0; x < this.figure.getField().length; x++) {
			for(int y = 0; y < this.figure.getField()[0].length; y++) {
				if(this.figure.getField()[x][y] != null) {
					this.field[this.figure.getSource().x + x][this.figure.getSource().y + y].setStatus(1);
				}
			}
		}
		int temp = this.checkFullRow();
		this.createNewFigure();
		return temp;
	}
	
	public Point_DTO[][] reloadField() {
		
		/*Point_DTO[][] retfield = new Point_DTO[this.field_height][this.field_width];
		
		for(int i = 0; i < this.field_width; i++) {
			for(int y = 0; y < this.field_height; y++) {
				retfield[y][i] = this.field[y][i];
			}
		}
		
		return retfield;*/
		//this.field[this.figure.getSource().x][this.figure.getSource().y].setColor(Color.cyan);
		return this.field;
	}
	
	public Point_DTO[][] reloadNextFigure() {
		return this.figure_next.getField();
	}
	
	public Point_DTO[][] getField() {
		return this.field;
	}
	
	public Figure getFigure() {
		return this.figure;
	}
	
	public Figure getNextFigure() {
		return this.figure_next;
	}

	public int getWidth() {
		return this.field_width;
	}
	
	public int getHeight() {
		return this.field_height;
	}
	
	private void reloadFigure(int direction) {
		for (int x = 0; x < this.figure.getField().length; x++) {
			for (int y = 0; y < this.figure.getField()[0].length; y++) {
				if(this.figure.getField()[x][y] != null) {
					//int tempx = this.figure.getSource().x - this.figure.getFigure()[0].length + direction * x;
					//int tempy = this.figure.getSource().y - this.figure.getFigure().length + y;
					this.field[this.figure.getSource().x + x][this.figure.getSource().y + y] = this.figure.getField()[x][y];
					//this.field[this.figure.getSource().x + x][this.figure.getSource().y + y + this.figure.getPointD()] = new Point_DTO(new Point(this.figure.getSource().x + x, this.figure.getSource().y + y + this.figure.getPointD()), Color.GREEN, 0);
				}
				/*else if (this.figure.getFigure()[x][y] == null && y != direction && y != 0){
					this.field[this.figure.getSource().x + x][this.figure.getSource().y + 1 + direction] = new Point_DTO(new Point(this.figure.getSource().x - x, this.figure.getSource().y + y + this.figure.getPointD()), Color.darkGray, 0);
				}*/
			}
		}
		if(direction == 1) {
			for(int x = 0; x < this.figure.getField().length; x++) {
				if(this.field[this.figure.getSource().x + x][this.figure.getSource().y + this.figure.getPointR() + 1].getStatus() != 1) {
					this.field[this.figure.getSource().x + x][this.figure.getSource().y + this.figure.getPointR() + 1] = new Point_DTO(new Point(this.figure.getSource().x - x, this.figure.getSource().y + this.figure.getPointR() + direction), Color.darkGray, 0);
				}
			}
			for(int x = 0; x < this.figure.getField().length; x++) {
				for(int y = 0; y < this.figure.getField()[0].length; y++) {
					if(this.figure.getField()[x][y] == null && this.field[this.figure.getSource().x + x][this.figure.getSource().y + y].getStatus() != 1) {
						this.field[this.figure.getSource().x + x][this.figure.getSource().y + y] = new Point_DTO(new Point(this.figure.getSource().x - x, this.figure.getSource().y + y + this.figure.getPointD()), Color.darkGray, 0);
					}
				}
			}
		}
		else if (direction == -1){
			for(int x = 0; x < this.figure.getField().length; x++) {
				if(this.field[this.figure.getSource().x + x][this.figure.getSource().y - 1].getStatus() != 1) {
					this.field[this.figure.getSource().x + x][this.figure.getSource().y - 1] = new Point_DTO(new Point(this.figure.getSource().x - x, this.figure.getSource().y + this.figure.getPointR() + direction), Color.darkGray, 0);
				}	
			}
			for(int x = 0; x < this.figure.getField().length; x++) {
				for(int y = 0; y < this.figure.getField()[0].length; y++) {
					if(this.figure.getField()[x][y] == null && this.field[this.figure.getSource().x + x][this.figure.getSource().y + y].getStatus() != 1) {
						this.field[this.figure.getSource().x + x][this.figure.getSource().y + y] = new Point_DTO(new Point(this.figure.getSource().x - x, this.figure.getSource().y + y + this.figure.getPointD()), Color.darkGray, 0);
					}
				}
			}
		}
		else if (direction == 0) {
			for(int y = 0; y < this.figure.getField()[0].length; y++) {
				if(this.field[this.figure.getSource().x - 1][this.figure.getSource().y + y].getStatus() != 1) {
					this.field[this.figure.getSource().x - 1][this.figure.getSource().y + y] = new Point_DTO(new Point(this.figure.getSource().x - 1, this.figure.getSource().y + y), Color.darkGray, 0);
				}
			}
			for(int x = 0; x < this.figure.getField().length; x++) {
				for(int y = 0; y < this.figure.getField()[0].length; y++) {
					if(this.figure.getField()[x][y] == null && this.field[this.figure.getSource().x + x][this.figure.getSource().y + y].getStatus() != 1) {
						this.field[this.figure.getSource().x + x][this.figure.getSource().y + y] = new Point_DTO(new Point(this.figure.getSource().x - x, this.figure.getSource().y + y + this.figure.getPointD()), Color.darkGray, 0);
					}
				}
			}
		}	
	}
	
	private int checkFullRow() {
		boolean full;
		int rows = 0;
		for(int y = 0; y < this.field_height; y++) {
			full = true;
			for(int x = 0; x < this.field_width; x++) {
				if(this.field[y][x].getStatus() == 0) {
					full = false;
					break;
				}
			}
			if(full) {
				rows++;
				for(int x = 0; x < this.field_width; x++) {
					for(int y2 = 0; y2 < y; y2++) {
						this.field[y - y2][x] = this.field[y - y2 - 1][x];
					}
				}
			}
		}
		return rows;
	}
	
	public void incTime() {
		this.timeInt++;
		this.setChanged();
		this.notifyObservers(2);
	}
	
	public int getTime() {
		return this.timeInt;
	}
}