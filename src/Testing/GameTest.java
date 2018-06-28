package Testing;

import static org.junit.Assert.*;

import org.junit.Test;
import b_bl.*;
import d_dto.Field;

/**
 * Stellt Tests f�r das Programm zur Verf�gung.
 * 
 * @author Julia Halbeisen
 */
public class GameTest {
	
	/**
	 * Die Test-Instanz des Spiels.
	 */
	private Game game = new Game();

	/**
	 * �berpr�fung, ob das Feld im Ursprungszustand leer ist.
	 */
	@Test
	public void EmptyField() {
		int counter = 0;
		
		Field[][] field = game.getField();
		
		for (int i = 0; i < field.length; i++)
		{
			for (int j = 0; j < field[i].length; j++)
			{
				if (field[i][j].getState() != 0)
				{
					counter++;
				}
			}
		}
		
		assertEquals(counter, 0);
	}
	
	/**
	 * �berpr�fung, ob die Gr�sse des Feldes `field_width` und `field_height` entspricht.
	 */
	@Test
	public void FieldSize() {
		Field[][] field = game.getField();

		assertEquals(field.length, game.getHeight());
		
		for (int i = 0; i < field.length; i++)
		{
			assertEquals(field[i].length, game.getWidth());
		}
	}
}
