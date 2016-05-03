package tests.entities;

import java.awt.Point;
import java.util.Arrays;

import junit.framework.TestCase;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;

/**
 * JUnit test suite to test the Piece entitiy. 
 * @author Derek McMaster
 * 
 * 
 * 
 * 
 * 
 * 
 * Fixed commented out code. 
 * 
 * 
 *
 */
public class TestPiece extends TestCase {

	Piece testPiece;
	PieceTile[] arr;
	
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
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPieceClass() {
		
		/** Test attributes of a piece */
		assertEquals("Piece 1", testPiece.getPieceName());
		assertEquals(1, testPiece.getPieceID());
		assertEquals(6, testPiece.numTilesInPiece());
		//assertTrue(Arrays.deepEquals(arr, testPiece.getTileLocations()));
	}
	
	public void testMapfunctions(){
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
		
		Piece testPiece3 = new Piece(1, arr);
		
		assertTrue(testPiece.equals(testPiece3));
		
		assertEquals(testPiece3.hashCode(), testPiece3.getPieceID());
	}
	
	public void testPoisitionAndContains() {

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
		
		assertFalse(testPiece.equals(testPiece2));
		
		testPiece.setPiecePosition(0, 1);
		
		Point pt = new Point(0,1);
		
		assertEquals(pt, testPiece.getPiecePosition());
		
		assertTrue(testPiece.contains(30, 0));
		
		assertTrue(testPiece.containsy(25, 0));
		
		assertFalse(testPiece.contains(250, 0));
		
		assertFalse(testPiece.containsy(250, 0));
		
		
	}

}
