package c_db;

import java.awt.Color;

import d_dto.Field;

/**
 * Repräsentiert eine Figur, welche ein Quadrat darstellt.
 * 
 * @author Julia Halbeisen
 */
public class CubeFigure extends Figure {
	/**
	 * Initialisiert eine neue Instanz der {@link CubeFigure} Klasse.
	 */
	public CubeFigure() {
		this.figure = new Field[2][2];
		this.figure[0][0] = new Field(Color.green, 2);
		this.figure[0][1] = new Field(Color.green, 2);
		this.figure[1][1] = new Field(Color.green, 2);
		this.figure[1][0] = new Field(Color.green, 2);

		this.pointr = 2;
		this.pointd = 2;
	}
}
