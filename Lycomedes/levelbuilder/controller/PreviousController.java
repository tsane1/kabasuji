package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LevelBuilderModel;
import view.BuilderScreen;
import view.BuilderLevelSelect;


public class PreviousController implements ActionListener {
	LevelBuilderModel model;
	BuilderScreen bs;
	
	
	public PreviousController (BuilderScreen bs, LevelBuilderModel  model) {
		this.bs = bs;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			bs.setVisible(false);
			BuilderLevelSelect mbs = bs.getPreviousFrame();
			
			bs.setVisible(false);
			bs.dispose();
			mbs.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Prev controller not working!! noo");
		}
	}
}
