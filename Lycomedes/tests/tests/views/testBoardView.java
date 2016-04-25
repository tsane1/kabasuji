package tests.views;

import java.awt.Graphics;

import com.sun.glass.ui.View;

import junit.framework.TestCase;
import kabasuji.entities.*;
import kabasuji.supers.Level;
import kabasuji.views.BoardView;

//ATTEMPTS TO TEST BOARD VIEW BUT I DONT THINK ITS POSSIBLE CURRENTLY
public class testBoardView extends TestCase {

	Level lvl;
	BoardView view;
	protected void setUp() throws Exception {
		lvl = new PuzzleLevel("test");
		view = new BoardView(lvl);
		view.refresh();
		view.setVisible(true);
	}

	protected void tearDown() throws Exception {
		
	}
	
	public void testView(){
		Board board = lvl.getBoard();
		Tile[][] boardArray = board.getBoardArray();
		UnplayableTile tile = new UnplayableTile(0, 0);
		int i,j,count = 0;
		for(i = 0; i<12; i++){
			for(j = 0; j<12; j++){
				if(boardArray[i][j].getClass() == tile.getClass()){
					
				}else{
					count++;
				}
			}
		}
		assertEquals(0, count);
		
	}

}
