package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LevelBuilderModel;
import supers.Model;
import view.BuilderScreen;
import view.LevelEditSelectView;
import view.LevelViewB;


public class PreviousController implements ActionListener {
	Model model;
	LevelViewB bs;
	
	
	public PreviousController (LevelViewB bs, Model  model) {
		this.bs = bs;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			bs.setVisible(false);
			LevelEditSelectView mbs = bs.getPreviousFrame();
			
			bs.setVisible(false);
			bs.dispose();
			mbs.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Prev controller not working!! noo");
		}
	}
}
