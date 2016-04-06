package mockups;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class RulesCredits extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RulesCredits frame = new RulesCredits();
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
	public RulesCredits() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKabasuji = new JLabel("KABASUJI");
		lblKabasuji.setBounds(283, 0, 363, 121);
		lblKabasuji.setForeground(new Color(30, 144, 255));
		lblKabasuji.setFont(new Font("Times New Roman", Font.BOLD, 72));
		contentPane.add(lblKabasuji);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBounds(12, 126, 908, 502);
		tabbedPane.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(tabbedPane);
		
		JTextArea txtrPuzzleMode = new JTextArea();
		txtrPuzzleMode.setForeground(new Color(30, 144, 255));
		txtrPuzzleMode.setEditable(false);
		txtrPuzzleMode.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtrPuzzleMode.setText("Puzzle Mode:\r\n\r\nIn this mode, the goal of the game is to cover the entire board using the given pieces.\r\n\r\nPlayers start with all necessary pieces in the bullpen and a specified number of moves allowed. \r\nPlayers must form the board shape using the given pieces in the specified number of moves.\r\n\r\nPieces may be rotated or flipped in the bullpen at no move cost. Pieces once placed onto the \r\nboard consume one move. Pieces on the board can be freely removed back to the bullpen or\r\nanother location on the board.");
		tabbedPane.addTab("Puzzle Mode", null, txtrPuzzleMode, null);
		tabbedPane.setForegroundAt(0, new Color(30, 144, 255));
		
		JTextArea txtrLightningMode = new JTextArea();
		txtrLightningMode.setForeground(new Color(30, 144, 255));
		txtrLightningMode.setEditable(false);
		txtrLightningMode.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtrLightningMode.setText("Lightning Mode:\r\n\r\nIn this mode, the goal of the game is to cover as much of the board \r\nas possible within the imposed time limit. Random pieces will appear\r\n in the bullpen to replace those placed on the board, leaving five \r\naccessible pieces at all times.\r\n\r\nPlayers start with five pieces in the bullpen and await the countdown. \r\nOnce the countdown finishes, the game runs until the given time for \r\nthe level runs out. Pieces may be placed anywhere on the board. \r\nOverlap with previous pieces or boundaries of the board is allowed. \r\nPieces once placed will indicate that the section beneath was covered.\r\n\r\nPieces may be rotated or flipped in the bullpen at no move cost. Pieces once placed onto the \r\nboard consume one move. Pieces on the board can be freely removed back to the bullpen or\r\nanother location on the board.");
		tabbedPane.addTab("Lightning Mode", null, txtrLightningMode, null);
		tabbedPane.setForegroundAt(1, new Color(30, 144, 255));
		
		JTextArea txtrReleaseModeIn = new JTextArea();
		txtrReleaseModeIn.setForeground(new Color(30, 144, 255));
		txtrReleaseModeIn.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtrReleaseModeIn.setEditable(false);
		txtrReleaseModeIn.setText("Release Mode:\r\n\r\nIn this mode, the goal of the game is to cover as many number combinations as possible. \r\nA full solution to the board as in puzzle mode guarantees maximum points.\r\n\r\nPlayers start with all necessary pieces and must work to cover as many sets of \r\nnumbers as possible. \r\n\r\n[ADD RULES AND PLAY STUFF HERE BECAUSE I DONT WANT TO RN]");
		tabbedPane.addTab("Release Mode", null, txtrReleaseModeIn, null);
		tabbedPane.setForegroundAt(2, new Color(30, 144, 255));
	}
}
