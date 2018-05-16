package data;

import java.util.ArrayList;

public class Storage_Figure implements IStorage_Figure{
	
	private ArrayList<Figure> figures = new ArrayList<Figure>();

	@Override
	public Figure getFigure(int i) {
		return this.figures.get(i);
	}

	@Override
	public void initialize() {
		figures.add(new Figure_I());
		figures.add(new Figure_T());
	}
}
