package c_db;

import java.awt.Color;

import d_dto.Field;
import d_dto.FieldState;

/**
 * Repräsentiert eine Figur, welche eine spiegelferkerte Version von
 * {@link LFigure} darstellt.
 * 
 * @author Julia Halbeisen
 */
public class JFigure extends Figure {
	/**
	 * Initialisiert eine neue Instanz der {@link JFigure} Klasse.
	 */
	public JFigure() {
		this.figure = new Field[3][2];
		this.figure[0][1] = new Field(Color.pink, FieldState.Temporary);
		this.figure[1][1] = new Field(Color.pink, FieldState.Temporary);
		this.figure[2][1] = new Field(Color.pink, FieldState.Temporary);
		this.figure[2][0] = new Field(Color.pink, FieldState.Temporary);
		
		this.pointr = 2;
		this.pointd = 3;
	}
}
