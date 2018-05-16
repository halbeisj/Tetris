package data;

import java.util.ArrayList;

import dataTransferObject.DTO_Figure;

public class Storage_Figure implements IStorage_Figure{
	
	private ArrayList<DTO_Figure> figures = new ArrayList<DTO_Figure>();

	@Override
	public DTO_Figure getFigure(int i) {
		return this.figures.get(i);
	}
}
