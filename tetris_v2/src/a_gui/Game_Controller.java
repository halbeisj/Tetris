package a_gui;

import b_bl.Game;
/**
 * Dies ist der Controller der Game Klasse.
 * Über Ihn wird auf die Game Klasse zugegriffen.
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public class Game_Controller implements int_Game_Controller {
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
		//this.game.endGame();
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
	
	/*private void reloadNextFigure() {
		this.model.reloadNextFigure(this.game.reloadNextFigure());
	}*/
}
