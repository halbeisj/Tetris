package d_dto;

/**
 * Repräsentiert den Zustand eines {@link Field}s.
 * 
 * @author Julia Halbeisen
 */
public enum FieldState {
	/**
	 * Kennzeichnet ein freies Feld.
	 */
	Free,
	
	/**
	 * Kennzeichnet ein temporär besetztes Feld.
	 */
	Temporary,
	
	/**
	 * Kennzeichnet ein besetztes Feld.
	 */
	Taken
}
