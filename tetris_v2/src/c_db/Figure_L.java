package c_db;

import java.awt.Color;

import d_dto.Point_DTO;

/**
 * Repräsentiert eine Figur, welche ein "L" darstellt.
 * 
 * @author Julia Halbeisen
 */
public class Figure_L extends Figure {
	/**
	 * Initialisiert eine neue Instanz der {@link Figure_L} Klasse.
	 */
	public Figure_L() {
		this.figure = new Point_DTO[3][2];
		this.figure[0][0] = new Point_DTO(null, Color.orange, 2);
		this.figure[1][0] = new Point_DTO(null, Color.orange, 2);
		this.figure[2][0] = new Point_DTO(null, Color.orange, 2);
		this.figure[2][1] = new Point_DTO(null, Color.orange, 2);
		this.figure[0][1] = null;
		this.figure[1][1] = null;

		this.pointr = 1;
		this.pointd = 2;
	}
}