package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.moves.RotateLeftMove;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;

/**
 * A controller to Pieces 90 degrees to the left.
 * @author Ian Jacoway
 */

public class RotateLeftController implements ActionListener {
	Application app;
	Level level;
	
	public RotateLeftController(Application a, Level l) {
		this.app = a;
		this.level = l;
	}
	
	public boolean doRotateLeft(){
//		Move m = level.getLastMove();
		Move m = new RotateLeftMove(level);
//		if(m == null){
//			return false;
//		}		
//		if(level.getSelected() == null){
//			return false;
//		}
		
//		level.getSelected().rotateLeft();
		if(m.execute()){
//			// If appropriate screen then update view
//			switch (app.getCurrScreen().getName()){
//				case "LevelPlay": case "PuzzleLevelEditView": case "LightningLevelEditView": case "ReleaseLevelEditView":
					app.getCurrScreen().getBullpenView().refresh();
//				default:
//					level.trackMove(m);
//					;//do nothing/push to undo stack?
//			}
		}
//		if(m.execute()) {
//			level.addMoveToUndo(m);
//		}
//		
//		Move m = new RotateLeftMove(level);
//		if(m.execute()){
//			if(app.getCurrScreen().getName() != "LevelPlay")
//				level.trackMove(m);
//			app.getCurrScreen().getBullpenView().refresh();
//		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			doRotateLeft();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : RotateLeftController");
			ex.printStackTrace();
		}
	}
}



//public class RotateLeftController implements ActionListener {
//	Application app;
//	Level level;
//	
//	public RotateLeftController(Application a, Level l) {
//		this.app = a;
//		this.level = l;
//	}
//	
//	public void doRotateLeft(){
//		if(level.getSelected() == null){
//			return;
//		}
//		
//		Move m = new RotateLeftMove(level);
//		if(m.execute()){
//			if(app.getCurrScreen().getName() != "LevelPlay")
//				level.trackMove(m);
//			app.getCurrScreen().getBullpenView().refresh();
//		}
//		else return;
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		try{
//			doRotateLeft();
//		}
//		catch(Exception ex){
//			System.err.println("EXCEPTION CAUGHT : RotateLeftController");
//			ex.printStackTrace();
//		}
//	}
//}
//
//
