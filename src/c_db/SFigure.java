package c_db;

import java.awt.Color;

import d_dto.Field;

/**
 * Repr�sentiert eine Figur, welche ein "S" darstellt.
 * 
 * @author Julia Halbeisen
 */
public class SFigure extends Figure {
	/**
	 * Initialisiert eine neue Instanz der {@link SFigure} Klasse.
	 */
	public SFigure() {
		this.figure = new Field[2][3];
		this.figure[0][0] = null;
		this.figure[0][1] = new Field(null, Color.red, 2);
		this.figure[0][2] = new Field(null, Color.red, 2);
		this.figure[1][0] = new Field(null, Color.red, 2);
		this.figure[1][1] = new Field(null, Color.red, 2);
		this.figure[1][2] = null;

		this.pointr = 2;
		this.pointd = 1;
	}
}