package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LevelBuilderModel;
import view.BuilderScreen;

public class UndoController implements ActionListener {

	LevelBuilderModel model;
	BuilderScreen screen;
	
	public UndoController(BuilderScreen bs, LevelBuilderModel lbm) {
		this.screen = bs;
		this.model = lbm;
	}
	
	public boolean doUndo(){
		Move m = model.getLastMove();
		
		if(m == null){
			return false;
		}
		
		if(m.undo()){
			model.addRedoableMove(m);
		}
		
		//screen.redraw();
		//screen.repaint();
		
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	// THIS IS A REQUIREMENT OF THE ACTIONLISTENER CLASS THE "doUndo" should prolly go here
	}

//What hienimon has under his WordMap undo controller	
//	Model model;
//	ApplicationPanel canvas;
//	
//	public UndoController(Model m, ApplicationPanel canvas) {
//		this.model = m;
//		this.canvas = canvas;
//	}
//	
//	public boolean process() {
//		Move m = model.removeLastMove();
//		if (m == null) { return false; }
//		
//		if (m.undo()) {
//			model.recordRedoableMove(m);
//		}
//		
//		// force board to redraw
//		canvas.redraw();
//		canvas.repaint();
//		return true;
//	}
}
