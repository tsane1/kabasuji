package kabasuji.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Board implements Serializable{
	private int rows[], cols[];
	private Tile boardArray[][]; //needs to be initialized
	private ArrayList<Piece> placedPieces;
	
	public Board() {
		this.rows = new int[12];
		this.cols = new int[12];
		this.placedPieces = new ArrayList<Piece>();
		
	}
	//creates a tile that can be played on at the given grid location in the 12x12
	public void createBoardTile(int row, int col, String type){
		if(type.equals("puzzle")){
			boardArray[row][col] = new PuzzleBoardTile(row, col);
		}else if(type.equals("lightning")){
			boardArray[row][col] = new LightningBoardTile(row, col);
		}else{
			boardArray[row][col] = new ReleaseBoardTile(row, col);
		}
	}
	//places piece at the specified grid location
	public boolean place(int row, int col, Piece piece) {
		//need to check if place is covered both the release points and where pieces tiles move to after that
		//probably piece.tiles[0].row + row and piece.tiles[0].col + col.... where .row and .col have been updated to reflect the release point
		//if extension of the piece is ever out of bounds return widget and throw exception, but if lightning just mark tiles in bounds
		if(!boardArray(row,col,piece)){
			//add piece to list of placed pieces
			placedPieces.add(piece);
			//covers the place 
			boardArray[row][col].cover();
			//use row and col to tell piece where it is located on the board
			
			
			return true;
		}else{
			//throw? or boolean like now that says place failed
			return false;
		}
		
	}
	
	
	
}
