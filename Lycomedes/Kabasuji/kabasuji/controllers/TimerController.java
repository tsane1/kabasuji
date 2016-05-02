package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.entities.LightningLevel;
import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;

/**
 * Controller for the timer on lightning levels.
 */
public class TimerController implements ActionListener {
	/** Application being run. */
	private Application app;
	/** Supermodel instance. */
	private SuperModel model;
	
	/**
	 * Constructor for the timer controller.
	 * @param app
	 * @param model
	 */
	public TimerController(Application app, SuperModel model) {
		this.app = app;
		this.model = model;
	}

	/**
	 * Method for activating and keeping track of the timer.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!model.getActiveLevel().getLevelType().equals("Lightning")) return;
		if(((LightningLevel)model.getActiveLevel()).getSecsLeft() + ((LightningLevel)model.getActiveLevel()).getMinsLeft() == 0) return;		
		int prev = ((LightningLevel)model.getActiveLevel()).getSecsLeft();
		((LightningLevel)model.getActiveLevel()).setSecsLeft(prev - 1);
		if(((LightningLevel)model.getActiveLevel()).getSecsLeft() < 0) {
			int prevM = ((LightningLevel)model.getActiveLevel()).getMinsLeft();
			((LightningLevel)model.getActiveLevel()).setMinsLeft(prevM - 1);
			((LightningLevel)model.getActiveLevel()).setSecsLeft(59);
		}
		app.getCurrScreen().refresh();
	}
}
