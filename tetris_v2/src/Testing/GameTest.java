package Testing;

import static org.junit.Assert.*;

import org.junit.Test;
import b_bl.*;
import d_dto.Point_DTO;

public class GameTest {
	private Game game = new Game();

	/**
	 * Überprüfung, ob das Feld im Ursprungszustand leer ist.
	 */
	@Test
	public void EmptyField() {
		int counter = 0;
		
		Point_DTO[][] field = game.reloadField();
		
		for (int i = 0; i < field.length; i++)
		{
			for (int j = 0; j < field[i].length; j++)
			{
				if (field[i][j].getStatus() != 0)
				{
					counter++;
				}
			}
		}
		
		assertEquals(counter, 0);
	}
	
	/**
	 * Überprüfung, ob die Grösse des Feldes `field_width` und `field_height` entspricht.
	 */
	@Test
	public void FieldSize() {
		Point_DTO[][] field = game.reloadField();

		assertEquals(field.length, game.getHeight());
		
		for (int i = 0; i < field.length; i++)
		{
			assertEquals(field[i].length, game.getWidth());
		}
	}
}
