package hw4;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cd {

	private JFrame frame;
	private JTextField txtChooseABoard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cd window = new cd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public cd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(0, 0, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblLogo.setBounds(100,30,600,200);
		ImageIcon imLogo = new ImageIcon("C:\\Users\\user\\Desktop\\University\\מונחה עצמים\\מונחה עצמים - תרגיל 4\\Pacman\\PacmanLo.jpg");
		Image resizedImLogo = imLogo.getImage().getScaledInstance(600, 200, 0); // cutting the image
		imLogo.setImage(resizedImLogo);
		lblLogo.setIcon(imLogo); // changing lblLogo's icon
		frame.getContentPane().add(lblLogo); 
		frame.validate();

		JLabel lblPacman = new JLabel("");
		lblPacman.setBounds(100,595,600,164);
		ImageIcon imPacman = new ImageIcon("C:\\Users\\user\\Desktop\\University\\מונחה עצמים\\מונחה עצמים - תרגיל 4\\Pacman\\pacman-1.gif ");
		Image resizedImPacman = imPacman.getImage().getScaledInstance(600, 350, 0); // cutting the image
		imPacman.setImage(resizedImPacman);
		lblPacman.setIcon(imPacman); // changing lblPacman's icon
		frame.getContentPane().add(lblPacman); 
		
		JButton btnStartGame = new JButton("Start game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// BoardGame b = new BoardGame(numBoard);
				frame.dispose();
			}
		});
		btnStartGame.setBackground(null);
		btnStartGame.setForeground(new Color(173, 216, 230));
		btnStartGame.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnStartGame.setBounds(439, 532, 213, 52);
		frame.getContentPane().add(btnStartGame);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		btnExit.setForeground(new Color(173, 216, 230));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnExit.setBackground((Color) null);
		btnExit.setBounds(63, 532, 213, 52);
		frame.getContentPane().add(btnExit);
		
		txtChooseABoard = new JTextField();
		txtChooseABoard.setBackground(new Color(0, 0, 0));
		txtChooseABoard.setForeground(new Color(173, 216, 230));
		txtChooseABoard.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtChooseABoard.setText("Choose a board: ");
		txtChooseABoard.setEditable(false);
		txtChooseABoard.setEnabled(false);
		txtChooseABoard.setBorder(BorderFactory.createEmptyBorder());
		txtChooseABoard.setBounds(63, 241, 260, 39);
		frame.getContentPane().add(txtChooseABoard);
		txtChooseABoard.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBorder(BorderFactory.createEmptyBorder());
		lblNewLabel.setBounds(466, 241, 250, 250);
		frame.getContentPane().add(lblNewLabel);
		frame.validate();
		
	}
}
