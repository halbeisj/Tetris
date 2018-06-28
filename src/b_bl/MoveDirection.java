package b_bl;

import c_db.Figure;

/**
 * Repräsentiert eine Richtung, in die eine {@link Figure} verschoben werden kann.
 * 
 * @author Julia Halbeisen
 */
public enum MoveDirection {
	/**
	 * Kennzeichnet keine Verschiebung.
	 */
	None,
	
	/**
	 * Kennzeichnet eine Verschiebung nach links.
	 */
	Left,
	
	/**
	 * Kennzeichnet eine Verschiebung nach rechts.
	 */
	Right,
	
	/**
	 * Kennzeichnet eine Verschiebung nach unten.
	 */
	Down
}
