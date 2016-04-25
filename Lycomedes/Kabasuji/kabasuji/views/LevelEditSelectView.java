package kabasuji.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import kabasuji.controllers.LevelEditController;
import kabasuji.controllers.NavigateLevelSelectController;
import kabasuji.controllers.NewLevelController;
import kabasuji.supers.SuperModel;
import kabasuji.supers.Application;
import kabasuji.supers.Screen;

/**
 * <b>VIEW</b> class that provides interface for choosing levels to edit.
 * <p>
 * LevelEditSelectView (extends {@code Screen}) displays buttons for selection
 * of which level to edit, as well as the names of the levels. Navigation is done
 * via "Next" and "Previous" controllers attached to buttons. This class ignores
 * the default levels and only displays editable user levels. Buttons are also 
 * provided to create a new level and close the window.
 * </p>
 * @author Tanuj Sane
 * @since 4/21/2016
 */

public class LevelEditSelectView extends Screen {
	private ArrayList<JButton> levelButtons = new ArrayList<JButton>();
	private ArrayList<JLabel> levelNames = new ArrayList<JLabel>();
	private JButton btnNewLevel = new JButton("New Level");
	private JButton btnNext = new JButton("Next");
	private JButton btnPrev = new JButton("Previous");
	
	public LevelEditSelectView(SuperModel m) {
		super("Edit a Level", m);
	}
	
	@Override
	public void populate() {
		btnNext.setActionCommand("Next");
		btnNext.setBackground(SystemColor.text);
		btnNext.setForeground(SystemColor.textHighlight);
		btnNext.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnNext.setBounds(765, 683, 155, 57);
		this.add(btnNext);
		
		btnPrev.setActionCommand("Previous");
		btnPrev.setBackground(SystemColor.text);
		btnPrev.setForeground(SystemColor.textHighlight);
		btnPrev.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnPrev.setBounds(13, 683, 155, 57);
		this.add(btnPrev);
		
		for(int idx = 0; idx < this.model.getNumUserLevels(); idx++) {
			levelNames.add(new JLabel());
			levelNames.get(idx).setText(model.getUserLevelNameByIndex(idx));
			levelNames.get(idx).setHorizontalAlignment(SwingConstants.CENTER);
			levelNames.get(idx).setForeground(SystemColor.textHighlight);
			levelNames.get(idx).setFont(new Font("Kristen ITC", Font.BOLD, 18));
			levelNames.get(idx).setSize(128,50);
			
			levelButtons.add(new JButton());
			levelButtons.get(idx).setActionCommand(model.getUserLevelNameByIndex(idx));
			switch(model.loadLevel(model.getUserLevelDir(), model.getUserLevelNameByIndex(idx)+".lev").getLevelType()) {
			case "Puzzle":
				levelButtons.get(idx).setIcon(new ImageIcon(LevelEditSelectView.class.getResource("/imgs/puzzle_icon_smol.png")));
				break;
			case "Lightning":
				levelButtons.get(idx).setIcon(new ImageIcon(LevelEditSelectView.class.getResource("/imgs/lightning_icon_smol.png")));
				break;
			case "Release":
				levelButtons.get(idx).setIcon(new ImageIcon(LevelEditSelectView.class.getResource("/imgs/release_icon_smol.png")));
				break;
			}
			levelButtons.get(idx).setBackground(SystemColor.text);
			levelButtons.get(idx).setSize(128, 128);
		}		
		
		btnNewLevel.setActionCommand("New Level");
		btnNewLevel.setBackground(SystemColor.text);
		btnNewLevel.setForeground(SystemColor.textHighlight);
		btnNewLevel.setFont(new Font("Kristen ITC", Font.BOLD, 72));
		btnNewLevel.setText("+");
		btnNewLevel.setSize(128, 128);
		levelButtons.add(btnNewLevel);
		
		JLabel newLevel = new JLabel("New Level");
		newLevel.setHorizontalAlignment(SwingConstants.CENTER);
		newLevel.setForeground(SystemColor.textHighlight);
		newLevel.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		newLevel.setSize(128,50);
		levelNames.add(newLevel);
				
		refresh();
	}

	@Override
	public void installControllers() {
		for(int idx = 0; idx < this.model.getNumUserLevels(); idx++) {
			levelButtons.get(idx).addActionListener(new LevelEditController(this.app, this.model));
		}
		btnNewLevel.addActionListener(new NewLevelController(this.app, this.model));
		btnNext.addActionListener(new NavigateLevelSelectController(this.app, this.model));
		btnPrev.addActionListener(new NavigateLevelSelectController(this.app, this.model));
	}
	
	@Override
	public String getName() {
		return "LevelEditSelect";
	}

	@Override
	public void refresh() {
		for(int idx = 0; idx < this.levelButtons.size(); idx++) {
			this.remove(levelButtons.get(idx));
			this.remove(levelNames.get(idx));
		}		
		this.validate();
		this.repaint();
		
		btnNext.setEnabled(model.getPage() < (model.getNumUserLevels() - 1) / 10);
		btnPrev.setEnabled(model.getPage() > 0);
		btnNext.validate();
		btnNext.repaint();
		btnPrev.validate();
		btnPrev.repaint();		
		
		for(int idx = 0; idx < 10; idx++) {
			int btnIndex = (10*model.getPage()) + idx;
			if(btnIndex >= levelButtons.size());
			else {
				System.out.println(btnIndex);
				levelNames.get(btnIndex).setLocation(125+(138*(idx%5)), 150+(188*(idx/5)));
				this.add(levelNames.get(btnIndex));
				levelNames.get(btnIndex).validate();
				levelNames.get(btnIndex).repaint();
				
				levelButtons.get(btnIndex).setLocation(125+(138*(idx%5)), 200+(188*(idx/5)));
				this.add(levelButtons.get(btnIndex));
				levelButtons.get(btnIndex).validate();
				levelButtons.get(btnIndex).repaint();
			}
		}
	}
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application(new LevelEditSelectView(new SuperModel()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
