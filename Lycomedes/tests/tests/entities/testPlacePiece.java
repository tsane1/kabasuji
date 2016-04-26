package tests.entities;

import junit.framework.TestCase;
import kabasuji.supers.*;
import kabasuji.entities.*;

public class testPlacePiece extends TestCase {
	
	Level level;
	Bullpen bullpen;
	Board board;
	protected void setUp() {
		
		level = new PuzzleLevel("Test");
		bullpen = new Bullpen();
		board = new Board();
		
		for(int idx = 0; idx<= 5; idx++){
			//bullpen.addPiece(level.getAllPieces().get(idx));
		}
		//creates a square of size x size
		int size = 12;
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size; j++){
				board.createBoardTile(i, j, "puzzle");
			}
		}
		
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPlace(){
		//grab piece in second indices
		Piece testPiece = bullpen.getPieces().get(4);
		bullpen.removePiece(testPiece);
		if(board.place(2, 3, testPiece)){
			assertEquals(true, board.getPlacedPieces().containsValue(testPiece));
		}else{
			System.err.println("place returned false");
		}
		Piece testPiece2 = bullpen.getPieces().get(2);
		bullpen.removePiece(testPiece2);
		assertEquals(false, board.place(2, 3, testPiece2));
		
	}
}
