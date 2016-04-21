package kabasuji.supers;

import javax.swing.JPanel;

/** 
 * Screen interface, for use as contentPane of Application.
 *  
 * @author Tanuj Sane
 * @deprecated Required methods forced as abstract in Screen superclass.
 */
public interface IScreen {
	public void populate(); // initialize view
	public void installControllers(); // initialize controllers
	public void initModel(); // initialize model
	public void refresh(); // refresh view to show updated state
	public String getName();
}
