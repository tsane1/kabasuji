package tests.executables;

import junit.framework.TestCase;
import kabasuji.executables.LaunchLevelBuilder;
import kabasuji.executables.LaunchPlayer;

public class TestExecutables extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testExec(){
		LaunchLevelBuilder llb = new LaunchLevelBuilder();
		
		LaunchPlayer lp = new LaunchPlayer();
		
		assertTrue(true);
	}

}
