package kabasuji.entities;

import junit.framework.TestCase;
import kabasuji.supers.*;

public class testPlacePiece extends TestCase {
	
	Model model;
	Bullpen bullpen;
	Board board;
	protected void setUp() {
		
		model = new Model();
		bullpen = new Bullpen();
		board = new Board();
		
		for(int idx = 0; idx<= 5; idx++){
			bullpen.addPiece(model.getAllPieces().get(idx));
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
			assertEquals(true, board.getPlacedPieces().contains(testPiece));
		}else{
			System.err.println("place returned false");
		}
		Piece testPiece2 = bullpen.getPieces().get(2);
		bullpen.removePiece(testPiece2);
		assertEquals(false, board.place(2, 3, testPiece2));
		
	}
}
