package tests.entities;

import junit.framework.TestCase;
import kabasuji.entities.LightningBoardTile;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.PuzzleBoardTile;
import kabasuji.entities.ReleaseBoardTile;
import kabasuji.entities.Tile;
import kabasuji.entities.UnplayableTile;

public class TestTiles extends TestCase {

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
	
	public void testUnplayable(){
		
		Tile t1 = new UnplayableTile(0, 0);
		
		assertTrue(t1.isCovered());
		t1.uncover();
		assertTrue(t1.isCovered());
		t1.cover();
		assertTrue(t1.isCovered());
	}
	
	public void testPieceTile(){	
		PieceTile t2 = new PieceTile(1, 1);
		
		assertEquals(1, t2.getRow());
		t2.setRow(2);
		assertEquals(2, t2.getRow());
		assertEquals(1, t2.getColumn());
		t2.setColumn(3);
		assertEquals(3, t2.getColumn());
	}
	
	public void testPuzzleBoardTile() {
		PuzzleBoardTile t3 = new PuzzleBoardTile(2, 2);
		
		assertFalse(t3.isCovered());
		t3.cover();
		assertTrue(t3.isCovered());
		t3.uncover();
		assertFalse(t3.isCovered());
		
		t3.coveringPiece(testPiece, 1);
		assertEquals(testPiece, t3.getCoveringPiece());
		assertEquals(1, t3.getPieceTileIdx());
		
	}
	
	public void testLightningBoardTile() {
		LightningBoardTile t4 = new LightningBoardTile(3, 3);
		assertFalse(t4.isCovered());
		assertFalse(t4.isMarked());
		
		t4.cover();
		t4.mark();
		
		assertFalse(t4.isCovered());
		assertTrue(t4.isMarked());
		
		t4.uncover();
		t4.unmark();
		
		assertFalse(t4.isCovered());
		assertFalse(t4.isMarked());
	}
	
	public void testReleaseBoardTile(){
		ReleaseBoardTile t5 = new ReleaseBoardTile(4, 4);
		assertEquals(0, t5.getValue());
		assertEquals(0, t5.getNumColor());
		assertFalse(t5.isCovered());
		
		t5.cover();
		assertTrue(t5.isCovered());
		
		t5.uncover();
		assertFalse(t5.isCovered());
		
		t5.updateReleaseNum();
		assertEquals(1, t5.getValue());
		t5.updateReleaseNum();
		assertEquals(2, t5.getValue());
		t5.updateReleaseNum();
		assertEquals(3, t5.getValue());
		t5.updateReleaseNum();
		assertEquals(4, t5.getValue());
		t5.updateReleaseNum();
		assertEquals(5, t5.getValue());
		t5.updateReleaseNum();
		assertEquals(0, t5.getValue());
		
		t5.updateReleaseColor();
		assertEquals(1, t5.getNumColor());
		t5.updateReleaseColor();
		assertEquals(2, t5.getNumColor());
		t5.updateReleaseColor();
		assertEquals(0, t5.getNumColor());
	}

}
