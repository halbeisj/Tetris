package d_dto;

/**
 * Repr�sentiert den Zustand eines {@link Field}s.
 * 
 * @author Julia Halbeisen
 */
public enum FieldState {
	/**
	 * Kennzeichnet ein freies Feld.
	 */
	Free,
	
	/**
	 * Kennzeichnet ein tempor�r besetztes Feld.
	 */
	Temporary,
	
	/**
	 * Kennzeichnet ein besetztes Feld.
	 */
	Taken
}
