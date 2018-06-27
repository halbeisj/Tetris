package c_db;

import java.awt.Color;

import d_dto.Field;

/**
 * Repräsentiert eine Figur, welche ein "L" darstellt.
 * 
 * @author Julia Halbeisen
 */
public class TFigure extends Figure {
	/**
	 * Initialisiert eine neue Instanz der {@link TFigure} Klasse.
	 */
	public TFigure() {
		this.figure = new Field[2][3];
		this.figure[0][0] = new Field(null, Color.yellow, 2);
		this.figure[0][1] = new Field(null, Color.yellow, 2);
		this.figure[0][2] = new Field(null, Color.yellow, 2);
		this.figure[1][0] = null;
		this.figure[1][1] = new Field(null, Color.yellow, 2);
		this.figure[1][2] = null;

		this.pointr = 2;
		this.pointd = 1;
	}
}
