package c_db;

import java.awt.Color;

import d_dto.Point_DTO;

/**Hier wird die Figur L erstellt, diese Klasse erbt von der Klasse Figure.
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public class Figure_L extends Figure{
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