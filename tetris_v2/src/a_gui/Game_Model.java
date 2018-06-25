package a_gui;

import java.awt.Point;
import java.util.Observable;

import d_dto.Point_DTO;

/***/
public class Game_Model extends Observable implements int_Game_Model {
	
	private Point_DTO[][] field;
	private Point_DTO[][] nextFigure;
	private int time;
	private int lines;
	private int level;
	private String name;
	
	/***/
	public void reloadField(Point_DTO[][] field){
		this.field = field;
		
		if(this.lines % 10 == 0) {
			this.incLevel();
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	
	/***/
	public void incLine(){
		
	}
	
	/***/
	public void incLevel(){
		this.level++;
	}
	
	/***/
	public void init(String name){
		this.name = name;
		this.lines = 0;
		this.level = 0;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public int getLines() {
		return this.lines;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Point_DTO getPoint (int x, int y) {
		return this.field[y][x];
	}

	public void reloadNextFigure(Point_DTO[][] nextFigure) {
		this.nextFigure = nextFigure;
	}
	
	public Point_DTO getPointNextFigure (int x, int y) {
		return this.nextFigure[y][x];
	}
	
	public Point getNextFigureSize() {
		return new Point(this.nextFigure[0].length, this.nextFigure.length);
	}
	

}
