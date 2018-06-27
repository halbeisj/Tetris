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
	private int status;
	
	/**
	 * Initialisiert ein neues Objekt der {@link Field} Klasse.
	 * 
	 * @param color
	 * Die Farbe des Feldes.
	 * 
	 * @param status
	 * Der Status des Feldes.
	 * @todo Zu Enum umwandeln.
	 */
	public Field(Color color, int status) {
		this.color = color;
		this.status = status;
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
	public void setColor(Color color){
		this.color = color;
	}
	
	/**
	 * Gibt den Status des Feldes zurück.
	 * @todo Zu Enum umwandeln.
	 */
	public int getStatus(){
		return this.status;
	}
	
	/**
	 * Setzt den Status des Feldes.
	 * @todo Zu Enum umwandeln.
	 */
	public void setStatus(int status){
		this.status = status;
	}
	

}
