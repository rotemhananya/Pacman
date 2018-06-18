package windows;

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

import collections.Boards;
import collections.Pictures;
import gameBoard.GamePanel;
import timer.MyTimer;
import timer.TimerListener;

/**
 * This class represents the window of the game. 
 * This window has text fields & buttons for the user's convenience and the gamePanel- which it the game board.
 *
 */
public class GameFrame extends JFrame implements TimerListener{
	private Boards boards; // the boards collection
	private Pictures pics; // the pictures collection
	private int chosenBoard; // the number of the board that the user chose
	private JPanel game; // the game panel (/the game board)
	private JTextField textTime;
	private JTextField textPoints;
	private JTextField textFruits;
	private JTextField textLives;
	private boolean fastMotion=false;
	private boolean pause=false;

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

		this.boards = b;
		this.pics = p;
		this.chosenBoard = chosenBoard;
		MyTimer.getInstance(1).add(this);

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
				new Menu(pics, new Boards()); // opening the menu window
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
				if (pause==true) {
					pause=false;// pause game
					MyTimer.getInstance(1).startTimer();
				}	
				else {
					pause=true;
					MyTimer.getInstance(1).stopTimer();
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
				if (fastMotion) {
					fastMotion=false;
					MyTimer.getInstance(1).setTimersDelay(1);
				}
				else {
					fastMotion=true;
					MyTimer.getInstance(1).setTimersDelay(7);
				} 
			}
		});
		btnSpeed.setBackground(SystemColor.inactiveCaptionBorder);
		btnSpeed.setForeground(SystemColor.activeCaptionText);
		btnSpeed.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSpeed.setBounds(0, 0, 180, 50);
		btnSpeed.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnSpeed.setFocusable(false);
		pnlSpeed.add(btnSpeed); // adding the button to the "pnlSpeed" panel

		textTime = new JTextField("Time: 00:00:00"); // the text filed that holds how much time had passed
		textTime.setBackground(SystemColor.inactiveCaptionBorder);
		textTime.setForeground(SystemColor.activeCaptionText);
		textTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		textTime.setEditable(false);
		textTime.setBounds(10, 310, 180, 50);
		textTime.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textTime.setHorizontalAlignment(SwingConstants.CENTER);
		textTime.setFocusable(false);
		pnlToolBar.add(textTime); // adding the text field to the "pnlToolBar" panel

		textPoints = new JTextField("Points: 0"); // the text filed that holds how many points the user has
		textPoints.setBackground(SystemColor.inactiveCaptionBorder);
		textPoints.setForeground(SystemColor.activeCaptionText);
		textPoints.setFont(new Font("Tahoma", Font.BOLD, 20));
		textPoints.setEditable(false);
		textPoints.setBounds(10, 380, 180, 50);
		textPoints.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textPoints.setHorizontalAlignment(SwingConstants.CENTER);
		textPoints.setFocusable(false);
		pnlToolBar.add(textPoints); // adding the text field to the "pnlToolBar" panel

		textFruits = new JTextField("Fruits: 0"); // the text filed that holds how many fruits the user collected
		textFruits.setBackground(SystemColor.inactiveCaptionBorder);
		textFruits.setForeground(SystemColor.activeCaptionText);
		textFruits.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFruits.setEditable(false);
		textFruits.setBounds(10, 450, 180, 50);
		textFruits.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textFruits.setHorizontalAlignment(SwingConstants.CENTER);
		textFruits.setFocusable(false);
		pnlToolBar.add(textFruits); // adding the text field to the "pnlToolBar" panel

		textLives = new JTextField("Lives: 3"); // the text filed that holds how many lives the user has
		textLives.setBackground(SystemColor.inactiveCaptionBorder);
		textLives.setForeground(SystemColor.activeCaptionText);
		textLives.setFont(new Font("Tahoma", Font.BOLD, 20));
		textLives.setEditable(false);
		textLives.setBounds(10, 520, 180, 50);
		textLives.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textLives.setHorizontalAlignment(SwingConstants.CENTER);
		textLives.setFocusable(false);
		pnlToolBar.add(textLives); // adding the text field to the "pnlToolBar" panel

		GridBagConstraints gbc_toolBar = new GridBagConstraints(); // the GridBagConstraints that holds gbc_toolBar 
		gbc_toolBar.fill = GridBagConstraints.BOTH;
		getContentPane().add(toolBar, gbc_toolBar); // adding toolBar to gbc_toolBar

		this.game=new GamePanel(this, 3, chosenBoard); // creating a new game panel 
		GridBagConstraints gbc_gamePanel = new GridBagConstraints();
		gbc_gamePanel.insets = new Insets(10, 10, 10, 10);
		gbc_gamePanel.fill = GridBagConstraints.BOTH;
		gbc_gamePanel.gridx = 2;
		gbc_gamePanel.gridy = 0;
		getContentPane().add(this.game, gbc_gamePanel); // adding this game panel to gbc_gamePanel

		setVisible(true);
	}

	/**
	 * This function returns boards.
	 * 
	 * @return this boards.
	 */
	public Boards getBoards() {
		return this.boards;
	}

	/**
	 * This function returns pics.
	 * 
	 * @return this pics.
	 */
	public Pictures getPics() {
		return this.pics;
	}

	/**
	 * This function returns chosenBoard.
	 * 
	 * @return this chosenBoard.
	 */
	public int getChosenBoard() {
		return this.chosenBoard;
	}

	/**
	 * This function sets the time that is shown to the user.
	 * 
	 * @param time - the new time that needs to be shown to the user.
	 */
	public void setTextTime(String time) {
		this.textTime.setText("Time: "+time); 
	}

	/**
	 * This function sets the amount of points that is shown to the user.
	 * 
	 * @param points - the new amount of points that needs to be shown to the user.
	 */
	public void setTextPoints(int points) {
		this.textPoints.setText("Points: "+points); 
	}

	/**
	 * This function sets the amount of fruits that is shown to the user.
	 * 
	 * @param fruits - the new amount of fruits that needs to be shown to the user.
	 */
	public void setTextFruits(int fruits) {
		this.textFruits.setText("Fruits: "+fruits); 
	}

	/**
	 * This function sets the amount of lives that is shown to the user.
	 * 
	 * @param lives - the new amount of lives that needs to be shown to the user.
	 */
	public void setTextLives(int lives) {
		this.textLives.setText("Lives: "+lives);
	}

	/**
	 * This function returns whether the game needs to be in fast motion or not.
	 * 
	 * @return - whether the game needs to be in fast motion or not.
	 */
	public boolean getFastMotion() {
		return this.fastMotion;
	}

	/**
	 * This function returns whether the game needs to be paused or not.
	 * 
	 * @return - whether the game needs to be paused or not.
	 */
	public boolean getPause() {
		return this.pause;
	}

	@Override
	public void action() {

	}
}
