package kabasuji.views;

import kabasuji.supers.Application;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

public class LevelEndView extends Screen {
	private SuperModel model;
	
	public LevelEndView(SuperModel m) {
		super("", m);
		this.model = m;
	}

	@Override
	public void populate() {
		
	}

	@Override
	public void installControllers() {
		
	}

	@Override
	public void refresh() {
		
	}

	@Override
	public String getName() {
		return "LevelEnd";
	}
	
	public static void main(String[] args) {
		Application app = new Application(new LevelEndView(new SuperModel()));
		app.setVisible(true);
	}
}