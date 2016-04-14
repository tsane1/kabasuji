package view;

import model.Level;
import supers.Screen;

@SuppressWarnings("serial")
public class ReleaseLevelEdit extends Screen {

	private Level thisLevel;
	private Screen prevScreen;
	
	public ReleaseLevelEdit(Level L) {
		super(L.getLevelName(), L);
		this.thisLevel = L;
	}

	@Override
	public void installControllers() {
		super.installControllers();
	}
	

	@Override
	public void initModel() {
		// Method intentionally unimplemented, must be overridden to use
	}

	@Override
	public void refresh() {
		// Method intentionally unimplemented, must be overridden to use
	}
	
	public Level getLevel() {
		return this.thisLevel;
	}
	
	public void setPreviousFrame(Screen screen) {
		prevScreen = screen;
	}

	public LevelEditSelectView getPreviousFrame() {
		return (LevelEditSelectView)prevScreen;
	}
}
