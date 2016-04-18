package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.entities.Level;
import kabasuji.supers.Application;
import kabasuji.supers.Model;
import kabasuji.views.LevelEdit;


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
