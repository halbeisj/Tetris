package c_db;

import java.awt.Color;

import d_dto.Point_DTO;

/**
 * Repräsentiert eine Figur, welche ein Quadrat darstellt.
 * 
 * @author Julia Halbeisen
 */
public class Figure_O extends Figure {
	/**
	 * Initialisiert eine neue Instanz der {@link Figure_O} Klasse.
	 */
	public Figure_O() {
		this.figure = new Point_DTO[2][2];
		this.figure[0][0] = new Point_DTO(null, Color.green, 2);
		this.figure[0][1] = new Point_DTO(null, Color.green, 2);
		this.figure[1][1] = new Point_DTO(null, Color.green, 2);
		this.figure[1][0] = new Point_DTO(null, Color.green, 2);

		this.pointr = 1;
		this.pointd = 1;
	}
}
