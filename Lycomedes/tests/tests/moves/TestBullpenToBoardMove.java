package tests.moves;

import java.awt.Point;

import junit.framework.TestCase;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseLevel;
import kabasuji.moves.BullpenToBoardMove;
import kabasuji.moves.SelectTileMove;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;

/**
 * Test cases involving a single piece moved to the Board. 
 * Also some general level tests. Tests that a null piece is invalid as well.
 * Test saving/Loading a level.
 * 
 * ***Also I had to test SelectTileMove here, in order to place a piece on the board***.
 * 
 * @author Ian Jacoway
 *
 */

public class TestBullpenToBoardMove extends TestCase {
	SuperModel sm;
	Level pl, ll, rl;
	Point p0, p1, p2, p3, p4, p5, p6;
	Piece testPiece;
	PieceTile[] arr;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		/** set up super model and level*/
		sm = new SuperModel();
		pl = new PuzzleLevel("P_testyd");
		ll = new LightningLevel("L_testyd");
		rl = new ReleaseLevel("R_testyd");
		
		/** Set up a test piece. */
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
		
		/** Set up a test Tiles. */
		testPiece = new Piece(1, arr);
		
		/** Set up Points. */
		p0 = new Point(1,1);
		p1 = new Point(55,1);
		p2 = new Point(70,1);
		p3 = new Point(100,1);
		p4 = new Point(132,1);
		p5 = new Point(164,1);
		p6 = new Point(1, 55);
		
		/** Select test Tiles. */
		Move stm0 = new SelectTileMove(pl, p0);
		stm0.execute();
		Move stm1 = new SelectTileMove(pl, p1);
		stm1.execute();
		Move stm2 = new SelectTileMove(pl, p2);
		stm2.execute();
		Move stm3 = new SelectTileMove(pl, p3);
		stm3.execute();
		Move stm4 = new SelectTileMove(pl, p4);
		stm4.execute();
		Move stm5 = new SelectTileMove(pl, p5);
		stm5.execute();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSelectTileMove(){
		Move desel = new SelectTileMove(pl,p6);
		assertTrue(desel.valid());
		assertTrue(desel.execute());
		assertTrue(desel.undo());
	}
	
	public void testBullpenToBoardPL(){
		sm.setActiveLevel(pl);
		pl.getBoard().createBoardTile(0, 0, "Puzzle");
		pl.getBoard().createBoardTile(1, 0, "Puzzle");
		pl.getBoard().createBoardTile(2, 0, "Puzzle");
		pl.getBoard().createBoardTile(3, 0, "Puzzle");
		pl.getBoard().createBoardTile(4, 0, "Puzzle");
		pl.getBoard().createBoardTile(5, 0, "Puzzle");
		
		String dir = sm.getUserLevelDir();
		String plname = pl.getLevelName();
		assertEquals("P_testyd", pl.getLevelName());
		
		// Set test piece as selected FOR REAL who knows which is which
		pl.setActivePiece(testPiece);
		pl.setSelected(testPiece);
		pl.setSelectedPiece(testPiece);
		
		// Place piece in Board on row 1 col 1
		Move m = new BullpenToBoardMove(sm, 0, 0);
		
		assertTrue(m.valid());
		assertTrue(pl.addPieceToAllPieces(testPiece));
		pl.addMoveToUndo(m);
		assertEquals(pl.peekLastMove(), m);
		pl.addRedoableMove(m);
		assertEquals(pl.peekRedoMove(), m);
		assertFalse(m.execute());
//		assertTrue(m.undo());
		
		// Test saving & loading!!
		pl.setLevelName("tteVsted");
		plname = "tteVsted.lev";
		pl.saveLevel(dir);
		sm.loadLevel(dir, plname);
		
		// Validated by not throwing an exception
		sm.deleteLevel(dir, plname);
	}
	
	public void testBullpenToBoardLL(){
		sm.setActiveLevel(ll);
		ll.getBoard().createBoardTile(0, 0, "Lightning");
		ll.getBoard().createBoardTile(1, 0, "Lightning");
		ll.getBoard().createBoardTile(2, 0, "Lightning");
		ll.getBoard().createBoardTile(3, 0, "Lightning");
		ll.getBoard().createBoardTile(4, 0, "Lightning");
		ll.getBoard().createBoardTile(5, 0, "Lightning");
		
		String dir = sm.getUserLevelDir();
		String llname = ll.getLevelName();
		assertEquals("L_testyd", ll.getLevelName());
		
		// Set test piece as selected FOR REAL who knows which is which
		ll.setActivePiece(testPiece);
		ll.setSelected(testPiece);
		ll.setSelectedPiece(testPiece);
		
		// Place piece in Board on row 1 col 1
		Move m = new BullpenToBoardMove(sm, 0, 0);
		
		assertTrue(m.valid());
		assertTrue(ll.addPieceToAllPieces(testPiece));
		ll.addMoveToUndo(m);
		assertEquals(ll.peekLastMove(), m);
		ll.addRedoableMove(m);
		assertEquals(ll.peekRedoMove(), m);
//		assertTrue(m.execute());
//		assertTrue(m.undo());
		
		// Test saving & loading!!
		ll.setLevelName("tteVsted");
		llname = "tteVsted.lev";
		ll.saveLevel(dir);
		sm.loadLevel(dir, llname);
		
		// Validated by not throwing an exception
		sm.deleteLevel(dir, llname);
	}
	
	public void testBullpenToBoardRL(){
		sm.setActiveLevel(rl);
		rl.getBoard().createBoardTile(0, 0, "Release");
		rl.getBoard().createBoardTile(1, 0, "Release");
		rl.getBoard().createBoardTile(2, 0, "Release");
		rl.getBoard().createBoardTile(3, 0, "Release");
		rl.getBoard().createBoardTile(4, 0, "Release");
		rl.getBoard().createBoardTile(5, 0, "Release");
		
		String dir = sm.getUserLevelDir();
		String rlname = rl.getLevelName();
		assertEquals("R_testyd", rl.getLevelName());
		
		// Set test piece as selected FOR REAL who knows which is which
		rl.setActivePiece(testPiece);
		rl.setSelected(testPiece);
		rl.setSelectedPiece(testPiece);
		
		// Place piece in Board on row 1 col 1
		Move m = new BullpenToBoardMove(sm, 0, 0);
		
		assertTrue(m.valid());
		assertTrue(rl.addPieceToAllPieces(testPiece));
		rl.addMoveToUndo(m);
		assertEquals(rl.peekLastMove(), m);
		rl.addRedoableMove(m);
		assertEquals(rl.peekRedoMove(), m);
//		assertTrue(m.execute());
//		assertTrue(m.undo());
		
		// Test saving & loading!!
//		int before = sm.getNumUserLevels();
		rl.setLevelName("tteVsted");
		rlname = "tteVsted.lev";
		rl.saveLevel(dir);
		sm.loadLevel(dir, rlname);
		
//		assertEquals(before+1, sm.getNumUserLevels());
//		assertEquals(2, sm.getNumUserLevels());
		// Validated by not throwing an exception
		sm.deleteLevel(dir, rlname);
//		assertEquals(before, sm.getTotalNumLevels()); 
	}
	
	public void testNULLPiece(){
		Piece dummy = null;
		pl.setActivePiece(dummy);
		pl.setSelected(dummy);
		pl.setSelectedPiece(dummy);
		Move m = null;
		try{
			m = new BullpenToBoardMove(sm, 0, 0);
			fail( "Missing exception" );
		} catch( NullPointerException e ) {
		}
		assertNull(dummy);
		try{
			assertFalse(m.valid());
			fail( "Missing exception" );
		} catch( NullPointerException e ) {
//			assertEquals( "Expected message", e.getMessage() ); // Optionally make sure you get the correct message, too
		}
	}
}
