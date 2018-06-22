package a_gui;

import d_dto.Point_DTO;

/**Dies ist das Interface des Game Models.
 * Über diese Klasse wird auf das Game_Model zugegriffen.
 * 
 * @author Julia Halbeisen
 * @author Dominik Heckendorn
 * @version 1.0
 * */
public interface int_Game_Model {
public void reloadField(Point_DTO[][] field);
public void init(String name);
public int getLevel();
public int getTime();
public String getName();
public int getLines();
public Point_DTO getPoint(int x, int y);
}