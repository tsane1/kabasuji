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

public class Application extends JFrame implements IApplication {
	protected JPanel contentPane;
	protected JButton btnBack;
	protected Model model;
	
	public Application(Model m) {
		this(m, "Kabasuji");
	}
	
	public Application(Model m, String inputTitle) {
		this.model = m;
		initWindow(inputTitle);
		populate();
		installControllers();
		initModel();
	}
	
	private void initWindow(String inputTitle) {
		setTitle(inputTitle);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel(inputTitle);
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
		btnBack.addActionListener(new BackController(this, model));
	}

	@Override
	public void populate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void installControllers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initModel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
}
