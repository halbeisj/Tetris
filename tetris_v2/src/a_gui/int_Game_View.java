package a_gui;

import java.util.Observer;

/**Dies ist das Interface f�r die Game View.
 * �ber diese Klasse wird auf die Game_View zugegriffen.
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public interface int_Game_View extends Observer {
	public void activate();
	public void deactivate();
}
