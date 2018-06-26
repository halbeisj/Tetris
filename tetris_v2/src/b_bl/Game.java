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
 * Es wird der Thread gestartet, welcher all Sekunde die anzahl verstrichene Sekunden in der Klasse Game erhöht.
 * Das Spielfeld an sich wird hier konfiguriert (Breite, Höhe)
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 */

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
	
	/**
	 * Feld in welchem die Punkte und deren Status abgespeichert werden
	 * 
	 * @see Point_DTO
	 */
	private Point_DTO[][] field;
	
	/**
	 * Aktuelle Figur
	 * 
	 * @see Figure
	 */
	private Figure figure;
	
	/**
	 * Nächste Figur
	 * 
	 * @see Figure
	 */
	private Figure figure_next;
	
	/**
	 * Höhe des Spielfeldes
	 */
	private int field_height = 11;
	
	/**
	 * Breite des Spielfeldes
	 */
	private int field_width = 11;
	
	/**
	 * Verstrichene Zeit seit Beginn der Runde
	 */
	private int timeInt = 0;
	
	/**
	 * Thread, der all Sekunde die Anzahl verstrichenen Sekunden seit Beginn der Runde erhöht
	 */
	private Thread timeThread;
	
	/**
	 * Konstruktor, welcher den Thread erstellt
	 * Feld wird erstellt
	 * Spiel wird beendet (Punkte im Feld werden neu erstellt)
	 */
	public Game() {
		this.timeThread = new Thread(new TimeThread(this));
		this.field = new Point_DTO[this.field_height][this.field_width];
		this.endGame();		
	}
	
	/**
	 * Mit dieser Methode, kann man die Figur nach links verschieben
	 * Wenn Figur links am Rand -> return;
	 * Wenn ein Feld links von Figur besetzt -> return;
	 * Sonst -> Figur wird nach links verschoben
	 * 
	 * @return null
	 * 
	 * @see Figure
	 * @see Point_DTO
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
	 * Mit dieser Methode, kann man die Figur nach rechts verschieben
	 * Wenn Figur rechts am Rand -> return;
	 * Wenn ein Feld rechts von Figur besetzt -> return;
	 * Sonst -> Figur wird nach rechts verschoben
	 * 
	 * @return null
	 * 
	 * @see Figure
	 * @see Point_DTO
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
	 * Mit dieser Methode, kann man die Figur nach unten verschieben
	 * Wenn Figur unten am Rand -> Figur wird zum Spielfeld geadded
	 * Wenn ein Feld rechts von Figur besetzt -> Figur wird zum Spielfeld geadded
	 * Sonst -> Figur wird nach unten verschoben
	 * 
	 * @return Anzahl Linien, die beim adden gelöscht wurden 
	 * 
	 * @see Figure
	 * @see Point_DTO
	 */
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
		}
		
		this.figure.setSource(new Point(this.figure.getSource().x + 1, this.figure.getSource().y));
		this.reloadFigure(0);
		return 0;
	}

	/**
	 * Wenn keine Figur existiert (zu Beginn) -> neue nächste Figur wird erstellt
	 * aktuelle Figur wird auf nächste Figur gesetzt
	 * nächste Figur wird zufällig neu erstellt
	 * Wenn Figur in einem besetzten Feld erstellt werden -> Observers werden mit 1 benachrichtigt
	 * 
	 * @see int_Game_Controller
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
					this.notifyObservers(1);
					return;
				}
			}
		}
		this.figure_next = this.createRandomFigure();
		this.figure_next.setSource(new Point(0, (int) (this.field_width / 2 + 0.5)));
		this.reloadFigure(2);
	}
	
	/**
	 * Es wird ein zufälliger Figurentyp zurückgegeben
	 * 
	 * @return ein zufälliger Figurentyp
	 */
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
	
	/**
	 * Startet das Spiel neu
	 * Spielfeld wird geleert; Aktuelle Figur wird geleert; Nächste Figur wird geleert
	 * Wenn TimeThread nicht am Leben ist -> Thread wird gestartet
	 * Neue Figur wird erstellt
	 * Verstrichene Zeit seit Beginn der Runde wird auf 0 gesetzt
	 * 
	 * @see TimeThread
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
	 * Spielfeld wird geleert
	 * Aktuelle Figur wird geleert
	 * Nächste Figur wird geleert
	 */
	public void endGame() {
		for(int i = 0; i < this.field_width; i++) {
			for(int y = 0; y < this.field_height; y++) {
				this.field[y][i] = new Point_DTO(new Point(y,i), Color.darkGray, 0);
			}
		}
		this.figure = null;
		this.figure_next = null;
	}
	
	/**
	 * Aktuelle Figur wird dem Spielfeld hinzugefügt
	 * Felder an Position werden als besetzt markiert
	 * 
	 * @return Anzahl Linien, die beim Hinzufügen entfernt wurden
	 * 
	 * @see Point_DTO
	 * @see Figure
	 */
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
	
	/**
	 * Aktuelles Feld wird zurückgegeben
	 * 
	 * @return Aktuelles Feld
	 */
	public Point_DTO[][] reloadField() {
		return this.field;
	}
	
	/**
	 * Nächste Figur wird zurückgegeben
	 * 
	 * @return Nächste Figur
	 */
	public Point_DTO[][] reloadNextFigure() {
		return this.figure_next.getField();
	}

	/**
	 * Gibt die Breite des Spielfeldes zurück
	 * 
	 * @return Breite des Spielfeldes
	 */
	public int getWidth() {
		return this.field_width;
	}
	
	
	/**
	 * Gibt die Höhe des Spiel
	 * @return
	 */
	public int getHeight() {
		return this.field_height;
	}
	
	/**
	 * Lädt die Figur auf dem Feld neu, wenn sie verschoben wurde
	 * Sorgt dafür, dass keine Punkte, die auf besetzt waren neu mit dem Wert frei erstellt werden
	 * 
	 * @param direction Richtung in welche die Figur verschoben wurde (1 = links, 0 = unten, -1 = rechts)
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
	
	/**
	 * Prüft, ob Linien voll sind
	 * Wenn ja -> Linien werden entfernt und Feld von oberhalb wird nach unten verschoben
	 * 
	 * @return Anzahl volle Linien, die entfernt wurden
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
	 * Zeit wird erhöht
	 * Observers werden benachrichtigt
	 */
	public void incTime() {
		this.timeInt++;
		this.setChanged();
		this.notifyObservers(2);
	}
	
	/**
	 * Zeit, die seit Beginn der Runde verstrichen ist, wird zurückgegeben
	 * 
	 * @return Zeit
	 */
	public int getTime() {
		return this.timeInt;
	}
}