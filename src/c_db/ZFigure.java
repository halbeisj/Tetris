package c_db;

import java.awt.Color;
import d_dto.Field;
import d_dto.FieldState;

/**
 * Repr�sentiert eine Figur, welche ein "Z" darstellt.
 * 
 * @author Julia Halbeisen
 */
public class ZFigure extends Figure{
	/**
	 * Initialisiert eine neue Instanz der {@link ZFigure} Klasse.
	 */
	public ZFigure() {
		this.figure = new Field[2][3];
		this.figure[0][0] = new Field(Color.blue, FieldState.Temporary);
		this.figure[0][1] = new Field(Color.blue, FieldState.Temporary);
		this.figure[1][1] = new Field(Color.blue, FieldState.Temporary);
		this.figure[1][2] = new Field(Color.blue, FieldState.Temporary);

		this.pointr = 3;
		this.pointd = 2;
	}
}
