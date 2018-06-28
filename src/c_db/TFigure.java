package c_db;

import java.awt.Color;

import d_dto.Field;
import d_dto.FieldState;

/**
 * Repr�sentiert eine Figur, welche ein "L" darstellt.
 * 
 * @author Julia Halbeisen
 */
public class TFigure extends Figure {
	/**
	 * Initialisiert eine neue Instanz der {@link TFigure} Klasse.
	 */
	public TFigure() {
		this.figure = new Field[2][3];
		this.figure[0][0] = new Field(Color.yellow, FieldState.Temporary);
		this.figure[0][1] = new Field(Color.yellow, FieldState.Temporary);
		this.figure[0][2] = new Field(Color.yellow, FieldState.Temporary);
		this.figure[1][1] = new Field(Color.yellow, FieldState.Temporary);

		this.pointr = 3;
		this.pointd = 2;
	}
}
