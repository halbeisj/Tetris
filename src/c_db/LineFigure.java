package c_db;

import java.awt.Color;

import d_dto.Field;

/**
 * Repr�sentiert eine Figur, welche ein "I" darstellt.
 * 
 * @author Julia Halbeisen
 */
public class LineFigure extends Figure {
	/**
	 * Initialisiert eine neue Instanz der {@link LineFigure} Klasse.
	 */
	public LineFigure() {
		this.figure = new Field[4][1];
		this.figure[0][0] = new Field(null, Color.white, 2);
		this.figure[1][0] = new Field(null, Color.white, 2);
		this.figure[2][0] = new Field(null, Color.white, 2);
		this.figure[3][0] = new Field(null, Color.white, 2);

		this.pointr = 0;
		this.pointd = 3;
	}

}