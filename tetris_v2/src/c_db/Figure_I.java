package c_db;

import java.awt.Color;

import d_dto.Point_DTO;

/**
 * Repräsentiert eine Figur, welche ein "I" darstellt.
 * 
 * @author Julia Halbeisen
 */
public class Figure_I extends Figure {
	/**
	 * Initialisiert eine neue Instanz der {@link Figure_I} Klasse.
	 */
	public Figure_I() {
		this.figure = new Point_DTO[4][1];
		this.figure[0][0] = new Point_DTO(null, Color.white, 2);
		this.figure[1][0] = new Point_DTO(null, Color.white, 2);
		this.figure[2][0] = new Point_DTO(null, Color.white, 2);
		this.figure[3][0] = new Point_DTO(null, Color.white, 2);

		this.pointr = 0;
		this.pointd = 3;
	}

}
