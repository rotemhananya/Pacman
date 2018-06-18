package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import collections.Boards;
import collections.Pictures;

/**
 * This class represents the window the user sees when he wins/loses.
 * This class extends JFrame and implements ActionListener.
 * 
 */

public class GameOver extends JFrame implements ActionListener {
	private JLabel lblWinner;
	private JLabel lblSteps;
	private JLabel lblTime;
	private Pictures pics;
	private JLabel lblFireworks;
	private JLabel lblCrying;
	private JButton btnPlayAgain;
	private JButton btnExit;

	/** GameOver constructor.
	 * 
	 * @param points - the amount of points the user had before winning/losing.
	 * @param time  - the time it took the user to win/lose.
	 */
	public GameOver(int points, String time, boolean won, Pictures pics) {
		super("Game over"); // initiating the frame
		getContentPane().setBackground(new Color(0, 0, 0)); // setting the frame's background and bounds
		setBounds(0, 0, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false); 

		this.pics=pics;
		
		if (won==true) {
			lblWinner = new JLabel("YOU WON!"); // "YOU WON!" label
			lblWinner.setBounds(200, 85, 400, 70); // setting the bounds of the label
		}
		else {
			lblWinner = new JLabel("You lost :("); // "You lost :(" label
			lblWinner.setBounds(150, 85, 500, 70); // setting the bounds of the label
		}
		lblWinner.setFont(new Font("Stencil", Font.PLAIN, 80)); // setting the font, the background and the foreground 
		lblWinner.setBackground(new Color(255, 255, 255));

		lblWinner.setForeground(SystemColor.text);
		getContentPane().add(lblWinner); // adding "YOU WON!" to the frame

		lblSteps = new JLabel("Points: " + points); // "Steps: " label, steps is the amount of step the user had done
		lblSteps.setBounds(30, 250, 220, 40); // setting the font, the background, the foreground and the size
		lblSteps.setForeground(new Color(255, 255, 255));
		lblSteps.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSteps.setBackground(Color.BLACK);
		getContentPane().add(lblSteps); // adding "Steps:" to the frame

		lblTime = new JLabel("Time: "+time); // "Time: " label, time is the time it took the user to win
		lblTime.setBounds(30, 340, 313, 40); // setting the font, the background, the foreground and the size
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTime.setBackground(Color.BLACK);
		getContentPane().add(lblTime); // adding "Time:" to the frame

		btnPlayAgain = new JButton("Play again"); // "Play again" button
		btnPlayAgain.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { // in case play again button is pressed, starting a new game
				Boards b = new Boards(); // initializing the option of the board
				Menu window = new Menu(pics, b); // initializing Menu
				window.setVisible(true); // setting Menu as visible
				dispose(); // closing the window when the button is pressed
			}
		});
		btnPlayAgain.setBackground(Color.BLACK); // setting the font, the background, the foreground and the size
		btnPlayAgain.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnPlayAgain.setForeground(Color.WHITE);
		btnPlayAgain.setBounds(30, 480, 190, 50);
		btnPlayAgain.setFocusable(false);
		getContentPane().add(btnPlayAgain); // adding btnExit to the frame
		validate();

		btnExit = new JButton("Exit"); // "Exit" button
		btnExit.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				dispose(); // closing the window when the button is pressed
			}
		});
		btnExit.setBackground(Color.BLACK); // setting the font, the background, the foreground and the size
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnExit.setForeground(Color.WHITE);
		btnExit.setBounds(570, 480, 190, 50);
		btnExit.setFocusable(false);
		getContentPane().add(btnExit); // adding btnExit to the frame
		validate();

		if (won==true) { // in case the user won, adding fireworks to the background
			lblFireworks = new JLabel(""); // the label in which the fireworks will be shown
			lblFireworks.setBounds(0, 0, 800, 600); // setting the label's bounds
			Image resizedImage = pics.getPic(7).getImage().getScaledInstance(800, 600, 0); // cutting the fireworks' image
			pics.getPic(7).setImage(resizedImage); 
			lblFireworks.setIcon(pics.getPic(7)); // setting the label's icon to be the fireworks
			getContentPane().add(lblFireworks); // adding the label to the frame
			validate();
		}
		else {// in case the user lost
			lblCrying = new JLabel(""); // the label in which the fireworks will be shown
			lblCrying.setBounds(300, 180, 460, 280); // setting the label's bounds
			Image resizedImage = pics.getPic(8).getImage().getScaledInstance(460, 280, 0); // cutting the fireworks' image
			pics.getPic(8).setImage(resizedImage); 
			lblCrying.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			lblCrying.setIcon(pics.getPic(8)); // setting the label's icon to be the fireworks
			getContentPane().add(lblCrying); // adding the label to the frame
			validate();
		}

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
