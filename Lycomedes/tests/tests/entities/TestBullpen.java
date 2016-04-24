package tests.entities;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import kabasuji.entities.Bullpen;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;

public class TestBullpen extends TestCase {

	Piece testPiece;
	PieceTile[] arr;
	Bullpen bp;
	Bullpen bp2;
	ArrayList<Piece> temp;
	
	protected void setUp() throws Exception {
		super.setUp();
		
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
		temp = new ArrayList<Piece>();
		temp.add(testPiece);
		bp = new Bullpen();
		bp2 = new Bullpen(temp);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testBullpen(){
		
		//initially bp should be empty, bp2 should contain testPiece
		assertTrue(bp.isEmpty());
		assertFalse(bp2.isEmpty());
		
		assertTrue(bp.addPiece(testPiece));
		assertFalse(bp.isEmpty());
		
		assertTrue(bp.removePiece(testPiece));
		assertTrue(bp.isEmpty());
		
		assertTrue(bp.addPieces(temp));
		assertFalse(bp.isEmpty());
		
		List<Piece> ta = bp.getPieces();
		
		assertEquals(ta, temp);
		
		List<Piece> emptyList = new ArrayList<Piece>();
		
		assertEquals(emptyList, bp.getPlayedPieces());
		
		assertTrue(bp.setPieceAsPlayed(testPiece));
		assertFalse(bp.getPlayedPieces().isEmpty());
	}

}
