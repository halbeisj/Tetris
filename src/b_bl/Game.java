package b_bl;

import java.awt.Color;
import java.awt.Point;
import java.util.Observable;
import java.util.Random;

import a_gui.GameStatistics;
import c_db.Figure;
import c_db.ZFigure;
import c_db.IFigure;
import c_db.JFigure;
import c_db.LFigure;
import c_db.CubeFigure;
import c_db.SFigure;
import c_db.TFigure;
import d_dto.Field;

/**
 * Repr�sentiert ein Tetris-Spiel.
 * 
 * @author Julia Halbeisen
 */
public class Game extends Observable {
	
	/**
	 * Die Auflistung aller Felder.
	 * 
	 * @todo Variable umbenennen.
	 */
	private Field[][] field;
	
	/**
	 * Die Aktuelle Figur.
	 */
	private Figure figure;
	
	/**
	 * Die n�chste Figur.
	 * 
	 * @todo: Variable umbenennen.
	 */
	private Figure figure_next;
	
	/**
	 * Die h�he des Spielfeldes.
	 * 
	 * @todo L�schen.
	 */
	private int field_height = 11;
	
	/**
	 * Breite des Spielfeldes
	 * 
	 * @todo L�schen.
	 */
	private int field_width = 11;
	
	/**
	 * Verstrichene Zeit seit Beginn der Runde
	 * 
	 * @todo L�schen.
	 */
	private int timeInt = 0;
	
	/**
	 * Thread, der all Sekunde die Anzahl verstrichenen Sekunden seit Beginn der Runde erh�ht
	 * 
	 * @todo L�schen und zu {@link GameStatistics} verschieben.
	 */
	private Thread timeThread;
	
	/**
	 * Initialisiert eine neue Instanz der {@link Game} Klasse.
	 */
	public Game() {
		this.timeThread = new Thread(new StopwatchThread(this));
		this.field = new Field[this.field_height][this.field_width];
		this.endGame();		
	}
	
	/**
	 * Bewegt die aktuelle Figur nach links.
	 * 
	 * @todo Methode l�schen - durch "moveFigure" ersetzen.
	 */
	public void left() {
		if(this.figure.getSource().y > 0) {
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

	/**
	 * Bewegt die aktuelle Figur nach rechts.
	 * 
	 * @todo Methode l�schen - durch "moveFigure" ersetzen.
	 */
	public void right() {
		if(this.figure.getSource().y + this.figure.getPointR() < this.field_width - 1) {
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
	}

	/**
	 * Bewegt die aktuelle Figur nach unten.
	 * 
	 * @todo Methode l�schen - durch "moveFigure" ersetzen.
	 */
	public int down() {
		if(this.figure.getSource().x == this.field_height - this.figure.getPointD() - 1) {
			return this.putFigure();
		}
		else {
			for(int x = 0; x < this.figure.getField().length; x++) {
				for(int y = 0; y < this.figure.getField()[0].length; y++) {
					if(this.figure.getField()[x][y] != null && this.field[this.figure.getSource().x + x + 1][this.figure.getSource().y + y].getStatus() == 1) {
						return this.putFigure();
					}
				}
			}
		}
		
		this.figure.setSource(new Point(this.figure.getSource().x + 1, this.figure.getSource().y));
		this.reloadFigure(0);
		return 0;
	}

	/**
	 * Erstellt eine neue Figur in der Warteschlange.
	 */
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
					this.notifyObservers(GameActionType.Lost);
					return;
				}
			}
		}
		this.figure_next = this.createRandomFigure();
		this.figure_next.setSource(new Point(0, (int) (this.field_width / 2 + 0.5)));
		this.reloadFigure(2);
	}
	
	/**
	 * Gibt eine zuf�llige Figur zur�ck.
	 * 
	 * @return
	 * Eine zuf�llig generierte Figur.
	 */
	private Figure createRandomFigure() {
		Random r = new Random();
		int figure_number = r.nextInt(7);
		
		switch (figure_number) {
		case 0: return new IFigure();
		case 1: return new JFigure();
		case 2: return new LFigure();
		case 3: return new CubeFigure();
		case 4: return new SFigure();
		case 5: return new TFigure();
		case 6: return new ZFigure();
		default: return new IFigure();
		}
	}
	
	/**
	 * Startet das Spiel neu.
	 */
	public void newGame() {
		this.endGame();
		if(!this.timeThread.isAlive()) {
			this.timeThread.start();
		}
		this.createNewFigure();
		this.timeInt = 0;
	}

	/**
	 * Beendet das Spiel.
	 */
	public void endGame() {
		for(int i = 0; i < this.field_width; i++) {
			for(int y = 0; y < this.field_height; y++) {
				this.field[y][i] = new Field(Color.darkGray, 0);
			}
		}
		this.figure = null;
		this.figure_next = null;
	}
	
	/**
	 * Aktuelle Figur wird dem Spielfeld hinzugef�gt
	 * Felder an Position werden als besetzt markiert
	 * 
	 * @return
	 * Anzahl Linien, die beim Hinzuf�gen entfernt wurden
	 * 
	 * @todo
	 *   - Das �berpr�fen der Reihen in {@link #down()} durchf�hren.
	 */
	private int putFigure() {
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
	
	/**
	 * Gibt das Feld zur�ck.
	 * 
	 * @return
	 * Das Feld.
	 * 
	 */
	public Field[][] getField() {
		return this.field;
	}
	
	/**
	 * Gibt die n�chste Figur zur�ck.
	 * 
	 * @return
	 * Die n�chste Figur.
	 */
	public Field[][] reloadNextFigure() {
		return this.figure_next.getField();
	}

	/**
	 * Gibt die Breite des Spielfeldes zur�ck.
	 * 
	 * @return
	 * Die Breite des Spielfeldes.
	 */
	public int getWidth() {
		return this.field_width;
	}
	
	
	/**
	 * Gibt die H�he des Spielfelds zur�ck.
	 * 
	 * @return
	 * Die H�he des Spielfelds.
	 */
	public int getHeight() {
		return this.field_height;
	}
	
	/**
	 * L�dt die Figur auf dem Feld neu, wenn sie verschoben wurde
	 * Sorgt daf�r, dass keine Punkte, die auf besetzt waren neu mit dem Wert frei erstellt werden
	 * 
	 * @param direction Richtung in welche die Figur verschoben wurde (1 = links, 0 = unten, -1 = rechts)
	 * 
	 * @todo Methode l�schen - durch "moveFigure" ersetzen.
	 */
	private void reloadFigure(int direction) {
		for (int x = 0; x < this.figure.getField().length; x++) {
			for (int y = 0; y < this.figure.getField()[0].length; y++) {
				if(this.figure.getField()[x][y] != null) {
					this.field[this.figure.getSource().x + x][this.figure.getSource().y + y] = this.figure.getField()[x][y];
				}
			}
		}
		if(direction == 1) {
			for(int x = 0; x < this.figure.getField().length; x++) {
				if(this.field[this.figure.getSource().x + x][this.figure.getSource().y + this.figure.getPointR() + 1].getStatus() != 1) {
					this.field[this.figure.getSource().x + x][this.figure.getSource().y + this.figure.getPointR() + 1] = new Field(Color.darkGray, 0);
				}
			}
			for(int x = 0; x < this.figure.getField().length; x++) {
				for(int y = 0; y < this.figure.getField()[0].length; y++) {
					if(this.figure.getField()[x][y] == null && this.field[this.figure.getSource().x + x][this.figure.getSource().y + y].getStatus() != 1) {
						this.field[this.figure.getSource().x + x][this.figure.getSource().y + y] = new Field(Color.darkGray, 0);
					}
				}
			}
		}
		else if (direction == -1){
			for(int x = 0; x < this.figure.getField().length; x++) {
				if(this.field[this.figure.getSource().x + x][this.figure.getSource().y - 1].getStatus() != 1) {
					this.field[this.figure.getSource().x + x][this.figure.getSource().y - 1] = new Field(Color.darkGray, 0);
				}	
			}
			for(int x = 0; x < this.figure.getField().length; x++) {
				for(int y = 0; y < this.figure.getField()[0].length; y++) {
					if(this.figure.getField()[x][y] == null && this.field[this.figure.getSource().x + x][this.figure.getSource().y + y].getStatus() != 1) {
						this.field[this.figure.getSource().x + x][this.figure.getSource().y + y] = new Field(Color.darkGray, 0);
					}
				}
			}
		}
		else if (direction == 0) {
			for(int y = 0; y < this.figure.getField()[0].length; y++) {
				if(this.field[this.figure.getSource().x - 1][this.figure.getSource().y + y].getStatus() != 1) {
					this.field[this.figure.getSource().x - 1][this.figure.getSource().y + y] = new Field(Color.darkGray, 0);
				}
			}
			for(int x = 0; x < this.figure.getField().length; x++) {
				for(int y = 0; y < this.figure.getField()[0].length; y++) {
					if(this.figure.getField()[x][y] == null && this.field[this.figure.getSource().x + x][this.figure.getSource().y + y].getStatus() != 1) {
						this.field[this.figure.getSource().x + x][this.figure.getSource().y + y] = new Field(Color.darkGray, 0);
					}
				}
			}
		}	
	}
	
	/**
	 * �berpr�ft, ob eine Reihe vollst�ndig ist.
	 */
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
	
	/**
	 * Zeit wird erh�ht
	 * Observers werden benachrichtigt
	 * 
	 * @todo Methode l�schen.
	 */
	public void incTime() {
		this.timeInt++;
		this.setChanged();
		this.notifyObservers(GameActionType.Update);
	}
	
	/**
	 * Zeit, die seit Beginn der Runde verstrichen ist, wird zur�ckgegeben
	 * 
	 * @return Zeit
	 * 
	 * @todo Methode l�schen.
	 */
	public int getTime() {
		return this.timeInt;
	}
}