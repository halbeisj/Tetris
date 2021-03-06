package c_db;

import java.awt.Color;

import d_dto.Field;
import d_dto.FieldState;

/**
 * Repräsentiert eine Figur, welche ein "I" darstellt.
 * 
 * @author Julia Halbeisen
 */
public class IFigure extends Figure {
	/**
	 * Initialisiert eine neue Instanz der {@link IFigure} Klasse.
	 */
	public IFigure() {
		this.figure = new Field[4][1];
		this.figure[0][0] = new Field(Color.white, FieldState.Temporary);
		this.figure[1][0] = new Field(Color.white, FieldState.Temporary);
		this.figure[2][0] = new Field(Color.white, FieldState.Temporary);
		this.figure[3][0] = new Field(Color.white, FieldState.Temporary);

		this.pointr = 1;
		this.pointd = 4;
	}

}
