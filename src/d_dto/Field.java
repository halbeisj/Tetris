package d_dto;

import java.awt.Color;
import java.awt.Point;

/**
 * Repräsentiert eine einzelnes Feld auf dem Spielfeld.
 * 
 * @author Julia Halbeisen
 * */
public class Field {
	/**
	 * Die Farbe des Feldes.
	 */
	private Color color;
	
	/**
	 * Der Status des Feldes.
	 */
	private FieldState state;
	
	/**
	 * Initialisiert ein neues Objekt der {@link Field} Klasse.
	 * 
	 * @param color
	 * Die Farbe des Feldes.
	 * 
	 * @param state
	 * Der Status des Feldes.
	 */
	public Field(Color color, FieldState state) {
		this.color = color;
		this.state = state;
	}
	
	/**
	 * Gibt die Farbe des Feldes zurück.
	 */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * Setzt die Farbe des Feldes.
	 */
	public void setColor(Color value){
		this.color = value;
	}
	
	/**
	 * Gibt den Status des Feldes zurück.
	 */
	public FieldState getState(){
		return this.state;
	}
	
	/**
	 * Setzt den Status des Feldes.
	 */
	public void setState(FieldState value){
		this.state = value;
	}
}
