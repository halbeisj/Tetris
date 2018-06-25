package c_db;

import java.awt.Color;

import d_dto.Point_DTO;

/**Hier wird die Figur J erstellt, diese Klasse erbt von der Klasse Figure.
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public class Figure_J extends Figure{
	public Figure_J() {
	this.figure = new Point_DTO[3][2];
	this.figure[0][1] = new Point_DTO(null, Color.pink, 2);
	this.figure[1][1] = new Point_DTO(null, Color.pink, 2);
	this.figure[2][1] = new Point_DTO(null, Color.pink, 2);
	this.figure[2][0] = new Point_DTO(null, Color.pink, 2);
	this.figure[0][0] = null;
	this.figure[1][0] = null;
	
	this.pointl = 0;
	this.pointr = 1;
	this.pointd = 2;

	
	}

}
