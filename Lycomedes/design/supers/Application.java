package supers;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import controller.BackController;

import javax.swing.SwingConstants;

public class Application extends JFrame {
	private JPanel contentPane = new JPanel();
	private JLabel lblTitle = new JLabel();
	private JButton btnBack;
	private IApplication currentScreen;
	
	public Application(IApplication app) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.currentScreen = app;
		initWindow(app.getName());
		paintScreen(app);
	}
	
	private void initWindow(String inputTitle) {
		setTitle(inputTitle);
		
		lblTitle = new JLabel(inputTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(SystemColor.textHighlight);
		lblTitle.setFont(new Font("Kristen ITC", Font.BOLD, 32));
		lblTitle.setBounds(0,13,930,75);
		contentPane.add(lblTitle);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.text);
		btnBack.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnBack.setForeground(SystemColor.textHighlight);
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		// install back button controller
		btnBack.addActionListener(new BackController(this, new Model()));
	}
	
	public void paintScreen(IApplication app) {
		populate();
		installControllers();
		initModel();
		this.getContentPane().repaint();
	}

	private void populate() {
		initWindow(currentScreen.getName());
		currentScreen.populate(contentPane);
	}
	private void installControllers() {
		currentScreen.installControllers();
	}
	private void initModel() {
		currentScreen.initModel();
	}
	public void refresh() {
		currentScreen.refresh();
	}
	
	public IApplication getCurrentScreen() {
		return currentScreen;
	}
}
