package c_db;

import java.awt.Color;

import d_dto.Point_DTO;

/**
 * Repräsentiert eine Figur, welche eine spiegelferkerte Version von
 * {@link Figure_L} darstellt.
 * 
 * @author Julia Halbeisen
 */
public class Figure_J extends Figure {
	/**
	 * Initialisiert eine neue Instanz der {@link Figure_J} Klasse.
	 */
	public Figure_J() {
		this.figure = new Point_DTO[3][2];
		this.figure[0][1] = new Point_DTO(null, Color.pink, 2);
		this.figure[1][1] = new Point_DTO(null, Color.pink, 2);
		this.figure[2][1] = new Point_DTO(null, Color.pink, 2);
		this.figure[2][0] = new Point_DTO(null, Color.pink, 2);
		this.figure[0][0] = null;
		this.figure[1][0] = null;

		this.pointr = 2;
		this.pointd = 3;
	}
}
