package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.entities.LightningLevel;
import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;

public class TimerController implements ActionListener {
	private Application app;
	private SuperModel model;
	
	public TimerController(Application app, SuperModel model) {
		this.app = app;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(((LightningLevel)model.getActiveLevel()).getSecsLeft() + ((LightningLevel)model.getActiveLevel()).getMinsLeft() == 0) return;		
		int prev = ((LightningLevel)model.getActiveLevel()).getSecsLeft();
		((LightningLevel)model.getActiveLevel()).setSecsLeft(prev - 1);
		if(((LightningLevel)model.getActiveLevel()).getSecsLeft() < 0) {
			int prevM = ((LightningLevel)model.getActiveLevel()).getMinsLeft();
			((LightningLevel)model.getActiveLevel()).setMinsLeft(prevM - 1);
			((LightningLevel)model.getActiveLevel()).setSecsLeft(0);
		}
		app.getCurrScreen().refresh();
	}
}
