package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.LevelBuilderModel;

public class DeleteLevelController implements ActionListener{

	LevelBuilderModel model;
	LevelBuilderApplication app;
	
	public DeleteLevelController(LevelBuilder app, LevelBuilder m) {
		this.model = m;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
