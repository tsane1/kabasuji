package mockups;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AppView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppView frame = new AppView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppView() {
		super();
		init();
	}
	
	private void init() {
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setForeground(SystemColor.textHighlight);
		lblKabasuji.setFont(new Font("Kristen ITC", Font.BOLD, 60));
		lblKabasuji.setBounds(334, 13, 283, 97);
		contentPane.add(lblKabasuji);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnBack.setForeground(SystemColor.textHighlight);
		btnBack.setBackground(SystemColor.textHighlight);
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
	
	}
}
