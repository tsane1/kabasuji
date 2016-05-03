package tests.supers;

import java.awt.Color;

import junit.framework.TestCase;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.PuzzleLevel;
import kabasuji.moves.RotateLeftMove;
import kabasuji.supers.Level;
import kabasuji.supers.Move;

/*
 * 
 * 
 * 
 * Need to test undo/redo functions in level when testing moves
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class TestLevel extends TestCase {

	Level testLevel;
	protected void setUp() throws Exception {
		super.setUp();
		
		testLevel = new PuzzleLevel("test level");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testNewLevelConstructor(){
		assertFalse(testLevel.isLocked());
		testLevel.lock();
		assertTrue(testLevel.isLocked());
		testLevel.unlock();
		assertFalse(testLevel.isLocked());

		assertEquals(0, testLevel.getNumStars());

		assertTrue(testLevel.getBullpen().isEmpty());
		assertFalse(testLevel.getPalette().getPieces().isEmpty());
		
		assertFalse(testLevel.getAllPieces().isEmpty());
		
		assertFalse(testLevel.getColorMap().isEmpty());
		
		assertEquals("Puzzle", testLevel.getLevelType());
		
		testLevel.setLevelType("Puzzle");
		
		assertEquals("Puzzle", testLevel.getLevelType());
		
		assertEquals("test level", testLevel.getLevelName());
		
		testLevel.setLevelName("testing level");
		
		assertEquals("testing level", testLevel.getLevelName());
		
	}
	
	public void testLevelPieces(){
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
		
		testPiece = new Piece(1000, arr);
		
		testLevel.setActivePiece(testPiece);
		assertEquals(testPiece, testLevel.getActivePiece());
		
		testLevel.setDraggingPiece(testPiece);
		assertEquals(testPiece, testLevel.getDraggingPiece());
		
		testLevel.setSelectedPiece(testPiece);
		assertEquals(testPiece, testLevel.getSelected());
		
		assertTrue(testLevel.addPieceToAllPieces(testPiece));
		
		testLevel.getColorMap().put(testPiece.getPieceID(), Color.blue);
		assertEquals(Color.blue, testLevel.getPieceColor(testPiece.getPieceID()));
		
		assertNotNull(testLevel.generateRandomPiece());
		
		testLevel.addPieceToBoard(testPiece);
		assertTrue(testPiece.equals(testLevel.getSelected()));
	}
	
	public void testUndoRedo(){
		
		Move m = new RotateLeftMove(testLevel);
		testLevel.addMoveToUndo(m);
		testLevel.addRedoableMove(m);
		
		assertEquals(m, testLevel.getLastMove());
		assertEquals(m, testLevel.getRedoMove());
	}
	

}
