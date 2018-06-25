package a_gui;

import java.util.Observable;
import java.util.Observer;

import b_bl.Game;
import b_bl.TimeThread;
/**
 * Dies ist der Controller der Game Klasse.
 * Über Ihn wird auf die Game Klasse zugegriffen.
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public class Game_Controller implements int_Game_Controller, Observer {
	private int_Game_Model model;
	private Game game;
	private int_Game_View view;
	private Start_View start_view;
	private End_View end_view;
	private int inc;
	
	public Game_Controller() {
		this.start_view = new Start_View(this);
		this.game = new Game();
		this.model = new Game_Model();
		this.view = new Game_View(this, this.model);
		this.model.addObserver(this.view);
		this.game.addObserver(this);
	}
	
	/***/
	public void left(){
		this.game.left();
		this.reloadField();
	}
	
	/***/
	public void right(){
		this.game.right();
		this.reloadField();
	}
	
	/***/
	public void down(){
		this.inc = this.game.down();
		this.reloadField();
	}
	
	/***/
	public void reloadField(){
		this.model.reloadNextFigure(this.game.reloadNextFigure());
		this.model.reloadField(this.game.reloadField(), this.inc);
		this.inc = 0;
	}
	
	/***/
	public void newGame(){
		this.game.newGame();
		this.reloadField();
		this.view.activate();
	}
	
	/***/
	public void endGame(){
		this.end_view = new End_View(this);
	}
	
	public void setName(String name) {
		this.model.init(name);
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}

	public void update(Observable o, Object arg) {
		if((int) arg == 1) {
			System.out.println("GAME IST FERTIG");
			this.view.deactivate();
			this.endGame();
		}
		else if((int) arg == 2) {
			System.out.println(Integer.toString(this.game.getTime()));
			this.model.setTime(this.game.getTime());
		}
	}

}
