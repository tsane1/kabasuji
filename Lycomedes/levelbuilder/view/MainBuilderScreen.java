package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controller.DeleteLevelController;
import controller.EditLevelController;
import controller.NewLevelController;
import mockups.Derek_Sandbox;
import model.LevelBuilderModel;

import javax.swing.ScrollPaneConstants;

public class MainBuilderScreen extends JFrame {

	//the model
	LevelBuilderModel model;

	//previous screen to handle back
	//BuilderScreen prevScreen;
	
	JPanel contentPane;
	JButton deleteLevelBtn;
	JButton editLevelBtn;
	JButton newLevelBtn;
	JScrollPane levelsScrollPane;
	
	public MainBuilderScreen(LevelBuilderModel m) {
		this.model = m;
		
		setTitle("Kabasuji Level Builder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		newLevelBtn = new JButton("New Level");
		
		deleteLevelBtn = new JButton("Delete Level");
		
		editLevelBtn = new JButton("Edit Level");
		
		levelsScrollPane = new JScrollPane();
		levelsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(levelsScrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(newLevelBtn, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addGap(222)
							.addComponent(editLevelBtn, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
							.addGap(214)
							.addComponent(deleteLevelBtn, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(deleteLevelBtn, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(newLevelBtn, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addComponent(editLevelBtn, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addComponent(levelsScrollPane, GroupLayout.PREFERRED_SIZE, 634, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		//deleteLevelBtn.addActionListener(new DeleteLevelController(this, model));
		//editLevelBtn.addActionListener(new EditLevelController(this, model));
		//newLevelBtn.addActionListener(new NewLevelController(this, model));
		
		//refresh();
	}

}
