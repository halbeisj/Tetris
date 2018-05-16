package data;

import java.awt.Color;
import java.awt.Point;

public class Figure_I extends Figure {
	
	public Figure_I() {
		this.appereance = new Point[][] {
				{new Point (1,0), new Point (1,1), new Point (1,2), new Point (1,3)},
				{new Point (0,1), new Point (1,1), new Point (2,1), new Point (3,1)},
				{new Point (2,0), new Point (2,1), new Point (2,2), new Point (2,3)},
				{new Point (0,2), new Point (1,2), new Point (2,2), new Point (2,3)}
		};
		
		this.color = Color.YELLOW;
	}
	
	
	
	
}
