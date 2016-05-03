package tests.views;

import junit.framework.TestCase;
import kabasuji.entities.*;
import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;
import kabasuji.views.LevelPlayView;

public class TestLevelPlayRelease extends TestCase {
	LevelPlayView play;
	Application app;
	Piece piece;
	PieceTile[] arr;
	protected void setUp(){
		SuperModel sm = new SuperModel();
		sm.setActiveLevel(new ReleaseLevel("Test"));
		play = new LevelPlayView("test", sm);
		play.getLevel().getBoard().createBoardTile(0, 0, "Release");
		play.getLevel().getBoard().createBoardTile(1, 0, "Release");
		play.getLevel().getBoard().createBoardTile(2, 0, "Release");
		play.getLevel().getBoard().createBoardTile(3, 0, "Release");
		play.getLevel().getBoard().createBoardTile(4, 0, "Release");
		play.getLevel().getBoard().createBoardTile(5, 0, "Release");
		
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
		
		piece = new Piece(1, arr);
		
		play.getLevel().getBullpen().addPiece(piece);
		
		
		((ReleaseBoardTile) play.getLevel().getBoard().getBoardArray()[0][0]).updateReleaseNum();
		app = new Application(play);
//		app.getCurrScreen().getLevel().getBoard().createBoardTile(0, 0, "Release");
		app.setVisible(true);
		
		
		try{
			Thread.sleep(250);
		}catch(Exception e){
			
		}
		
	}
	
	protected void tearDown(){
		app.setVisible(false);
		app.dispose();
	}

	public void testViews(){
		assertTrue(app.getCurrScreen().getLevel().getBoard().place(0, 0, piece));
		app.getCurrScreen().getBoardView().redraw();
//		assertTrue(app.getCurrScreen().getLevel().getBoard().createBoardTile(0, 0, "Puzzle"));
//		assertTrue(app.getCurrScreen().getLevel().getBoard().createBoardTile(1, 1, "Lightning"));
//		assertTrue(app.getCurrScreen().getLevel().getBoard().createBoardTile(1, 1, "Release"));
//		
//		assertTrue(app.getCurrScreen().getBoardView() != null);
//		assertFalse(app.getCurrScreen().getPaletteView() != null);
//		assertTrue(app.getCurrScreen().getBullpenView() != null);
		
	}
}
