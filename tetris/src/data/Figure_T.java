package data;

import java.awt.Color;
import java.awt.Point;

public class Figure_T extends Figure {
	
	public Figure_T() {
		this.appereance = new Point[][] {
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
		};
		
		this.color = Color.BLUE;
	}
	
	
	
	
}
