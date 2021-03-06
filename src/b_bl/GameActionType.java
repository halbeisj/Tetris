package b_bl;

/**
 * Repräsentiert ein Aktions-Typ des Spiels. 
 * 
 * @author Julia Halbeisen
 */
public enum GameActionType {
	/**
	 * Kennzeichnet ein Update.
	 */
	Update,
	
	/**
	 * Kennzeichnet, dass eine Figur bewegt wurde.
	 */
	MoveFigure,
	
	/**
	 * Kennzeichnet, dass der Spieler verloren hat.
	 */
	Lost
}
