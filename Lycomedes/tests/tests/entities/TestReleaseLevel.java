package tests.entities;

import junit.framework.TestCase;
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
		
		assertFalse(testLevel.getNumsCollectedByColor("red").isEmpty());
		assertFalse(testLevel.getNumsCollectedByColor("yellow").isEmpty());
		assertFalse(testLevel.getNumsCollectedByColor("green").isEmpty());
	}

}
