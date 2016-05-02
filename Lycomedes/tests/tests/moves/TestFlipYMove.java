package tests.moves;

import junit.framework.TestCase;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseLevel;
import kabasuji.moves.FlipYMove;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;

/**
 * Test cases flipping a piece over the Y axis.
 * Test an attempt on each kind of level.
 *  
 * @author Ian Jacoway
 *
 */

public class TestFlipYMove extends TestCase {
	SuperModel sm;
	Level pl, ll, rl;
	int row = 0;
	int col = 0;
	Piece testPiece;
	PieceTile[] arr;
	Piece dummy;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		/** Set up super model and level. */
		sm = new SuperModel();
		pl = new PuzzleLevel("SoPuzzled");
		ll = new LightningLevel("TestLights");
		rl = new ReleaseLevel("ReleaseProcrastination");
		
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
		
		/** Set up a BoardTile for each. */	
		pl.getBoard().createBoardTile(0, 0, "Puzzle");
		ll.getBoard().createBoardTile(0, 0, "Lightning");
		rl.getBoard().createBoardTile(0, 0, "Release");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testBullpenToBoardPL(){
		sm.setActiveLevel(pl);
		pl.getBoard().createBoardTile(0, 0, "Puzzle");
		pl.getBoard().createBoardTile(1, 0, "Puzzle");
		pl.getBoard().createBoardTile(2, 0, "Puzzle");
		pl.getBoard().createBoardTile(3, 0, "Puzzle");
		pl.getBoard().createBoardTile(4, 0, "Puzzle");
		pl.getBoard().createBoardTile(5, 0, "Puzzle");
		
		/** Check names. */
		assertEquals("SoPuzzled", pl.getLevelName());
		
		// Set test piece as selected FOR REAL who knows which is which
		pl.setActivePiece(testPiece);
		pl.setSelected(testPiece);
		pl.setSelectedPiece(testPiece);
		
		/** Activate tile in row 0 col 0 piece in Board on row 1 col 1. */
		Move plm = new FlipYMove(pl);
	
		/** Test on Puzzle Level. */
		sm.setActiveLevel(pl);
		pl.setLevelType("Puzzle");
		assertEquals("SoPuzzled", pl.getLevelName());
		assertTrue(plm.valid());
		assertTrue(plm.execute());
		assertTrue(plm.undo());
	}

	public void testBullpenToBoardLL(){
		sm.setActiveLevel(ll);
		ll.getBoard().createBoardTile(0, 0, "Lightning");
		ll.getBoard().createBoardTile(1, 0, "Lightning");
		ll.getBoard().createBoardTile(2, 0, "Lightning");
		ll.getBoard().createBoardTile(3, 0, "Lightning");
		ll.getBoard().createBoardTile(4, 0, "Lightning");
		ll.getBoard().createBoardTile(5, 0, "Lightning");
		
		/** Check names. */
		assertEquals("TestLights", ll.getLevelName());
		
		// Set test piece as selected FOR REAL who knows which is which
		ll.setActivePiece(testPiece);
		ll.setSelected(testPiece);
		ll.setSelectedPiece(testPiece);
		
		/** Activate tile in row 0 col 0 piece in Board on row 1 col 1. */
		Move llm = new FlipYMove(ll);
	
		/** Test on Lightning Level with LightningType. */
		sm.setActiveLevel(ll);
		ll.setLevelType("Lightning");
		assertEquals("TestLights", ll.getLevelName());
		assertTrue(llm.valid());
		assertTrue(llm.execute());
		assertTrue(llm.undo());
	}
	
	public void testBullpenToBoardRL(){
		sm.setActiveLevel(rl);
		rl.getBoard().createBoardTile(0, 0, "Release");
		rl.getBoard().createBoardTile(1, 0, "Release");
		rl.getBoard().createBoardTile(2, 0, "Release");
		rl.getBoard().createBoardTile(3, 0, "Release");
		rl.getBoard().createBoardTile(4, 0, "Release");
		rl.getBoard().createBoardTile(5, 0, "Release");
		
		/** Check names. */
		assertEquals("ReleaseProcrastination", rl.getLevelName());
		
		// Set test piece as selected FOR REAL who knows which is which
		rl.setActivePiece(testPiece);
		rl.setSelected(testPiece);
		rl.setSelectedPiece(testPiece);
		
		/** Activate tile in row 0 col 0 piece in Board on row 1 col 1. */
		Move rlm = new FlipYMove(rl);
	
		/** Test on Release Level with ReleaseType. */
		sm.setActiveLevel(rl);
		rl.setLevelType("Release");
		assertEquals("ReleaseProcrastination", rl.getLevelName());
		assertTrue(rlm.valid());
		assertTrue(rlm.execute());
		assertTrue(rlm.undo());
	}
	
	public void testNULLPiece(){
		Piece dummy = null;
		pl.setActivePiece(dummy);
		pl.setSelected(dummy);
		pl.setSelectedPiece(dummy);
		Move m = new FlipYMove(pl);
		assertNull(dummy);
		assertFalse(m.valid());
	}
}
