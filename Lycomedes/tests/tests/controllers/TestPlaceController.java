package tests.controllers;

import java.awt.AWTException;
import java.awt.Robot;

import junit.framework.TestCase;
import kabasuji.controllers.PlacePieceController;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;
import kabasuji.views.LevelPlayView;

public class TestPlaceController extends TestCase {
	LevelPlayView play;
	Application app;
	PieceTile[] arr;
	Piece piece;
	protected void setUp(){
		SuperModel sm = new SuperModel();
		sm.setActiveLevel(new LightningLevel("Test"));
		((LightningLevel)sm.getActiveLevel()).setSecsLeft(10);
		play = new LevelPlayView("test", sm);
		play.getLevel().getBoard().createBoardTile(0, 0, "Lightning");
		play.getLevel().getBoard().createBoardTile(1, 0, "Lightning");
		play.getLevel().getBoard().createBoardTile(2, 0, "Lightning");
		play.getLevel().getBoard().createBoardTile(3, 0, "Lightning");
		play.getLevel().getBoard().createBoardTile(4, 0, "Lightning");
		play.getLevel().getBoard().createBoardTile(5, 0, "Lightning");
		
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
		
		app = new Application(play);
		app.getCurrScreen().getLevel().getBoard().createBoardTile(1, 1, "Lightning");
		app.setVisible(true);
		
		PlacePieceController pc = new PlacePieceController(app, sm);
		app.getCurrScreen().getBoardView().addMouseMotionListener(pc);
		app.getCurrScreen().getLevel().setActivePiece(piece);
		
		
		try{
			Thread.sleep(250);
		}catch (Exception e){
			
		}
	}

	protected void tearDown() throws Exception {
		app.setVisible(false);
		app.dispose();
	}
	
	public void test() throws AWTException{
		Robot rbt = new Robot();
		rbt.mouseMove(0, 0);
		rbt.mouseMove(200, 100);
	}

}
