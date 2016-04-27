package kabasuji.views;

/**
 * 
 * @author Chase St. Laurent
 * @author Tanuj Sane
 * 
 * @deprecated
 */

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kabasuji.entities.Achievement;

@Deprecated
public class AchievementView extends JPanel {
	private int numStars;

	public AchievementView(int numStars) {
		super();
		this.numStars = numStars;
		setLayout(null);
		

		// For three stars
		JLabel threeStar = new JLabel("");
		threeStar.setIcon(new ImageIcon(""));
		threeStar.setBounds(0, 0, 75, 25);// x,y,w,h
		add(threeStar);
		this.setBounds(625, 100, 75, 25); 

		// For two stars
		JLabel twoStar = new JLabel("");
		twoStar.setIcon(new ImageIcon(""));
		twoStar.setBounds(0, 0, 50, 25);// x,y,w,h
		add(twoStar);
		this.setBounds(625, 150, 50, 25);

		// For one stars
		JLabel oneStar = new JLabel("");
		oneStar.setIcon(new ImageIcon(""));
		oneStar.setBounds(0, 0, 25, 25);// x,y,w,h
		add(oneStar);
		this.setBounds(625, 200, 25, 25);
	}

}
