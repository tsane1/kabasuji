package tests.moves;

import java.awt.Point;

import junit.framework.TestCase;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseLevel;
import kabasuji.moves.IncrementReleaseTileMove;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;

/**
 * Test cases involving changing the Release Tile's number.
 * Test an attempt on each kind of level.
 *  
 * @author Ian Jacoway
 *
 */

public class TestIncrementReleaseTileMove extends TestCase {
	SuperModel sm;
	Level pl, ll, rl;
	Point p;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		/** Set up super model and level. */
		sm = new SuperModel();
		pl = new PuzzleLevel("SoPuzzled");
		ll = new LightningLevel("TestLights");
		rl = new ReleaseLevel("ReleaseProcrastination");
		p = new Point(1,1);
		
		/** Set up a BoardTile for each. */	
		pl.getBoard().createBoardTile(0, 0, "Puzzle");
		ll.getBoard().createBoardTile(0, 0, "Lightning");
		rl.getBoard().createBoardTile(0, 0, "Release");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testBullpenToBoard(){
		
		/** Activate tile in row 0 col 0 piece in Board on row 1 col 1. */
		Move plm = new IncrementReleaseTileMove(pl, p);
		Move llm = new IncrementReleaseTileMove(ll, p);
		Move rlm = new IncrementReleaseTileMove(rl, p);
	
		/** Test on Puzzle Level. */
		sm.setActiveLevel(pl);
		pl.setLevelType("PuzzleLevelEditView");
		assertEquals("SoPuzzled", pl.getLevelName());
		assertFalse(plm.valid());
		assertFalse(plm.execute());
		assertFalse(plm.undo());

		/** Test on Lightning Level with LightningType. */
		sm.setActiveLevel(ll);
		ll.setLevelType("LightningLevelEditView");
		assertEquals("TestLights", ll.getLevelName());
		assertFalse(llm.valid());
		assertFalse(llm.execute());
		assertFalse(llm.undo());

		/** Test on Release Level with ReleaseType. */
		sm.setActiveLevel(rl);
		rl.setLevelType("Release");
		assertEquals("ReleaseProcrastination", rl.getLevelName());
		assertTrue(rlm.valid());
		assertTrue(rlm.execute());
		assertFalse(rlm.undo());
	}
}
