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
		System.out.println(this.game.toString());
	}
	
	/***/
	public void left(){
		
	}
	
	/***/
	public void right(){
		
	}
	
	/***/
	public void down(){
		
	}
	
	/***/
	public void reloadField(){
		
	}
	
	/***/
	public void reloadNext(){
		
	}
	
	/***/
	public void newGame(){
		this.game.newGame();
	}
	
	/***/
	public void endGame(){
		
	}
}
