package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;

public class NavigateLevelSelectController implements ActionListener {
	SuperModel model;
	Application app;
	
	public NavigateLevelSelectController(Application app, SuperModel model) {
		this.model = model;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Next": 
			this.model.nextPage();
			break;
		case "Previous": 
			this.model.prevPage();
			break;
		default: 
			System.err.println("Error 64169198: NavigateLevelSelectController installed on wrong button!"); 
			break;
		}
		this.app.getCurrScreen().refresh();
	}
}
