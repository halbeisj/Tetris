package d_dto;

import java.awt.Color;
import java.awt.Point;

/**
 * Repräsentiert eine einzelnes Feld auf dem Spielfeld.
 * 
 * @author Julia Halbeisen
 * */
public class Point_DTO {
	/**
	 * Punkt auf dem ganzen Feld (NICHT IN DER FIGUR!)
	 * 
	 * @todo Löschen.
	 */
	private Point point;
	
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
	 * Initialisiert ein neues Objekt der {@link Point_DTO} Klasse.
	 * 
	 * @param point
	 * @todo Löschen.
	 * 
	 * @param color
	 * Die Farbe des Feldes.
	 * 
	 * @param status
	 * Der Status des Feldes.
	 * @todo Zu Enum umwandeln.
	 */
	public Point_DTO(Point point, Color color, int status) {
		this.point = point;
		this.color = color;
		this.status = status;
	}
	
	/**
	 * Diese Methode gibt den Punkt zurück, für welchen die weiteren Einstellungen gelten.
	 * 
	 * @return Point, welcher konfiguriert wird
	 * 
	 * @todo Löschen.
	 * */
	public Point getPoint(){
		return this.point;
	}
	
	/**
	 * Mit dieser Methode kann konfiguriert werden, für welchen Punkt die Einstellungen gelten.
	 * 
	 * @param Point, für welchen die Einstellungen gelten
	 * 
	 * @todo Löschen.
	 * */
	public void setPoint(Point point){
		this.point = point;
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
