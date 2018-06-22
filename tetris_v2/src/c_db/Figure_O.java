package c_db;

import java.awt.Color;

import d_dto.Point_DTO;

/**Hier wird die Figur O erstellt, diese Klasse erbst von der Klasse Figure.
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public class Figure_O extends Figure{
	public Figure_O() {
		this.figure = new Point_DTO[2][2];
		this.figure[0][0] = new Point_DTO(null, Color.green, 2);
		this.figure[0][1] = new Point_DTO(null, Color.green, 2);
		this.figure[0][2] = new Point_DTO(null, Color.green, 2);
		this.figure[1][0] = new Point_DTO(null, Color.green, 2);
		
		this.pointl = 0;
		this.pointr = 1;
		this.pointd = 1;
	}

}
