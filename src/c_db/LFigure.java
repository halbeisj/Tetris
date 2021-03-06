package c_db;

import java.awt.Color;

import d_dto.Field;
import d_dto.FieldState;

/**
 * Repräsentiert eine Figur, welche ein "L" darstellt.
 * 
 * @author Julia Halbeisen
 */
public class LFigure extends Figure {
	/**
	 * Initialisiert eine neue Instanz der {@link LFigure} Klasse.
	 */
	public LFigure() {
		this.figure = new Field[3][2];
		this.figure[0][0] = new Field(Color.orange, FieldState.Temporary);
		this.figure[1][0] = new Field(Color.orange, FieldState.Temporary);
		this.figure[2][0] = new Field(Color.orange, FieldState.Temporary);
		this.figure[2][1] = new Field(Color.orange, FieldState.Temporary);

		this.pointr = 2;
		this.pointd = 3;
	}
}