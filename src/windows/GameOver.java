package Windows;

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

import Collections.Boards;
import Collections.Pictures;

/**
 * This class represents the window the user sees when he wins/loses.
 * This class extends JFrame and implements ActionListener.
 * 
 */

public class GameOver extends JFrame {
	private JLabel LblWinner;
	private JLabel LblSteps;
	private JLabel LblTime;
	private JLabel LblFireworks;
	private JLabel LblCrying;
	private JButton BtnPlayAgain;
	private JButton BtnExit;

	/** GameOver constructor.
	 * 
	 * @param points - the amount of points the user had before winning/losing.
	 * @param time  - the time it took the user to win/lose.
	 */
	public GameOver(int points, String time, boolean won, Pictures Pics) {
		super("Game over"); // initiating the frame
		getContentPane().setBackground(new Color(0, 0, 0)); // setting the frame's background and bounds
		setBounds(0, 0, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false); 

		if (won==true) {
			LblWinner = new JLabel("YOU WON!"); // "YOU WON!" label
			LblWinner.setBounds(200, 85, 400, 70); // setting the bounds of the label
		}
		else {
			LblWinner = new JLabel("You lost :("); // "You lost :(" label
			LblWinner.setBounds(150, 85, 500, 70); // setting the bounds of the label
		}
		LblWinner.setFont(new Font("Stencil", Font.PLAIN, 80)); // setting the font, the background and the foreground 
		LblWinner.setBackground(new Color(255, 255, 255));

		LblWinner.setForeground(SystemColor.text);
		getContentPane().add(LblWinner); // adding "YOU WON!" to the frame

		LblSteps = new JLabel("Points: " + points); // "Steps: " label, steps is the amount of step the user had done
		LblSteps.setBounds(30, 250, 220, 40); // setting the font, the background, the foreground and the size
		LblSteps.setForeground(new Color(255, 255, 255));
		LblSteps.setFont(new Font("Tahoma", Font.BOLD, 30));
		LblSteps.setBackground(Color.BLACK);
		getContentPane().add(LblSteps); // adding "Steps:" to the frame

		LblTime = new JLabel("Time: "+time); // "Time: " label, time is the time it took the user to win
		LblTime.setBounds(30, 340, 313, 40); // setting the font, the background, the foreground and the size
		LblTime.setForeground(Color.WHITE);
		LblTime.setFont(new Font("Tahoma", Font.BOLD, 30));
		LblTime.setBackground(Color.BLACK);
		getContentPane().add(LblTime); // adding "Time:" to the frame

		BtnPlayAgain = new JButton("Play again"); // "Play again" button
		BtnPlayAgain.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { // in case play again button is pressed, starting a new game
				Boards b = new Boards(); // initializing the option of the board
				Menu window = new Menu(Pics, b); // initializing Menu
				window.setVisible(true); // setting Menu as visible
				dispose(); // closing the window when the button is pressed
			}
		});
		BtnPlayAgain.setBackground(Color.BLACK); // setting the font, the background, the foreground and the size
		BtnPlayAgain.setFont(new Font("Tahoma", Font.BOLD, 30));
		BtnPlayAgain.setForeground(Color.WHITE);
		BtnPlayAgain.setBounds(30, 480, 190, 50);
		BtnPlayAgain.setFocusable(false);
		getContentPane().add(BtnPlayAgain); // adding BtnExit to the frame
		validate();

		BtnExit = new JButton("Exit"); // "Exit" button
		BtnExit.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				dispose(); // closing the window when the button is pressed
			}
		});
		BtnExit.setBackground(Color.BLACK); // setting the font, the background, the foreground and the size
		BtnExit.setFont(new Font("Tahoma", Font.BOLD, 30));
		BtnExit.setForeground(Color.WHITE);
		BtnExit.setBounds(570, 480, 190, 50);
		BtnExit.setFocusable(false);
		getContentPane().add(BtnExit); // adding BtnExit to the frame
		validate();

		if (won==true) { // in case the user won, adding fireworks to the background
			LblFireworks = new JLabel(""); // the label in which the fireworks will be shown
			LblFireworks.setBounds(0, 0, 800, 600); // setting the label's bounds
			Image resizedImage = Pics.getGameOverPic(0).getImage().getScaledInstance(800, 600, 0); // cutting the fireworks' image
			Pics.getGameOverPic(0).setImage(resizedImage); 
			LblFireworks.setIcon(Pics.getGameOverPic(0)); // setting the label's icon to be the fireworks
			getContentPane().add(LblFireworks); // adding the label to the frame
			validate();
		}
		else {// in case the user lost
			LblCrying = new JLabel(""); // the label in which the fireworks will be shown
			LblCrying.setBounds(300, 180, 460, 280); // setting the label's bounds
			Image resizedImage = Pics.getGameOverPic(1).getImage().getScaledInstance(460, 280, 0); // cutting the fireworks' image
			Pics.getGameOverPic(1).setImage(resizedImage); 
			LblCrying.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			LblCrying.setIcon(Pics.getGameOverPic(1)); // setting the label's icon to be the fireworks
			getContentPane().add(LblCrying); // adding the label to the frame
			validate();
		}

		setVisible(true);
	}
}