package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteLevelController implements ActionListener{

	LevelBuilderModel model;
	LevelBuilderApplication app;
	
	public DeleteLevelController(LevelBuilderApplication app, LevelBuilderModel m) {
		this.model = m;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
