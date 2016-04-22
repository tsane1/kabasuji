package kabasuji.supers;

/**
 * <b>SUPER</b>
 * <p>
 * 
 * </p>
 * @author Tanuj Sane
 *
 */
public abstract class Move {
	public Move() {
		
	}
	
	public abstract boolean execute();
	
	public abstract boolean undo();
	
	public abstract boolean valid();
}
