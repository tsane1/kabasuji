package kabasuji.entities;
/**
 * Tile subclass that represents an unplayable boundary of the board
 * @author Michael
 *
 */
public class UnplayableTile extends Tile {
	
	/**
	 * serial Id for puzzleboardtile
	 */
	private static final long serialVersionUID = 684927514430563777L;
	int row, col;
	private boolean covered;
	
	public UnplayableTile(int row, int col) {
		super(row, col);
		
		this.row = row;
		this.col = col;
		covered = true;
	}
	
	public void cover(){
		covered = true;
	}
	
	public void uncover(){
		covered = true;
	}
	
	public boolean isCovered(){
		return covered;
	}
}
