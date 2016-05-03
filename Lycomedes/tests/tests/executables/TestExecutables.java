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
		try {
			llb.main(null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LaunchPlayer lp = new LaunchPlayer();
		try {
			lp.main(null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(true);
	}

}
