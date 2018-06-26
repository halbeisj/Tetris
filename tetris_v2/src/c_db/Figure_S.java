package c_db;

import java.awt.Color;

import d_dto.Point_DTO;

/**Hier wird die Figur S erstellt, diese Klasse erbt von der Klasse Figure.
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public class Figure_S extends Figure{
	public Figure_S() {
		this.figure = new Point_DTO[2][3];
		this.figure[0][0] = null;
		this.figure[0][1] = new Point_DTO(null, Color.red, 2);
		this.figure[0][2] = new Point_DTO(null, Color.red, 2);
		this.figure[1][0] = new Point_DTO(null, Color.red, 2);
		this.figure[1][1] = new Point_DTO(null, Color.red, 2);
		this.figure[1][2] = null;

		this.pointr = 2;
		this.pointd = 1;
		
	}
	
}
