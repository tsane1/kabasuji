package tests.entities;

import junit.framework.TestCase;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;

public class TestPiece extends TestCase {

	Piece testPiece;
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPieceClass() {
		
		/** set up a test piece */
		PieceTile[] arr = new PieceTile[6];
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
		
		/** Test attributes of a piece */
		assertEquals("Piece 1", testPiece.getPieceName());
		assertEquals(1, testPiece.getPieceID());
		assertEquals(6, testPiece.numTilesInPiece());
		
	}
	
	public void testFlip() {
		/** set up a test piece */
		PieceTile[] arr = new PieceTile[6];
		PieceTile pt1 = new PieceTile(5,0);
		arr[0] = pt1;
		PieceTile pt2 = new PieceTile(4,0);
		arr[1] = pt2;
		PieceTile pt3 = new PieceTile(3,0);
		arr[2] = pt3;
		PieceTile pt4 = new PieceTile(2,0);
		arr[3] = pt4;
		PieceTile pt5 = new PieceTile(1,0);
		arr[4] = pt5;
		PieceTile pt6 = new PieceTile(0,0);
		arr[5] = pt6;
		
		Piece testPiece2 = new Piece(2, arr);
		
		//assertEquals(testPiece2, testPiece.flipX());
	}

}
