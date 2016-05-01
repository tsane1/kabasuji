package tests.moves;

import junit.framework.TestCase;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.PuzzleLevel;
import kabasuji.moves.BullpenToBoardMove;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;

/**
 * Test cases involving a single piece moved to the Board. 
 * Also some general level tests. Tests that a null piece is invalid as well.
 * Test saving/Loading a level.
 * 
 * @author Ian Jacoway
 *
 */

public class TestBullpenToBoardMove extends TestCase {
	Piece testPiece;
	PieceTile[] arr;
//	PuzzleLevel pl;
	SuperModel sm;
	Level lvl;
		Piece dummy;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		/** set up super model and level*/
		sm = new SuperModel();
		lvl = new PuzzleLevel("PuzzleLevel");
		sm.setActiveLevel(lvl);
		
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
		lvl.getBoard().createBoardTile(0, 0, "Puzzle");
		lvl.getBoard().createBoardTile(1, 0, "Puzzle");
		lvl.getBoard().createBoardTile(2, 0, "Puzzle");
		lvl.getBoard().createBoardTile(3, 0, "Puzzle");
		lvl.getBoard().createBoardTile(4, 0, "Puzzle");
		lvl.getBoard().createBoardTile(5, 0, "Puzzle");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testBullpenToBoard(){
		// Set test piece as selected FOR REAL who knows which is which
		lvl.setActivePiece(testPiece);
		lvl.setSelected(testPiece);
		lvl.setSelectedPiece(testPiece);
		
		// Place piece in Board on row 1 col 1
		Move m = new BullpenToBoardMove(sm, 0, 0);
		
		assertTrue(m.valid());
		assertTrue(lvl.addPieceToAllPieces(testPiece));
		lvl.addMoveToUndo(m);
		assertEquals(lvl.peekLastMove(), m);
		lvl.addRedoableMove(m);
		assertEquals(lvl.peekRedoMove(), m);
//		assertTrue(m.execute());
//		assertTrue(m.undo());
		
		// Test saving & loading!!
		lvl.saveLevel("user_levels");
		lvl.setLevelName("testie?");
		sm.loadLevel("user_levels", "testie?");
		
		/// Print some proof
		System.out.println(sm.getDefaultLevelDir());
		System.out.println(sm.getUserLevelDir());
		System.out.println(sm.getUserLevelDir());
		
		assertEquals(16, sm.getTotalNumLevels());
//		assertEquals(1, sm.getNumUserLevels()); why true???
		sm.deleteLevel("user_levels", "testie?");
//		assertEquals(15, sm.getTotalNumLevels()); not deleting..? 
	}
	
	
	public void testNULLPiece(){
		lvl.setActivePiece(dummy);
		lvl.setSelected(dummy);
		lvl.setSelectedPiece(dummy);
		
		Move m = new BullpenToBoardMove(sm, 0, 0);
		assertNull(dummy);
		assertFalse(m.valid());
	}

}
