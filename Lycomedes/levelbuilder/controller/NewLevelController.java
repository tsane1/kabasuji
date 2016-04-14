package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import model.LevelBuilderModel;
import supers.Application;
import supers.Model;
import view.LevelEdit;
import view.LevelEditSelectView;
import view.NewLevelTypeSelectView;

public class NewLevelController implements ActionListener {

	Model model;
	Application app;
	
	public NewLevelController(Application a, Model m) {
		this.model = m;
		this.app = a;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		app.setCurrScreen(new LevelEdit(new Level("", "")));
	}
	
	
	/*@Override
	public void actionPerformed(ActionEvent e){
		app.setCurrScreen(new NewLevelTypeSelectView());
	}
	*/

}
