package superview;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class ApplicationView extends JFrame {
	protected JPanel contentPane;
	
	public ApplicationView() {
		initWindow("Kabasuji");
	}
	
	public ApplicationView(String inputTitle) {
		initWindow(inputTitle);
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
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.text);
		btnBack.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnBack.setForeground(SystemColor.textHighlight);
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
	}
}
