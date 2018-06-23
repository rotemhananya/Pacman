package Windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import Timer.MyTimer;
import Collections.Boards;
import Collections.Pictures;
import GameBoard.GamePanel;

/**
 * This class represents the window of the game. 
 * This window has text fields & buttons for the user's convenience and the gamePanel- which it the game board.
 *
 */
public class GameFrame extends JFrame{
	private Boards Boards; // the boards collection
	private Pictures Pics; // the pictures collection
	private int ChosenBoard; // the number of the board that the user chose
	private JPanel Game; // the game panel (/the game board)
	private JTextField TextTime;
	private JTextField TextPoints;
	private JTextField TextFruits;
	private JTextField TextLives;
	private JTextField TextLevel;
	private boolean SpeedChanged=false;
	private boolean Pause=false;
	
	/**
	 * GameFrame's constructor.
	 * this function initializes the buttons, the text fields and the game panel.
	 * 
	 * @param b - the class that holds board's options.
	 * @param p - the class that holds all of the pictures that are used during the game.
	 * @param chosenBoard - the board that the user is playing with.
	 */
	public GameFrame(Boards b, Pictures p, int chosenBoard) {
		super("Pacman");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 1060, 840); // the size of the window

		this.Boards = b;
		this.Pics = p;
		this.ChosenBoard = chosenBoard;

		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 220, 10, 820, 10 };
		gridBagLayout.rowHeights = new int[] { 840, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JToolBar toolBar = new JToolBar(); // the tool bar that holds the buttons & text fields
		toolBar.setBackground(SystemColor.inactiveCaptionBorder);

		JPanel pnlToolBar = new JPanel(); // the panel that holds the buttons & text fields
		pnlToolBar.setBackground(SystemColor.inactiveCaptionBorder);
		toolBar.add(pnlToolBar); // adding the tool bar "pnlToolBar" panel
		pnlToolBar.setLayout(null);
		pnlToolBar.setOpaque(true);

		JPanel pnlReturn = new JPanel(); // the panel that holds the return button
		pnlReturn.setLayout(null);
		pnlReturn.setBounds(10, 30, 180, 50);
		pnlToolBar.add(pnlReturn); // adding the panel to the "pnlToolBar" panel
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() { // when the button is pressed opening the Menu window
			public void actionPerformed(ActionEvent e) {
				((GamePanel) Game).resetSec();
				new Menu(Pics, new Boards()); // opening the menu window
				dispose(); // closing the game window
			}
		});
		btnReturn.setBackground(SystemColor.inactiveCaptionBorder);
		btnReturn.setForeground(SystemColor.activeCaptionText);
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReturn.setBounds(0, 0, 180, 50);
		btnReturn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnReturn.setFocusable(false); 
		pnlReturn.add(btnReturn); // adding the button to the "pnlReturn" panel

		JPanel pnlPause = new JPanel(); // the panel that holds the pause button
		pnlPause.setLayout(null);
		pnlPause.setBounds(10, 100, 180, 50);
		pnlToolBar.add(pnlPause); // adding the panel to the "pnlToolBar" panel
		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() { // when the button is pressed pausing the game
			public void actionPerformed(ActionEvent e) {
				if (Pause==true) {
					Pause=false;// pause game
					btnPause.setText("Pause");
					MyTimer.getInstance().startTimer();
				}	
				else {
					Pause=true;
					btnPause.setText("Continue");
					MyTimer.getInstance().stopTimer();
				}
			}
		});
		btnPause.setBackground(SystemColor.inactiveCaptionBorder);
		btnPause.setForeground(SystemColor.activeCaptionText);
		btnPause.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPause.setBounds(0, 0, 180, 50);
		btnPause.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnPause.setFocusable(false);
		pnlPause.add(btnPause);  // adding the button to the "pnlPause" panel

		JPanel pnlExit = new JPanel(); // the panel that holds btnExit
		pnlExit.setLayout(null);
		pnlExit.setBounds(10, 170, 180, 50);
		pnlToolBar.add(pnlExit); // adding the panel to the "pnlToolBar" panel
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() { // when the button is pressed closing the game window
			public void actionPerformed(ActionEvent arg0) {
				dispose(); // closing the game window
			}
		});
		btnExit.setBackground(SystemColor.inactiveCaptionBorder);
		btnExit.setForeground(SystemColor.activeCaptionText);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBounds(0, 0, 180, 50);
		btnExit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnExit.setFocusable(false);
		pnlExit.add(btnExit); // adding the button to the "pnlExit" panel

		JPanel pnlSpeed = new JPanel(); // the panel that holds btnSpeed
		pnlSpeed.setLayout(null);
		pnlSpeed.setBounds(10, 240, 180, 50);
		pnlToolBar.add(pnlSpeed); // adding the panel to the "pnlToolBar" panel
		JButton btnSpeed = new JButton("Fast motion");
		btnSpeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  // when the button is pressed going into fast motion
				SpeedChanged=true;
			}});
		btnSpeed.setBackground(SystemColor.inactiveCaptionBorder);
		btnSpeed.setForeground(SystemColor.activeCaptionText);
		btnSpeed.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSpeed.setBounds(0, 0, 180, 50);
		btnSpeed.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnSpeed.setFocusable(false);
		pnlSpeed.add(btnSpeed); // adding the button to the "pnlSpeed" panel

		TextTime = new JTextField("Time: 00:00:00"); // the text filed that holds how much time had passed
		TextTime.setBackground(SystemColor.inactiveCaptionBorder);
		TextTime.setForeground(SystemColor.activeCaptionText);
		TextTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		TextTime.setEditable(false);
		TextTime.setBounds(10, 310, 180, 50);
		TextTime.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		TextTime.setHorizontalAlignment(SwingConstants.CENTER);
		TextTime.setFocusable(false);
		pnlToolBar.add(TextTime); // adding the text field to the "pnlToolBar" panel

		TextPoints = new JTextField("Points: 0"); // the text filed that holds how many points the user has
		TextPoints.setBackground(SystemColor.inactiveCaptionBorder);
		TextPoints.setForeground(SystemColor.activeCaptionText);
		TextPoints.setFont(new Font("Tahoma", Font.BOLD, 20));
		TextPoints.setEditable(false);
		TextPoints.setBounds(10, 380, 180, 50);
		TextPoints.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		TextPoints.setHorizontalAlignment(SwingConstants.CENTER);
		TextPoints.setFocusable(false);
		pnlToolBar.add(TextPoints); // adding the text field to the "pnlToolBar" panel

		TextFruits = new JTextField("Fruits: 0"); // the text filed that holds how many fruits the user collected
		TextFruits.setBackground(SystemColor.inactiveCaptionBorder);
		TextFruits.setForeground(SystemColor.activeCaptionText);
		TextFruits.setFont(new Font("Tahoma", Font.BOLD, 20));
		TextFruits.setEditable(false);
		TextFruits.setBounds(10, 450, 180, 50);
		TextFruits.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		TextFruits.setHorizontalAlignment(SwingConstants.CENTER);
		TextFruits.setFocusable(false);
		pnlToolBar.add(TextFruits); // adding the text field to the "pnlToolBar" panel

		TextLives = new JTextField("Lives: 3"); // the text filed that holds how many lives the user has
		TextLives.setBackground(SystemColor.inactiveCaptionBorder);
		TextLives.setForeground(SystemColor.activeCaptionText);
		TextLives.setFont(new Font("Tahoma", Font.BOLD, 20));
		TextLives.setEditable(false);
		TextLives.setBounds(10, 520, 180, 50);
		TextLives.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		TextLives.setHorizontalAlignment(SwingConstants.CENTER);
		TextLives.setFocusable(false);
		pnlToolBar.add(TextLives); // adding the text field to the "pnlToolBar" panel

		TextLevel = new JTextField("Level: 1"); // the text filed that holds the level
		TextLevel.setBackground(SystemColor.inactiveCaptionBorder);
		TextLevel.setForeground(SystemColor.activeCaptionText);
		TextLevel.setFont(new Font("Tahoma", Font.BOLD, 20));
		TextLevel.setEditable(false);
		TextLevel.setBounds(10, 590, 180, 50);
		TextLevel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		TextLevel.setHorizontalAlignment(SwingConstants.CENTER);
		TextLevel.setFocusable(false);
		pnlToolBar.add(TextLevel); // adding the text field to the "pnlToolBar" panel
		GridBagConstraints gbc_toolBar = new GridBagConstraints(); // the GridBagConstraints that holds gbc_toolBar 
		gbc_toolBar.fill = GridBagConstraints.BOTH;
		getContentPane().add(toolBar, gbc_toolBar); // adding toolBar to gbc_toolBar

		this.Game=new GamePanel(this, chosenBoard); // creating a new game panel 
		GridBagConstraints gbc_gamePanel = new GridBagConstraints();
		gbc_gamePanel.insets = new Insets(10, 10, 10, 10);
		gbc_gamePanel.fill = GridBagConstraints.BOTH;
		gbc_gamePanel.gridx = 2;
		gbc_gamePanel.gridy = 0;
		getContentPane().add(this.Game, gbc_gamePanel); // adding this game panel to gbc_gamePanel

		setVisible(true);
	}


	/**
	 * This function returns boards.
	 * 
	 * @return this boards.
	 */
	public Boards getBoards() {
		return this.Boards;
	}

	/**
	 * This function returns pics.
	 * 
	 * @return this pics.
	 */
	public Pictures getPics() {
		return this.Pics;
	}

	/**
	 * This function returns chosenBoard.
	 * 
	 * @return this chosenBoard.
	 */
	public int getChosenBoard() {
		return this.ChosenBoard;
	}

	/**
	 * This function sets the time that is shown to the user.
	 * 
	 * @param time - the new time that needs to be shown to the user.
	 */
	public void setTextTime(String time) {
		this.TextTime.setText("Time: "+time); 
	}

	/**
	 * This function sets the amount of points that is shown to the user.
	 * 
	 * @param points - the new amount of points that needs to be shown to the user.
	 */
	public void setTextPoints(int points) {
		this.TextPoints.setText("Points: "+points); 
	}

	/**
	 * This function sets the amount of fruits that is shown to the user.
	 * 
	 * @param fruits - the new amount of fruits that needs to be shown to the user.
	 */
	public void setTextFruits(int fruits) {
		this.TextFruits.setText("Fruits: "+fruits); 
	}

	/**
	 * This function sets the amount of lives that is shown to the user.
	 * 
	 * @param lives - the new amount of lives that needs to be shown to the user.
	 */
	public void setTextLives(int lives) {
		this.TextLives.setText("Lives: "+lives);
	}

	/**
	 * This function sets the level that is shown to the user.
	 * 
	 * @param level - the new level that needs to be shown to the user.
	 */
	public void setTextLevel(int level) {
		this.TextLevel.setText("Level: "+level);
	}
	
	/**
	 * This function returns whether the speed was changed
	 * @return if the speed changed
	 */
	public boolean isSpeedChanged() {
		if (SpeedChanged==true) {
			SpeedChanged=false;
			return true;
		}
		return SpeedChanged;
	}

	/**
	 * This function returns whether the game needs to be paused or not.
	 * 
	 * @return - whether the game needs to be paused or not.
	 */
	public boolean getPause() {
		return this.Pause;
	}
}
