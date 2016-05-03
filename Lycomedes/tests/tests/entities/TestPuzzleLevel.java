package tests.entities;

import junit.framework.TestCase;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.PuzzleLevel;

public class TestPuzzleLevel extends TestCase {

	PuzzleLevel testLevel;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		testLevel = new PuzzleLevel("test");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPuzzleChars(){
		assertEquals("test", testLevel.getLevelName());
		
		assertEquals("Puzzle", testLevel.getLevelType());
		
		testLevel.setMovesLeft(100);
		
		assertEquals(100, testLevel.getMovesLeft());
		
		assertFalse(testLevel.hasEnded());
		assertFalse(testLevel.hasWon());
		
		testLevel.setNumStars();
		
		testLevel.setMovesLeft(0);
		
		assertTrue(testLevel.hasEnded());
	}

}
