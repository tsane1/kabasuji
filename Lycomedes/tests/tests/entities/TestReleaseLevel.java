package tests.entities;

import junit.framework.TestCase;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.ReleaseLevel;

public class TestReleaseLevel extends TestCase {

	ReleaseLevel testLevel;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		testLevel = new ReleaseLevel("test");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testReleaseChars(){
		assertEquals("test", testLevel.getLevelName());
		
		assertEquals("Release", testLevel.getLevelType());
		
		assertTrue(testLevel.getNumsCollectedByColor("red").isEmpty());
		assertTrue(testLevel.getNumsCollectedByColor("yellow").isEmpty());
		assertTrue(testLevel.getNumsCollectedByColor("green").isEmpty());
		assertNull(testLevel.getNumsCollectedByColor("notacolor"));
		
		testLevel.collect("red", 1);
		testLevel.collect("yellow", 1);
		testLevel.collect("green", 1);
		testLevel.collect("Notacolor", 4);
		
		assertFalse(testLevel.getNumsCollectedByColor("red").isEmpty());
		assertFalse(testLevel.getNumsCollectedByColor("yellow").isEmpty());
		assertFalse(testLevel.getNumsCollectedByColor("green").isEmpty());
		
		assertTrue(testLevel.getBullpen().isEmpty());
		assertTrue(testLevel.hasEnded());
		
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
		
		testLevel.getBullpen().addPiece(testPiece);
		
		assertFalse(testLevel.getBullpen().isEmpty());
		assertFalse(testLevel.hasEnded());
		assertFalse(testLevel.hasWon());
	}

}
