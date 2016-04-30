package tests.entities;

import junit.framework.TestCase;
import kabasuji.entities.LightningLevel;

public class TestLightningLevel extends TestCase {

	LightningLevel testLevel;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		testLevel = new LightningLevel("test");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testLightningChars(){
		assertEquals("test", testLevel.getLevelName());
		
		assertEquals("Lightning", testLevel.getLevelType());
		
		testLevel.setMinsLeft(5);
		assertEquals(5, testLevel.getMinsLeft());
		
		testLevel.setSecsLeft(50);
		assertEquals(50, testLevel.getSecsLeft());
	}

}
