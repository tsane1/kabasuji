package supers;

import javax.swing.JPanel;

public interface IApplication {
	public void populate(JPanel contentPane); // initialize view
	public void installControllers(); // initialize controllers
	public void initModel(); // initialize model
	public void refresh(); // refresh view to show updated state
	public String getName();
}
