package windows;

import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

import collections.Boards;
import collections.Pictures;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

/** This class represents the first window the user sees, when entering the game.
 * This class also has the main method.
 * In this window the user chooses the board that he wants to play in. 
 * 
 * @author Rotem Hananya
 * @author Noy Asis
 */
public class Menu extends JFrame implements ActionListener{

	private Boards boards; // the boards collection
	private Pictures pics;  // the pictures collection
	private JLabel lblLogo;
	private JTextField txtChooseABoard;
	private JRadioButton rdbtnOne;
	private JRadioButton rdbtnTwo;
	private JRadioButton rdbtnThree;
	private JRadioButton rdbtnFour;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblPic;
	private JButton btnExit;
	private JButton btnStart;
	private JLabel lblPacman;

	/** 
	 * Menu's constructor.
	 * this function calls initialize, in order to initialize the window.
	 * 
	 * @param pic - hold all of the pictures in Menu.
	 * @param board - all of the boards options.
	 * 
	 */
	public Menu(Pictures pics, Boards board) {
		super ("Menu");
		this.pics = pics;
		this.boards = board;
		initialize();
		this.setVisible(true);
	}

	/**
	 * This function initialize the contents of the frame and when the button "Start" is pressed, starts the game.
	 */
	private void initialize() {
		getContentPane().setBackground(Color.BLACK); 
		setBounds(0, 0, 800, 800); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // in order to close the program when the user exits
		getContentPane().setLayout(null);
		setResizable(false);

		lblLogo = new JLabel(""); // this label holds the logo of the game 
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblLogo.setBounds(100,30,600,200);
		ImageIcon imLogo = pics.getPic(0); // the first picture in pics is the game's logo 
		Image resizedImLogo = imLogo.getImage().getScaledInstance(600, 200, 0); // cutting the image
		imLogo.setImage(resizedImLogo);
		lblLogo.setIcon(imLogo); // changing lblLogo's icon
		getContentPane().add(lblLogo); // adding lblLogo to the frame
		validate();

		txtChooseABoard = new JTextField("Choose a board: ");
		txtChooseABoard.setBackground(new Color(0, 0, 0));
		txtChooseABoard.setForeground(new Color(173, 216, 230));
		txtChooseABoard.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtChooseABoard.setEditable(false); // in order to prevent the user from changing the text
		txtChooseABoard.setEnabled(false);
		txtChooseABoard.setBorder(BorderFactory.createEmptyBorder());
		txtChooseABoard.setBounds(60, 240, 260, 40);
		getContentPane().add(txtChooseABoard); // adding txtChooseABoard to the frame
		txtChooseABoard.setColumns(10);

		rdbtnOne = new JRadioButton("1");
		rdbtnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // changing the lblPic's icon to be the first pictures in pics 
				ImageIcon im1 = pics.getPic(1);
				Image resizedIm1 = im1.getImage().getScaledInstance(280, 280, 0); // cutting the image
				im1.setImage(resizedIm1);
				lblPic.setIcon(im1); // changing lblPic's icon
			}
		});
		buttonGroup.add(rdbtnOne); // adding rdbtnOne to buttonGroup 
		rdbtnOne.setBackground(new Color(0, 0, 0)); 
		rdbtnOne.setForeground(new Color(173, 216, 230));
		rdbtnOne.setFont(new Font("Tahoma", Font.BOLD, 30));
		rdbtnOne.setSelected(true); // in order to make sure, that there's always a chosen board
		rdbtnOne.setBounds(350, 240, 45, 40);
		getContentPane().add(rdbtnOne); // adding rdbtnOne to the frame

		rdbtnTwo = new JRadioButton("2");
		rdbtnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // changing the lblPic's icon to be the second pictures in pics 
				ImageIcon im2 = pics.getPic(2);
				Image resizedIm2 = im2.getImage().getScaledInstance(280, 280, 0); // cutting the image
				im2.setImage(resizedIm2);
				lblPic.setIcon(im2); // changing lblPic's icon
			}
		});
		buttonGroup.add(rdbtnTwo); // adding rdbtnTwo to buttonGroup 
		rdbtnTwo.setBackground(new Color(0, 0, 0));
		rdbtnTwo.setForeground(new Color(173, 216, 230));
		rdbtnTwo.setFont(new Font("Tahoma", Font.BOLD, 30));
		rdbtnTwo.setBounds(350, 290, 45, 40);
		getContentPane().add(rdbtnTwo); // adding rdbtnTwo to the frame

		rdbtnThree = new JRadioButton("3");
		rdbtnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // changing the lblPic's icon to be the third pictures in pics 
				ImageIcon im3 = pics.getPic(3);
				Image resizedIm3 = im3.getImage().getScaledInstance(280, 280, 0); // cutting the image
				im3.setImage(resizedIm3);
				lblPic.setIcon(im3); // changing lblPic's icon
			}
		});
		buttonGroup.add(rdbtnThree); // adding rdbtnThree to buttonGroup
		rdbtnThree.setBackground(new Color(0, 0, 0));
		rdbtnThree.setForeground(new Color(173, 216, 230));
		rdbtnThree.setFont(new Font("Tahoma", Font.BOLD, 30));
		rdbtnThree.setBounds(350, 340, 45, 40);
		getContentPane().add(rdbtnThree); // adding rdbtnThree to the frame

		rdbtnFour = new JRadioButton("4");
		rdbtnFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // changing the lblPic's icon to be the forth pictures in pics 
				ImageIcon im4 = pics.getPic(4);
				Image resizedIm4 = im4.getImage().getScaledInstance(280, 280, 0); // cutting the image
				im4.setImage(resizedIm4);
				lblPic.setIcon(im4); // changing lblPic's icon
			}
		});
		buttonGroup.add(rdbtnFour); // adding rdbtnFour to buttonGroup
		rdbtnFour.setBackground(new Color(0, 0, 0));
		rdbtnFour.setForeground(new Color(173, 216, 230));
		rdbtnFour.setFont(new Font("Tahoma", Font.BOLD, 30));
		rdbtnFour.setBounds(350, 390, 45, 40);
		getContentPane().add(rdbtnFour); // adding rdbtnFour to the frame
		validate();

		lblPic = new JLabel(""); // This label holds the picture of the chosen board (the board's number is the chosen radio button's number)
		lblPic.setBackground(new Color(238, 130, 238));
		lblPic.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230)));
		lblPic.setBounds(460, 240, 280, 280);
		ImageIcon im1 = pics.getPic(1); // since rdbtnOne is chosen by default, adding the pics[1] to the label
		Image resizedIm1 = im1.getImage().getScaledInstance(280, 280, 0); // cutting the image
		im1.setImage(resizedIm1);
		lblPic.setIcon(im1); // changing lblPic's icon
		getContentPane().add(lblPic); // adding lblPic to the frame 

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // closing the window when pressed
				dispose();
			}
		});
		btnExit.setForeground(new Color(173, 216, 230));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnExit.setBackground((Color) null);
		btnExit.setBounds(60, 550, 200, 50);
		getContentPane().add(btnExit); // adding btnExit to the frame

		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // Starting a new game with the chosen board and closing this window

				int chosenBoard;
				if (rdbtnOne.isSelected()) // checking which button is selected
					chosenBoard = 1;
				else if (rdbtnTwo.isSelected())
					chosenBoard = 2;
				else if (rdbtnThree.isSelected())
					chosenBoard = 3;
				else 
					chosenBoard = 4;
				new GameFrame(boards, pics, chosenBoard); // Starting a new game with the chosen board
				dispose(); // closing this window
			}
		});
		btnStart.setBackground(null);
		btnStart.setForeground(new Color(173, 216, 230));
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnStart.setBounds(540, 550, 200, 50);
		getContentPane().add(btnStart); // adding btnStart to the frame

		lblPacman = new JLabel("");  // this label holds a gif of pacman 
		lblPacman.setBounds(60,500,680,350);
		ImageIcon imPacman = pics.getPic(6);
		Image resizedImPacman = imPacman.getImage().getScaledInstance(680, 350, 0); // cutting the image
		imPacman.setImage(resizedImPacman);
		lblPacman.setIcon(imPacman); // changing lblPacman's icon
		getContentPane().add(lblPacman);  // adding lblPacman to the frame
	}

	/**
	 * This function Overrides actionPerformed.
	 * @Override
	 */
	public void actionPerformed(ActionEvent e) {

	}

	/**
	 * The main method in the game.
	 */
	public static void main(String[] args) {
		Pictures pic = new Pictures(); // initializing the picture's of the menu
		Boards b = new Boards(); // initializing the option of the board
		new Menu(pic, b); // initializing Menu
	}



}
