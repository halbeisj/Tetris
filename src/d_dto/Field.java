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
	 * 
	 * @todo Zu Enum umwandeln.
	 */
	private int state;
	
	/**
	 * Initialisiert ein neues Objekt der {@link Field} Klasse.
	 * 
	 * @param color
	 * Die Farbe des Feldes.
	 * 
	 * @param state
	 * Der Status des Feldes.
	 * @todo Zu Enum umwandeln.
	 */
	public Field(Color color, int state) {
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
	 * @todo Zu Enum umwandeln.
	 */
	public int getState(){
		return this.state;
	}
	
	/**
	 * Setzt den Status des Feldes.
	 * @todo Zu Enum umwandeln.
	 */
	public void setState(int value){
		this.state = value;
	}
}
