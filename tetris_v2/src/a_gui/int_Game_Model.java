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
public void setName(String name);
}