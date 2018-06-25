package a_gui;

import java.awt.Point;
import java.util.Observer;

import d_dto.Point_DTO;

/**Dies ist das Interface des Game Models.
 * Über diese Klasse wird auf das Game_Model zugegriffen.
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public interface int_Game_Model {
public void reloadField(Point_DTO[][] field, int inc);
public void init(String name);
public String getLevel();
public int getTime();
public String getName();
public String getLines();
public Point_DTO getPoint(int x, int y);
public void reloadNextFigure(Point_DTO[][] nextFigure);
public Point_DTO getPointNextFigure(int x, int y);
public Point getNextFigureSize();
public void addObserver(Observer o);
}