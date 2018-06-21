package a_gui;

import java.util.Observable;

import d_dto.Point_DTO;

/***/
public class Game_Model extends Observable {
	
	private Point_DTO[][] field;
	private int time;
	private int lines;
	private int level;
	private String name;
	
	/***/
	public void reloadField(Point_DTO[][] field){
	
		this.setChanged();
		this.notifyObservers();
	}
	
	/***/
	public void incLine(){
		
	}
	
	/***/
	public void incLevel(){
		
	}
	
	/***/
	public void setName(String name){
		
	}
	

}
