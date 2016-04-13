package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import model.LevelBuilderModel;
import supers.Model;
import view.LevelEdit;
import view.LevelEditSelectView;

public class NewLevelController implements ActionListener {

	Level model;
	LevelEditSelectView main;
	
	public NewLevelController(LevelEditSelectView screen, Level m) {
		this.main = screen;
		this.model = m;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			main.setVisible(false);
			
			LevelEdit screen2 = new LevelEdit(model);
			screen2.setPreviousFrame(main);
			screen2.setVisible(true);
		}
		catch(Exception e){
			System.err.println("New Level Button Controller Error");
			e.printStackTrace();
		}
		
	}

}
