package dataTransferObject;

import java.awt.Color;
import java.awt.Point;

import data.Figure;

public class DTO_Figure extends Figure {
	public Point[][] getAppereance() {
		return this.appereance;
	}
	
	public Color getColor() {
		return this.color;
	}
}
