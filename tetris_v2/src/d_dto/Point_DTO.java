package d_dto;

import java.awt.Color;
import java.awt.Point;

/**
 * Diese Klasse wiederspiegelt einen Punkt auf dem Spielfeld
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public class Point_DTO {
	/**
	 * Punkt auf dem ganzen Feld (NICHT IN DER FIGUR!)
	 */
	private Point point;
	private Color color;
	private int status;
	
	public Point_DTO(Point point, Color color, int status) {
		this.point = point;
		this.color = color;
		this.status = status;
	}
	
	/**
	 * Diese Methode gibt den Punkt zurück, für welchen die weiteren Einstellungen gelten.
	 * 
	 * @return Point, welcher konfiguriert wird
	 * */
	public Point getPoint(){
		return this.point;
	}
	
	/**
	 * Mit dieser Methode kann konfiguriert werden, für welchen Punkt die Einstellungen gelten.
	 * 
	 * @param Point, für welchen die Einstellungen gelten
	 * */
	public void setPoint(Point point){
		this.point = point;
	}
	
	/**
	 * Diese Methode gibt die Farbe des Punktes zurück
	 * 
	 * @return Color des Punktes
	 * */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * Mit dieser Methode kann die Farbe des Punktes konfiguriert werden.
	 * 
	 * @param Color, welche konfiguriert werden soll
	 * */
	public void setColor(Color color){
		this.color = color;
	}
	
	/**
	 * Diese Methode gibt den Status (frei(0), besetzt(1), temp(2)) des Punktes zurück
	 * 
	 * @return Status des Punktes
	 * */
	public int getStatus(){
		return this.status;
	}
	
	/**
	 * Diese Methode setzt den Status (frei(0), besetzt(1), temp(2)) des Punktes
	 * 
	 * @param Status, welcher konfiguriert werden soll
	 * */
	public void setStatus(int status){
		this.status = status;
	}
	

}
