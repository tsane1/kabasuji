package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LevelBuilderModel;
import view.BuilderScreen;
import view.BuilderLevelSelect;

public class NewLevelController implements ActionListener {

	LevelBuilderModel model;
	BuilderLevelSelect main;
	
	public NewLevelController(BuilderLevelSelect screen, LevelBuilderModel m) {
		this.main = screen;
		this.model = m;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			main.setVisible(false);
			
			BuilderScreen screen2 = new BuilderScreen(model);
			screen2.setPreviousFrame(main);
			screen2.setVisible(true);
		}
		catch(Exception e){
			System.err.println("New Level Button Controller Error");
			e.printStackTrace();
		}
		
	}

}
