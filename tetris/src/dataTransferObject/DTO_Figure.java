package dataTransferObject;

import java.awt.Color;
import java.awt.Point;

import data.Figure;

public class DTO_Figure extends Figure {
	public Point[] getAppereance() {
		Point[] appear = new Point[4];
		for (int i = 0; i < appear.length; i++) {
			appear[i] = this.appereance[rotation % 4][i];
		}
		return appear;
	}
	
	public Color getColor() {
		return this.color;
	}
}
