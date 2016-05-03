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
		Piece testPiece;
		PieceTile[] arr;
		/** set up a test piece */
		arr = new PieceTile[6];
		PieceTile pt1 = new PieceTile(0,0);
		arr[0] = pt1;
		PieceTile pt2 = new PieceTile(1,0);
		arr[1] = pt2;
		PieceTile pt3 = new PieceTile(2,0);
		arr[2] = pt3;
		PieceTile pt4 = new PieceTile(3,0);
		arr[3] = pt4;
		PieceTile pt5 = new PieceTile(4,0);
		arr[4] = pt5;
		PieceTile pt6 = new PieceTile(5,0);
		arr[5] = pt6;
		
		testPiece = new Piece(1, arr);

		if(board.place(2, 3, testPiece)){
			assertEquals(true, board.getPlacedPieces().containsValue(testPiece));
		}else{
			System.err.println("place returned false");
		}

		/** set up a test piece */
		PieceTile[] arr2 = new PieceTile[6];
		PieceTile pt7 = new PieceTile(5,0);
		arr2[0] = pt7;
		PieceTile pt8 = new PieceTile(4,0);
		arr2[1] = pt8;
		PieceTile pt9 = new PieceTile(3,0);
		arr2[2] = pt9;
		PieceTile pt10 = new PieceTile(2,0);
		arr2[3] = pt10;
		PieceTile pt11 = new PieceTile(1,0);
		arr2[4] = pt11;
		PieceTile pt12 = new PieceTile(0,0);
		arr2[5] = pt12;
		
		Piece testPiece2 = new Piece(2, arr2);
		bullpen.removePiece(testPiece2);
		assertEquals(false, board.place(2, 3, testPiece2));
		
	}
}
