package a_gui;

/**Dies ist das Interface des Game Controllers.
 * Über diese Klasse wird auf den Game_Controller zugegriffen.
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public interface int_Game_Controller {
public void left();
public void right();
public void down();
public void reloadField();
public void newGame();
public void endGame();
public void setName(String name);
public int getWidth();
public int getHeight();
}
