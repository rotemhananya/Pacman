package gameBoard;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import collections.Pictures;
import creatures.Blinky;
import creatures.EnergyPills;
import creatures.Ginkey;
import creatures.Inky;
import creatures.Pacman;
import timer.MyTimer;
import timer.TimerListener;
import windows.GameFrame;
import windows.GameOver;

public class GamePanel extends JPanel implements KeyListener, TimerListener{
	private GameFrame frame;
	private Pictures pics;
	private int[][] boardGame;
	private EnergyPills energyPills;
	private int boardSize = 800; // the size of the game's board
	private int PixelSize = 20; // the size of the pixels in the board
	private final int FOOD=1, WALL=3, PATH=5;
	
	private Pacman pacman = new Pacman(17, 19);
	private Ginkey ginkey; 
	private Inky inky;
	private Blinky blinky;

	private int Sec=0; // the time that passed
	private int numOfFood=240;
	private static String stringTime="00:00:00";
	private boolean startGame=false; // whether the game was started

	/**
	 * GamePanel's constructor.
	 * 
	 * @param g - the frame of the game.
	 * @param life - the amount of lives pacman has.
	 * @param chosenBoard - the board that was chosen.
	 */
	public GamePanel (GameFrame g, int life, int chosenBoard) {
		this.frame=g;
		this.boardGame = g.getBoards().getBoard(chosenBoard);
		this.pics=g.getPics();
		setPreferredSize(new Dimension(800, 800));
		addKeyListener(this);
		setFocusable(true);
		setRequestFocusEnabled(true);
		MyTimer.getInstance(1).add(this);
		ginkey=new Ginkey(19,19,this.boardGame); 
		inky=new Inky(19,18,this.boardGame); 
		blinky=new Blinky(19,20,this.boardGame); 
	}

	/**
	 * This method paints the components of the game
	 * 
	 */
	public void paint(Graphics g) {
		super.paintComponent(g);
		Image offIm = createImage(boardSize, boardSize);
		Graphics g2 = offIm.getGraphics();
		int counter=0;

		for(int i=0; i<this.boardGame.length; i++) 
			for(int j=0; j<this.boardGame.length; j++) {
				if (this.boardGame[i][j]==WALL) { // wall
					g2.setColor(Color.GRAY);
					g2.fillRect(j*PixelSize, i*PixelSize, PixelSize, PixelSize);
				}
				else if (this.boardGame[i][j]==PATH) { // path
					g2.setColor(Color.WHITE);
					g2.fillRect(j*PixelSize, i*PixelSize, PixelSize, PixelSize);
				}
				else if (this.boardGame[i][j]==FOOD) { // food
					counter++;
					g2.setColor(Color.LIGHT_GRAY);
					g2.fillOval(j*PixelSize, i*PixelSize, PixelSize, PixelSize);
				}

				this.frame.setTextTime(this.stringTime);
				this.pacman.setSecTime(Sec);

				if (this.Sec - this.pacman.getFreezeCounter()==5)
					this.pacman.setFreezeCounter(0);

				if (this.Sec - this.inky.getFreezeCounter()==5)
					this.inky.setFreezeCounter(0);

				if (this.Sec==7000) // releasing ginkey
					this.ginkey.setStartMoving(true); // green

				if (this.Sec==2000) // releasing inky
					this.inky.setStartMoving(true) ;//yellow

				if (this.Sec==1) // releasing blinky
					this.blinky.setStartMoving(true);//red

				// drawing pacman and the gusts 
				g2.drawImage(this.pacman.getImage().getImage(), this.PixelSize*this.pacman.getY(), this.PixelSize*this.pacman.getX(), this.PixelSize, this.PixelSize, null);
				g2.drawImage(this.inky.getImage().getImage(), this.PixelSize*this.inky.getY(), this.PixelSize*this.inky.getX(), this.PixelSize, this.PixelSize, null);
				g2.drawImage(this.blinky.getImage().getImage(), this.PixelSize*this.blinky.getY(), this.PixelSize*this.blinky.getX(), this.PixelSize, this.PixelSize, null);
				g2.drawImage(this.ginkey.getImage().getImage(), this.PixelSize*this.ginkey.getY(), this.PixelSize*this.ginkey.getX(), this.PixelSize, this.PixelSize, null);

			//	for (int n=0; n<energyPills.) // we need to add the energy pills
				
				this.numOfFood=counter; // updating the amount of food that is still in the board
			}

		this.frame.setTextPoints(this.pacman.getPoints()); // changing the amount of points that are shown to the user 
		this.frame.setTextLives(this.pacman.getLives()); // changing the amount of lives that are shown to the user 
		this.frame.setTextFruits(this.pacman.getFruits()); // changing the amount of lives that are shown to the user 

		g.drawImage(offIm, 0, 0, this);
	}

	/**
	 * This function listens to the keys,
	 * in order to start the game the user must press on the "space".
	 * 
	 */
	public void keyPressed(KeyEvent e) {
		if (this.frame.getPause()==false) { // if the user stopped the game, stopping the pacman from moving 
			if (e.getKeyCode() == KeyEvent.VK_SPACE) { // space starts the game
				this.startGame=true;
				this.pacman.setStartMoving(true);
			}
			// checking if the game started and if pacman is frozen
			if(this.startGame && this.pacman.getFreezeCounter()==0) {
				/*
				 * Checking which way the user wants to go, after that checking if that way has food, if so, 
				 * updating the amount of food the pacman ate and the board, and moving pacman, if not, moving pacman
				 */
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					if (this.boardGame[pacman.getX()][pacman.getY()-1]==FOOD) {
						this.boardGame[pacman.getX()][pacman.getY()-1]=PATH;
						pacman.setY(pacman.getY()-1);
						this.pacman.setPoints(this.pacman.getPoints()+10);
					}
					else if(this.boardGame[pacman.getX()][pacman.getY()-1]==PATH) 
						pacman.setY(pacman.getY()-1);

				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					if (this.boardGame[pacman.getX()][pacman.getY()+1]==FOOD) {
						this.boardGame[pacman.getX()][pacman.getY()+1]=PATH;
						pacman.setY(pacman.getY()+1);
						this.pacman.setPoints(this.pacman.getPoints()+10);
					}	
					else if (this.boardGame[pacman.getX()][pacman.getY()+1]==PATH)
						pacman.setY(pacman.getY()+1);

				if (e.getKeyCode() == KeyEvent.VK_UP)
					if (this.boardGame[pacman.getX()-1][pacman.getY()]==FOOD) {
						this.boardGame[pacman.getX()-1][pacman.getY()]=PATH;
						pacman.setX(pacman.getX()-1);
						this.pacman.setPoints(this.pacman.getPoints()+10);
					}
					else if (this.boardGame[pacman.getX()-1][pacman.getY()]==PATH)
						pacman.setX(pacman.getX()-1);

				if (e.getKeyCode() == KeyEvent.VK_DOWN)
					if (this.boardGame[pacman.getX()+1][pacman.getY()]==FOOD) {
						this.boardGame[pacman.getX()+1][pacman.getY()]=PATH;
						pacman.setX(pacman.getX()+1);
						this.pacman.setPoints(this.pacman.getPoints()+10);
					}
					else if (this.boardGame[pacman.getX()+1][pacman.getY()]==PATH)
						pacman.setX(pacman.getX()+1);
				
				this.blinky.setPacmanX(this.pacman.getX());
				this.blinky.setPacmanY(this.pacman.getY());
				
				checkAttack(); // checking which creature can attack
				
				repaint();
			}
		}
	}

	/**
	 * This function checks which creature can attack, and makes sure that those who can, do.
	 * 
	 */
	private void checkAttack() {
		if (this.blinky.getStartMoving() && checkPositionBlinky()) // if blinky is out of the cage & he's at the same spot as pacman
			this.blinky.visit(this.pacman); // blinky visits pacman

		if (this.ginkey.getStartMoving() && checkPositionGinkey()) // if ginkey is out of the cage & he's at the same spot as pacman
			this.ginkey.visit(this.pacman); // ginkey visits pacman

		if (this.inky.getStartMoving() && checkPositionInky())  // if inky is out of the cage & he's at the same spot as pacman
			this.inky.visit(this.pacman); // inky visits pacman

		if (this.inky.getStartMoving() && this.Sec % 10 == 0) // if inky can move, and 10 seconds have passed, since the last time inky attacked with the water splash
			this.inky.getWaterSplash().visit(this.pacman);
			
		if (this.blinky.getStartMoving() && this.Sec % 10 == 0) // if blinky can move, and 10 seconds have passed, since the last time blinky attacked with the water splash
			this.blinky.getFireBalls().visit(this.pacman);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * This function checks if Blinky and pacman are in the dame spot.
	 * 
	 * @return wheter Blinky and pacman are in the same spot.
	 */
	private boolean checkPositionBlinky() {
		if (pacman.getX()==blinky.getX() && pacman.getY()==blinky.getY()) 
			return true;
		return false;
	}

	/**
	 * This function checks if ginkey and pacman are in the dame spot.
	 * 
	 * @return wheter ginkey and pacman are in the same spot.
	 */
	private boolean checkPositionGinkey() {
		if (pacman.getX()==ginkey.getX() && pacman.getY()==ginkey.getY()) 
			return true;
		return false;
	}

	/**
	 * This function checks if inky and pacman are in the dame spot.
	 * 
	 * @return wheter inky and pacman are in the same spot.
	 */
	private boolean checkPositionInky() {
		if (pacman.getX()==inky.getX() && pacman.getY()==inky.getY()) 
			return true;
		return false;
	}

	/**
	 * This method is active every second.
	 * paints the current position of the game and checks if the user finished the level. 
	 */
	@Override
	public void action() {
		if (this.startGame) {
			Sec++;
			String time = getTime(Sec);
			repaint();
			if (isLooser()) {
				new GameOver(this.pacman.getPoints(), this.stringTime, false, this.pics);
				this.frame.dispose();
			}
			else if (this.pacman.getLives()>0 && this.numOfFood==0) { // if the user finished the current level
				if (isWinner()) { // if the user won
					new GameOver(this.pacman.getPoints(), this.stringTime, true, this.pics);
					this.frame.dispose();
				}
				else { // if there is another level to play
					paintNextLevel();
					//dispose();
				}
			}
		}
	}

	/**
	 * This function paints the new panel with the new board.
	 */
	private void paintNextLevel(){
		if (this.pacman.getLevel()==1) {
			this.pacman.setLevel(2);
			new GamePanel(this.frame, this.pacman.getLives(), 5);
		}
		else  {
			this.pacman.setLevel(3);
			new GamePanel(this.frame, this.pacman.getLives(), 6);
		}
	}

	/**
	 * This function checks if the user won, if so, returns true.
	 * The user wins, when pacman still has lives and the level is 3.
	 *
	 * @return - whether the user won.
	 */
	private boolean isWinner() {
		if (this.pacman.getLevel()==3 && this.pacman.getLives()>0) {
			return true;
		}
		return false;
	}

	/**
	 * This function checks if the user lost, if so, returns true.
	 * The user loses, when pacman doesn't have any lives.
	 *
	 * @return - whether the user lost.
	 */
	private boolean isLooser() {
		if (this.pacman.getLives()==0)
			return true;
		return false;
	}

	/**
	 * This function returns pacman.
	 * 
	 * @return - pacman.
	 */
	public Pacman getPacman() {
		return this.pacman;
	}

	/**
	 * Calculate the timer and return a string that represents timer
	 * by the formula: HH:MM:SS
	 * 
	 * @param numSec - the seconds count
	 * @return string that represents the time.
	 */
	static String getTime(int numSec) {
		//Separate timer to hours, minutes and seconds . 
		int hours = 0;
		int checkMinSec = 0;
		int minutes = 0;
		int seconds = 0;

		if (numSec >= 3600) // in case of more then hour .   
		{
			hours = numSec / 3600;        // update the hours value.
			checkMinSec = numSec % 3600;  // calculate the time that rest

			if (checkMinSec >= 60)   //in case of more then a minute.
			{
				minutes = checkMinSec / 60; // update the minutes value.
				seconds = checkMinSec % 60;  // update the seconds value. 
			}
			else // in case of seconds (less then a minute)
			{                       
				seconds = checkMinSec; // update the seconds value.
			}
		}
		// in case of more then a minute.
		else if (numSec >= 60)                
		{
			hours = 0;              
			minutes = numSec / 60;
			seconds = numSec % 60;
		}
		//in case of seconds only.
		else if (numSec < 60)
		{
			hours = 0;
			minutes = 0;
			seconds = numSec;
		}
		//convert the time to string

		String strHours;
		String strMins; 
		String strSecs; 

		if(seconds < 10) // in case of one digit of seconds
			strSecs = "0" + Integer.toString(seconds);
		else // in case of more then one digit of seconds
			strSecs = Integer.toString(seconds);

		if(minutes < 10)// in case of one digit of minutes
			strMins = "0" + Integer.toString(minutes);
		else // in case of more then one digit of minutes
			strMins = Integer.toString(minutes);

		if(hours < 10) // in case of one digit of hours
			strHours = "0" + Integer.toString(hours);
		else // in case of more then one digit of hours
			strHours = Integer.toString(hours);


		String time = strHours + ":" + strMins + ":" + strSecs; // string to return
		stringTime=time; // updating stringTime

		return time;
	}
}

