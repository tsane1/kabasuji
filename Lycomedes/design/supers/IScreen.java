package supers;

import javax.swing.JPanel;

public interface IScreen {
	public void populate(); // initialize view
	public void installControllers(); // initialize controllers
	public void initModel(); // initialize model
	public void refresh(); // refresh view to show updated state
	public String getName();
}
