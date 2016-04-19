package kabasuji.entities;

import java.io.Serializable;

/**
 * Tile Subclass which will make up the pieces.
 */
public class PieceTile extends Tile implements Serializable{

	int row;
	int col;
	
	public PieceTile(int row, int column) {
		super(row, column);
		
		this.row = row;
		this.col = column;
	}

	public void setRow(int row) {
		this.row = row;
	}
	public int getRow(){
		return row;
	}
	
	public void setColumn(int col){
		this.col = col;
	}
	public int getColumn(){
		return col;
	}
}
