package tests.entities;

import junit.framework.TestCase;
import kabasuji.entities.Board;
import kabasuji.entities.Progress;

/** 
 * 
 * @author Chase St. Laurent
 *
 */

public class TestProgress extends TestCase {

	public void testProg(){
		Board b = new Board();
		Progress p = new Progress(b);
	}
}
