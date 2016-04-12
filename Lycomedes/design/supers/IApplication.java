package supers;

public interface IApplication {
	public void populate(); // initialize view
	public void installControllers(); // initialize controllers
	public void initModel(); // initialize model
	public void refresh(); // refresh view to show updated state
}
