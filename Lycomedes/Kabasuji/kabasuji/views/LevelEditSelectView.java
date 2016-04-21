package kabasuji.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import javax.swing.JButton;
import kabasuji.controllers.LevelEditController;
import kabasuji.controllers.NewLevelController;
import kabasuji.supers.SuperModel;
import kabasuji.supers.Application;
import kabasuji.supers.Screen;

public class LevelEditSelectView extends Screen {
	private ArrayList<JButton> userLevelButtons = new ArrayList<JButton>(15);
	private JButton btnNewLevel = new JButton("New Level");
	private JButton btnDeleteLevel = new JButton("Delete Level");
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
		
		
		// ditch this get a scroll thing implemented
		btnNewLevel.setActionCommand("New Level");
		btnNewLevel.setBackground(SystemColor.text);
		btnNewLevel.setForeground(SystemColor.textHighlight);
		btnNewLevel.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnNewLevel.setBounds(13, 683, 155, 57);
		this.add(btnNewLevel);
		
		btnDeleteLevel.setActionCommand("Delete Level");
		btnDeleteLevel.setBackground(SystemColor.text);
		btnDeleteLevel.setForeground(SystemColor.textHighlight);
		btnDeleteLevel.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnDeleteLevel.setBounds(765, 683, 155, 57);
		this.add(btnDeleteLevel);
		
		int idx; String name;
		for(idx = 0; idx < this.model.numUserLevels(); idx++) {
			name = Integer.toString(idx+1);
			userLevelButtons.add(new JButton(name));
			userLevelButtons.get(idx).setName(name);
			userLevelButtons.get(idx).setActionCommand(name);
			userLevelButtons.get(idx).setBackground(SystemColor.text);
			userLevelButtons.get(idx).setForeground(SystemColor.textHighlight);
			userLevelButtons.get(idx).setFont(new Font("Kristen ITC", Font.BOLD, 20));
			
		}
		
		if(idx < 5) userLevelButtons.get(idx).setBounds(217+(105*(idx)), 180, 95, 80);
		else if(idx < 10) userLevelButtons.get(idx).setBounds(217+(105*(idx-5)), 330, 95, 80);
		else if(idx < 15) userLevelButtons.get(idx).setBounds(217+(105*(idx-10)), 480, 95, 80);
		this.add(userLevelButtons.get(idx));
	}

	@Override
	public void installControllers() {
		int idx;
		for(idx = 0; idx < this.model.numUserLevels(); idx++) {
			userLevelButtons.get(idx).addActionListener(new LevelEditController(this.app, this.model));
		}
		btnNewLevel.addActionListener(new NewLevelController(this.app, this.model));
	}
	
	@Override
	public String getName() {
		return "LevelEditSelect";
	}

	@Override
	public void refresh() {
		populate();
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
