package kabasuji.views;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;

import kabasuji.entities.LightningLevel;
import kabasuji.supers.Application;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

public class LevelEndView extends Screen {
	private SuperModel model;
	
	private JButton btnLevelSelect = new JButton();
	private JButton btnContinue = new JButton();
	private JButton btnReplay = new JButton();
	
	public LevelEndView(SuperModel m) {
		super("", m);
		this.model = m;
	}

	@Override
	public void populate() {
		btnLevelSelect.setBackground(SystemColor.text);
		btnLevelSelect.setForeground(SystemColor.textHighlight);
		btnLevelSelect.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		btnLevelSelect.setBounds(87, 409, 100, 50);
		
		if(model.getActiveLevel().hasEnded() && !model.getActiveLevel().hasWon()) {
			setTitle(model.getActiveLevel().getLevelName() + " LOST");
		}
		else if(model.getActiveLevel().hasEnded() && model.getActiveLevel().hasWon()) {
			setTitle(model.getActiveLevel().getLevelName() + " WON");
			this.add(btnContinue);
		}
		
		this.add(btnLevelSelect);
		this.add(btnReplay);
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
		SuperModel m = new SuperModel();
		m.setActiveLevel(new LightningLevel("Level Test"));
		Application app = new Application(new LevelEndView(m));
		app.setVisible(true);
	}
}