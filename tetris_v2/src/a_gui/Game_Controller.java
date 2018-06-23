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
	
	public Game_Controller() {
		System.out.print("true1");
		this.start_view = new Start_View(this);
		this.game = new Game();
		this.model = new Game_Model();
		this.view = new Game_View(this, this.model);
		System.out.println(this.game.toString());
	}
	
	/***/
	public void left(){
		System.out.println("TEstController");
		this.game.left();
		this.model.reloadField(this.game.reloadField());
	}
	
	/***/
	public void right(){
		this.game.right();
	}
	
	/***/
	public void down(){
		this.game.down();
	}
	
	/***/
	public void reloadField(){
		this.model.reloadField(this.game.reloadField());
	}
	
	/***/
	public void reloadNext(){
		
	}
	
	/***/
	public void newGame(){
		this.game.newGame();
		this.view.activate();
		this.reloadField();
	}
	
	/***/
	public void endGame(){
		
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
}
