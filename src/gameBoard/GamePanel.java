package GameBoard;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Ghosts.Blinky;
import Ghosts.Freaky;
import Ghosts.Ghost;
import Ghosts.Ginkey;
import Ghosts.Inky;
import Ghosts.Pinky;
import GhostsWeapons.FireBalls;
import GhostsWeapons.WaterSplash;
import Timer.MyTimer;
import Timer.TimerListener;
import Collections.Pictures;
import Food.EnergyPill;
import Food.Pineapple;
import Food.Apple;
import Food.Strawberry;
import Food.Batteries;
import Food.Cherry;
import Pacman.Pacman;
import Pacman.Pacman1;
import Pacman.Pacman2;
import Pacman.Pacman3;
import Windows.GameFrame;
import Windows.GameOver;

public class GamePanel extends JPanel implements KeyListener, TimerListener{
	private GameFrame Frame;
	private Pictures Pics;
	private int[][] BoardGame;
	private EnergyPill[] EnergyPill1;
	private Pineapple[] Pineapple1;
	private Apple[] Apple1;	
	private Cherry[] Cherry1;	
	private Batteries[] Batteries1;
	private Strawberry[] Strawberry1;

	private int PixelSize = 20; // the size of the pixels in the board
	private final int FOOD=1, WALL=3, PATH=5;
	

	private Pacman Pacman;
	private Pacman1 Pacman1;
	private Pacman2 Pacman2;
	private Pacman3 Pacman3;
	private Ghost[] Ghost;
	private Ginkey Ginkey; 
	private Inky Inky;
	private Blinky Blinky;
	private Pinky Pinky;
	private Freaky Freaky;

	
	private int Sec=0; // the time that passed
	private int NumOfNormalPills=0;
	private static String StringTime="00:00:00";
	private boolean StartGame=false; // whether the game started
	private boolean SpeedGame=false;

	/**
	 * GamePanel's constructor.
	 * 
	 * @param g - the Frame of the game.
	 * @param life - the amount of lives Pacman has.
	 * @param chosenBoard - the board that was chosen.
	 */
	public GamePanel (GameFrame g, int chosenBoard) {
		this.Frame=g;
		this.BoardGame = g.getBoards().getBoard(chosenBoard);
		this.Pics=g.getPics();
		setPreferredSize(new Dimension(800, 800));
		addKeyListener(this);
		setFocusable(true);
		setRequestFocusEnabled(true);
		MyTimer.getInstance().add(this);
		Pacman=new Pacman1();	
		Pacman1=(Pacman1) Pacman;
		Ginkey=new Ginkey(19,19,this); 
		Inky=new Inky(19,18,this); 
		Blinky=new Blinky(19,20,this); 
		Pinky=new Pinky(19,21,this);
		Freaky=new Freaky(19,17,this);
		updateGhost();
		initFruits();
	}

	private void updateGhost() {
		Ghost = new Ghost[5];
		Ghost[0]=Ginkey;
		Ghost[1]=Inky;
		Ghost[2]=Blinky;
		Ghost[3]=Pinky;
		Ghost[4]=Freaky;
	}


	/**
	 * This class initiates the food that is on the board.
	 */
	private void initFruits() {
		if (this.Pacman.getLevel()==1) {

			EnergyPill1=new EnergyPill[4];
			Pineapple1=new Pineapple[2];
			Apple1=new Apple[2];
			Cherry1=new Cherry[1];
			Batteries1=new Batteries[1];
			Strawberry1=new Strawberry[1];

			EnergyPill1[0]=new EnergyPill(1, 1, this, true);
			EnergyPill1[1]=new EnergyPill(1, 38, this, true);
			EnergyPill1[2]=new EnergyPill(38, 1, this, true);
			EnergyPill1[3]=new EnergyPill(38, 38, this, true);
			Pineapple1[0]=new Pineapple(this);
			Pineapple1[1]=new Pineapple(this);
			Apple1[0]=new Apple(this);
			Apple1[1]=new Apple(this);	
			Cherry1[0]=new Cherry(this);	
			Batteries1[0]=new Batteries(this);
			Strawberry1[0]=new Strawberry(this);


		}
		else if(this.Pacman.getLevel()==2) {
			EnergyPill1=new EnergyPill[4];
			Pineapple1=new Pineapple[4];
			Apple1=new Apple[4];
			Cherry1=new Cherry[1];
			Batteries1=new Batteries[1];
			Strawberry1=new Strawberry[1];
			EnergyPill1[0]=new EnergyPill(1, 1, this, true);
			EnergyPill1[1]=new EnergyPill(1, 38, this, true);
			EnergyPill1[2]=new EnergyPill(38, 1, this, true);
			EnergyPill1[3]=new EnergyPill(38, 38, this, true);
			Pineapple1[0]=new Pineapple(this);
			Pineapple1[1]=new Pineapple(this);
			Pineapple1[2]=new Pineapple(this);
			Pineapple1[3]=new Pineapple(this);
			Apple1[0]=new Apple(this);
			Apple1[1]=new Apple(this);
			Apple1[2]=new Apple(this);
			Apple1[3]=new Apple(this);
			Cherry1[0]=new Cherry(this);
			Batteries1[0]= new Batteries(this);
			Strawberry1[0]=new Strawberry(this);

		}
		else {
			EnergyPill1=new EnergyPill[4];
			Pineapple1=new Pineapple[5];
			Apple1=new Apple[5];
			Cherry1=new Cherry[1];
			Batteries1=new Batteries[1];
			Strawberry1=new Strawberry[2];
			EnergyPill1[0]=new EnergyPill(1, 1, this, true);
			EnergyPill1[1]=new EnergyPill(1, 38, this, true);
			EnergyPill1[2]=new EnergyPill(38, 1, this, true);
			EnergyPill1[3]=new EnergyPill(38, 38, this, true);
			Pineapple1[0]=new Pineapple(this);
			Pineapple1[1]=new Pineapple(this);
			Pineapple1[2]=new Pineapple(this);
			Pineapple1[3]=new Pineapple(this);
			Pineapple1[4]=new Pineapple(this);
			Apple1[0]=new Apple(this);
			Apple1[1]=new Apple(this);
			Apple1[2]=new Apple(this);
			Apple1[3]=new Apple(this);
			Apple1[4]=new Apple(this);
			Cherry1[0]=new Cherry(this);
			Batteries1[0]=new Batteries(this);
			Strawberry1[0]=new Strawberry(this);
			Strawberry1[1]=new Strawberry(this);

		}
	}

	/**
	 * This method paints the components of the game
	 * 
	 */
	public void paint(Graphics g) {
		super.paintComponent(g);
		Image offIm = createImage(800, 800);
		Graphics g2 = offIm.getGraphics();
		int counter=0;

		for(int i=0; i<this.BoardGame.length; i++) 
			for(int j=0; j<this.BoardGame.length; j++) {
				if (this.BoardGame[i][j]==WALL) { // wall
					g2.drawImage(this.Frame.getPics().getBlockPic(0).getImage(), this.PixelSize*j, this.PixelSize*i, this.PixelSize, this.PixelSize, null);
				}
				else if (this.BoardGame[i][j]==PATH) { // path
					g2.setColor(Color.BLACK);
					g2.fillRect(j*PixelSize, i*PixelSize, PixelSize, PixelSize);
				}
				else if (this.BoardGame[i][j]==FOOD) { // food
					counter++;
					g2.drawImage(this.Frame.getPics().getFoodPic(0).getImage(), this.PixelSize*j, this.PixelSize*i, this.PixelSize, this.PixelSize, null);
				}
				if (i==18 && j==19) // the gate
					g2.drawImage(this.Frame.getPics().getBlockPic(1).getImage(), this.PixelSize*j, this.PixelSize*i, this.PixelSize, this.PixelSize, null);
			}
		this.NumOfNormalPills=counter; // updating the amount of normalPills that are still in the board
		if (this.Sec%10==0) // changing the fruits position every ten seconds
			setFoodShown(); 

		// drawing Pacman, the ghosts, the ghosts weapons & the food 
		paintFruits(g2);

		g2.drawImage(this.Pacman.getImage().getImage(), this.PixelSize*this.Pacman.getY(), this.PixelSize*this.Pacman.getX(), this.PixelSize, this.PixelSize, null);
		g2.drawImage(this.Inky.getImage().getImage(), this.PixelSize*this.Inky.getY(), this.PixelSize*this.Inky.getX(), this.PixelSize, this.PixelSize, null);
		g2.drawImage(this.Blinky.getImage().getImage(), this.PixelSize*this.Blinky.getY(), this.PixelSize*this.Blinky.getX(), this.PixelSize, this.PixelSize, null);
		g2.drawImage(this.Ginkey.getImage().getImage(), this.PixelSize*this.Ginkey.getY(), this.PixelSize*this.Ginkey.getX(), this.PixelSize, this.PixelSize, null);
		g2.drawImage(this.Pinky.getImage().getImage(), this.PixelSize*this.Pinky.getY(), this.PixelSize*this.Pinky.getX(), this.PixelSize, this.PixelSize, null);
		g2.drawImage(this.Freaky.getImage().getImage(), this.PixelSize*this.Freaky.getY(), this.PixelSize*this.Freaky.getX(), this.PixelSize, this.PixelSize, null);

		if (this.Blinky.getChase()==true && this.Blinky.getFireBalls().getStartMoving()==true) // adding the weapons
			g2.drawImage(this.Blinky.getFireBalls().getImage().getImage(), this.PixelSize*this.Blinky.getFireBalls().getY(), this.PixelSize*this.Blinky.getFireBalls().getX(), this.PixelSize, this.PixelSize, null);
		if (this.Inky.getChase()==true && this.Inky.getWaterSplash().getStartMoving()==true) 
			g2.drawImage(this.Inky.getWaterSplash().getImage().getImage(), this.PixelSize*this.Inky.getWaterSplash().getY(), this.PixelSize*this.Inky.getWaterSplash().getX(), this.PixelSize, this.PixelSize, null);

		// changing the texts that are shown to the user
		this.Frame.setTextTime(StringTime); // changing the time that is shown to to user
		this.Pacman.setSecTime(this.Sec);
		this.Frame.setTextPoints(this.Pacman.getPoints()); // changing the amount of points that are shown to the user 
		this.Frame.setTextLives(this.Pacman.getLives()); // changing the amount of lives that are shown to the user 
		this.Frame.setTextFruits(this.Pacman.getFruits()); // changing the amount of fruits that are shown to the user 

		if (this.StartGame==false) // if the game didn't start
			showGetReady(); // showing the "Get ready" text

		g.drawImage(offIm, 0, 0, this);
	}


	/**
	 * This method paints the fruits on the panel.
	 * @param g2 -the graphics
	 */
	private void paintFruits(Graphics g2) {
		for (int i=0; i<EnergyPill1.length; i++)  //adding the energy pills
			if (EnergyPill1[i].getEaten()==false && EnergyPill1[i].getShown()==true) 
				g2.drawImage(this.EnergyPill1[i].getImage(0).getImage(), this.PixelSize*this.EnergyPill1[i].getY(), this.PixelSize*this.EnergyPill1[i].getX(), this.PixelSize, this.PixelSize, null);

		int k=1; // if k=1- showing the fading gif, if k=0- showing the fruit's picture
		if (this.Sec%10<=3)
			k=0;

		for (int i=0; i<Pineapple1.length; i++)  //adding the energy pills
			if (Pineapple1[i].getEaten()==false && Pineapple1[i].getShown()==true) 
				if (this.Sec%10==1)	{  
					g2.setColor(Color.BLACK);
					g2.fillRect(this.PixelSize*this.Pineapple1[i].getY(), this.PixelSize*this.Pineapple1[i].getX(), PixelSize, PixelSize);
				}
				else
					g2.drawImage(this.Pineapple1[i].getImage(k).getImage(), this.PixelSize*this.Pineapple1[i].getY(), this.PixelSize*this.Pineapple1[i].getX(), this.PixelSize, this.PixelSize, null);

		for (int i=0; i<Apple1.length; i++)  //adding the Apple1
			if (Apple1[i].getEaten()==false && Apple1[i].getShown()==true) 
				if (this.Sec%10==1)	{  
					g2.setColor(Color.BLACK);
					g2.fillRect(this.PixelSize*this.Apple1[i].getY(), this.PixelSize*this.Apple1[i].getX(), PixelSize, PixelSize);
				}
				else
					g2.drawImage(this.Apple1[i].getImage(k).getImage(), this.PixelSize*this.Apple1[i].getY(), this.PixelSize*this.Apple1[i].getX(), this.PixelSize, this.PixelSize, null);

		for (int i=0; i<Strawberry1.length; i++)  //adding the Strawberry1
			if (Strawberry1[i].getEaten()==false && Strawberry1[i].getShown()==true) 
				if (this.Sec%10==1)	{  
					g2.setColor(Color.BLACK);
					g2.fillRect(this.PixelSize*this.Strawberry1[i].getY(), this.PixelSize*this.Strawberry1[i].getX(), PixelSize, PixelSize);
				}
				else
					g2.drawImage(this.Strawberry1[i].getImage(k).getImage(), this.PixelSize*this.Strawberry1[i].getY(), this.PixelSize*this.Strawberry1[i].getX(), this.PixelSize, this.PixelSize, null);

		for (int i=0; i<Batteries1.length; i++)  //adding the energy pills
			if (Batteries1[i].getEaten()==false && Batteries1[i].getShown()==true) 
				if (this.Sec%10==1)	{  
					g2.setColor(Color.BLACK);
					g2.fillRect(this.PixelSize*this.Batteries1[i].getY(), this.PixelSize*this.Batteries1[i].getX(), PixelSize, PixelSize);
				}
				else
					g2.drawImage(this.Batteries1[i].getImage(k).getImage(), this.PixelSize*this.Batteries1[i].getY(), this.PixelSize*this.Batteries1[i].getX(), this.PixelSize, this.PixelSize, null);

		for (int i=0; i<Cherry1.length; i++)  //adding the energy pills
			if (Cherry1[i].getEaten()==false && Cherry1[i].getShown()==true) 
				if (this.Sec%10==1)	{  
					g2.setColor(Color.BLACK);
					g2.fillRect(this.PixelSize*this.Cherry1[i].getY(), this.PixelSize*this.Cherry1[i].getX(), PixelSize, PixelSize);
				}
				else
					g2.drawImage(this.Cherry1[i].getImage(k).getImage(), this.PixelSize*this.Cherry1[i].getY(), this.PixelSize*this.Cherry1[i].getX(), this.PixelSize, this.PixelSize, null);
	}


	private void showGetReady() {
		JTextField TextGetReady= new JTextField("GET READY");;
		TextGetReady.setBackground(SystemColor.inactiveCaptionBorder);
		TextGetReady.setForeground(SystemColor.activeCaptionText);
		TextGetReady.setFont(new Font("Tahoma", Font.BOLD, 20));
		TextGetReady.setForeground(Color.WHITE);
		TextGetReady.setEditable(false);
		TextGetReady.setBounds(300,410,180,30);
		TextGetReady.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		TextGetReady.setBackground(Color.BLACK);
		TextGetReady.setHorizontalAlignment(SwingConstants.CENTER);
		TextGetReady.setFocusable(false);
		this.add(TextGetReady);
	}



	/**
	 * This function finds a random place (that is not a wall) for every food (except for the energy pills)
	 * & sets it to shown.
	 */
	private void setFoodShown() {
		for (int i=0; i<this.Apple1.length; i++) {
			Apple1[i].setFoodShown();
		}
		for (int i=0; i<this.Pineapple1.length; i++) {
			Pineapple1[i].setFoodShown();
		}
		for (int i=0; i<this.Batteries1.length; i++) {
			Batteries1[i].setFoodShown();
		}
		for (int i=0; i<this.Strawberry1.length; i++) {
			Strawberry1[i].setFoodShown();
		}
		for (int i=0; i<this.Cherry1.length; i++) {
			Cherry1[i].setFoodShown();
		}

	}

	/**
	 * This function listens to the keys,
	 * in order to start the game the user must press on the "space".
	 * 
	 */
	public void keyPressed(KeyEvent e) {
		if (this.Frame.getPause()==false) { // if the user stopped the game, stopping the Pacman from moving 
			if (e.getKeyCode() == KeyEvent.VK_SPACE) { // space starts the game
				this.StartGame=true;
				this.Pacman.setStartMoving(true);
			}
			// checking if the game started and if Pacman is frozen
			if(this.StartGame && this.Pacman.getFreezeCounter()==0) {
				/*
				 * Checking which way the user wants to go, after that checking if that way has food, if so, 
				 * updating the amount of food the Pacman ate and the board, and moving Pacman.
				 * if that way doesn't have food, moving Pacman to a path.
				 */
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					if (this.BoardGame[Pacman.getX()][Pacman.getY()-1]==FOOD) {
						this.BoardGame[Pacman.getX()][Pacman.getY()-1]=PATH;
						Pacman.setY(Pacman.getY()-1);
						this.Pacman.setPoints(this.Pacman.getPoints()+10);
					}
					else if(this.BoardGame[Pacman.getX()][Pacman.getY()-1]==PATH) 
						Pacman.setY(Pacman.getY()-1);

				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					if (this.BoardGame[Pacman.getX()][Pacman.getY()+1]==FOOD) {
						this.BoardGame[Pacman.getX()][Pacman.getY()+1]=PATH;
						Pacman.setY(Pacman.getY()+1);
						this.Pacman.setPoints(this.Pacman.getPoints()+10);
					}	
					else if (this.BoardGame[Pacman.getX()][Pacman.getY()+1]==PATH)
						Pacman.setY(Pacman.getY()+1);

				if (e.getKeyCode() == KeyEvent.VK_UP)
					if (this.BoardGame[Pacman.getX()-1][Pacman.getY()]==FOOD) {
						this.BoardGame[Pacman.getX()-1][Pacman.getY()]=PATH;
						Pacman.setX(Pacman.getX()-1);
						this.Pacman.setPoints(this.Pacman.getPoints()+10);
					}
					else if (this.BoardGame[Pacman.getX()-1][Pacman.getY()]==PATH)
						Pacman.setX(Pacman.getX()-1);

				if (e.getKeyCode() == KeyEvent.VK_DOWN)
					if (this.BoardGame[Pacman.getX()+1][Pacman.getY()]==FOOD) {
						this.BoardGame[Pacman.getX()+1][Pacman.getY()]=PATH;
						Pacman.setX(Pacman.getX()+1);
						this.Pacman.setPoints(this.Pacman.getPoints()+10);
					}
					else if (this.BoardGame[Pacman.getX()+1][Pacman.getY()]==PATH)
						Pacman.setX(Pacman.getX()+1);

				checkFood();

				repaint();
			}
		}
	}

	/**
	 * This function checks which creature can attack, and makes sure that those who can, do.
	 * DO WE NEED TO CHECK IF THEY'RE FROZZEN??
	 * 
	 */
	private void checkAttack() {
		for (int i=0; i<Ghost.length; i++) {
			if (this.Ghost[i].getStartMoving() && checkPositionGhost(Ghost[i])) // if Blinky is out of the cage & he's at the same spot as Pacman
				if (Pacman.getLevel()==1)
					this.Ghost[i].visit(this.Pacman1); // Blinky visits Pacman1
				else if (Pacman.getLevel()==2)
					this.Ghost[i].visit(this.Pacman2); // Blinky visits Pacman2
				else 
					this.Ghost[i].visit(this.Pacman3); // Blinky visits Pacman3
		}
		if (this.Inky.getWaterSplash().getStartMoving() && Pacman.getX()==this.Inky.getWaterSplash().getX() && Pacman.getY()==this.Inky.getWaterSplash().getY()) {// if inky can move, and 10 seconds have passed, since the last time inky attacked with the water splash
			if (this.Pacman.getLevel()==2) {
				this.Inky.getWaterSplash().visit(this.Pacman2);
			}
		}
		else if (this.Blinky.getFireBalls().getStartMoving() && Pacman.getX()==this.Blinky.getFireBalls().getX() && Pacman.getY()==this.Blinky.getFireBalls().getY()) // if Blinky can move, and 10 seconds have passed, since the last time Blinky attacked with the water splash
			if (this.Pacman.getLevel()==3)
				this.Blinky.getFireBalls().visit(this.Pacman3);



	}


	/**
	 * This function checks if Pacman can eat something
	 * 
	 */
	private void checkFood() {
		for (int i=0; i<this.EnergyPill1.length; i++)
			if (EnergyPill1[i].getEaten()==false && this.Pacman.getX()==this.EnergyPill1[i].getX() && this.Pacman.getY()==this.EnergyPill1[i].getY()) 
			{
				Pacman.setPoints(Pacman.getPoints()+50);
				this.EnergyPill1[i].Eated();
			}
		for (int i=0; i<this.Pineapple1.length; i++)
			if (Pineapple1[i].getEaten()==false && this.Pacman.getX()==this.Pineapple1[i].getX() && this.Pacman.getY()==this.Pineapple1[i].getY())
			{
				Pacman.setPoints(Pacman.getPoints()+100);
				Pacman.setFruits(Pacman.getFruits()+1);
				this.Pineapple1[i].Eated();
			}
		for (int i=0; i<this.Apple1.length; i++)
			if (Apple1[i].getEaten()==false && this.Pacman.getX()==this.Apple1[i].getX() && this.Pacman.getY()==this.Apple1[i].getY())
			{
				Pacman.setPoints(Pacman.getPoints()+200);
				Pacman.setFruits(Pacman.getFruits()+1);
				this.Apple1[i].Eated();
			}
		for (int i=0; i<this.Strawberry1.length; i++)
			if (Strawberry1[i].getEaten()==false && this.Pacman.getX()==this.Strawberry1[i].getX() && this.Pacman.getY()==this.Strawberry1[i].getY())
			{
				Pacman.setPoints(Pacman.getPoints()+300);
				Pacman.setFruits(Pacman.getFruits()+1);
				this.Strawberry1[i].Eated();
			}
		for (int i=0; i<this.Cherry1.length; i++)
			if (Cherry1[i].getEaten()==false && this.Pacman.getX()==this.Cherry1[i].getX() && this.Pacman.getY()==this.Cherry1[i].getY())
			{
				Pacman.setPoints(Pacman.getPoints()+400);
				Pacman.setFruits(Pacman.getFruits()+1);
				this.Cherry1[i].Eated();
			}
		for (int i=0; i<this.Batteries1.length; i++)
			if (Batteries1[i].getEaten()==false && this.Pacman.getX()==this.Batteries1[i].getX() && this.Pacman.getY()==this.Batteries1[i].getY())
			{
				Pacman.setLives(Pacman.getLives()+1);
				this.Batteries1[i].Eated();
			}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * This function checks if ghost and Pacman are in the dame spot.
	 * 
	 * @return wheter ghost and Pacman are in the same spot.
	 */
	private boolean checkPositionGhost(Ghost ghost) {
		if (Pacman.getX()==ghost.getX() && Pacman.getY()==ghost.getY()) 
			return true;
		return false;
	}

	/**
	 * This function checks if the gust can move to the given position.
	 * 
	 * @param i - the position that is being checked.
	 * @param j - the position that is being checked.
	 * @return - whether the gust can move to the given positoin.
	 */
	public boolean canMove(int i, int j) {
		if (this.BoardGame[i][j]!=WALL)
			return true;
		return false;
	}

	/**
	 * This method is active every second.
	 * paints the current position of the game and checks if the user finished the level. 
	 */
	@Override
	public void action() {
		checkAttack(); // checking which creature can attack

		if (Frame.isSpeedChanged()) {
			if (SpeedGame==false) 
				fastMotion();
			else
				slowMotion();
			SpeedGame=!SpeedGame;
		}
		if (this.StartGame) {
			Sec++;
			getTime(Sec);
			repaint();
			if (isLooser()) {
				MyTimer.getInstance().stopTimer();
				new GameOver(this.Pacman.getPoints(), GamePanel.StringTime, false, this.Pics);
				this.Frame.dispose();
			}
			else if (this.Pacman.getLives()>0 && this.NumOfNormalPills==0) { // if the user finished the current level
				if (isWinner()) { // if the user won
					MyTimer.getInstance().stopTimer();
					new GameOver(this.Pacman.getPoints(), GamePanel.StringTime, true, this.Pics);
					this.Frame.dispose();
				}
				else { // if there is another level to play
					paintNextLevel();
				}
			}
		}

	}

	/**
	 * This function paints the new panel with the new board.
	 */
	private void paintNextLevel(){
		if (this.Pacman.getLevel()==1) {
			this.StartGame=false;
			this.Pacman.setStartMoving(false);
			this.Pacman=new Pacman2(this.Pacman.getLives(), this.Pacman.getPoints(), this.Pacman.getFruits(), this.Pacman.getSecTime());
			Pacman2=(Pacman2) Pacman;
			SetBoard(5);
			this.Frame.setTextLevel(2); // changing the level that is shown to the user 
			newGame();
		}
		else if (this.Pacman.getLevel()==2){
			this.StartGame=false;
			this.Pacman.setStartMoving(false);
			this.Pacman=new Pacman3(this.Pacman.getLives(), this.Pacman.getPoints(), this.Pacman.getFruits(), this.Pacman.getSecTime());
			Pacman3=(Pacman3)Pacman;
			SetBoard(6);
			this.Frame.setTextLevel(3); // changing the level that is shown to the user 
			newGame();
		}
	}

	private void SetBoard(int num) {
		this.BoardGame=this.Frame.getBoards().getBoard(num);
	}

	private void newGame() {
		Ginkey=new Ginkey(19,19,this); 
		Inky=new Inky(19,18,this); 
		Blinky=new Blinky(19,20,this); 
		Pinky=new Pinky(19,21,this);
		Freaky=new Freaky(19,17,this);
		initFruits();// reset fruits
	}

	/**
	 * This function checks if the user won, if so, returns true.
	 * The user wins, when Pacman still has lives and the level is 3.
	 *
	 * @return - whether the user won.
	 */
	private boolean isWinner() {
		if (this.Pacman.getLevel()==3 && this.Pacman.getLives()>0) {
			return true;
		}
		return false;
	}

	/**
	 * This function checks if the user lost, if so, returns true.
	 * The user loses, when Pacman doesn't have any lives.
	 *
	 * @return - whether the user lost.
	 */
	private boolean isLooser() {
		if (this.Pacman.getLives()<=0)
			return true;
		return false;
	}

	/**
	 * This function returns Frame.
	 * 
	 * @return - Frame.
	 */
	public GameFrame getFrame() {
		return this.Frame;
	}

	/**
	 * Calculate the timer and return a string that represents timer
	 * by the formula: HH:MM:SS
	 * 
	 * @param numSec - the seconds count
	 * @return string that represents the time.
	 */
	private static String getTime(int numSec) {

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
		StringTime=time; // updating StringTime

		return time;
	}

	/**
	 * This function makes the ghosts go faster
	 */
	private void fastMotion() {
		Ginkey.setSpeed(Ginkey.getSpeed()/2);
		Inky.setSpeed(Inky.getSpeed()/2);
		Blinky.setSpeed(Blinky.getSpeed()/2);
		Freaky.setSpeed(Freaky.getSpeed()/2);
		Pinky.setSpeed(Pinky.getSpeed()/2);
	}
	/**
	 * This function makes the ghosts go slower
	 */
	private void slowMotion() {
		Ginkey.setSpeed(Ginkey.getSpeed()*2);
		Inky.setSpeed(Inky.getSpeed()*2);
		Blinky.setSpeed(Blinky.getSpeed()*2);
		Freaky.setSpeed(Freaky.getSpeed()*2);
		Pinky.setSpeed(Pinky.getSpeed()*2);
	}



	/**
	 * This function finds a path for fireBalls.
	 * FireBalls go threw walls.
	 * 
	 * @param fireBalls
	 * @return an array- in index=0- which direction fireBalls needs to go,
	 * in index 1- how many steps it needs to make. 
	 */
	public int[] getFireBallsPath(FireBalls fireBalls) {
		int UP=0,DOWN=1,LEFT=2,RIGHT=3;
		int[] path=new int[2];
		if (fireBalls.getX()==this.Pacman.getX()) {
			if (fireBalls.getY()>this.Pacman.getY()) {
				path[0]=LEFT;
				path[1]=fireBalls.getY()-this.Pacman.getY();
			}
			else {
				path[0]=RIGHT;
				path[1]=this.Pacman.getY()-fireBalls.getY();
			}
		}
		else if (fireBalls.getY()==this.Pacman.getY()) {
			if (fireBalls.getX()>this.Pacman.getX()) {
				path[0]=UP;
				path[1]=fireBalls.getX()-this.Pacman.getX();
			}
			else {
				path[0]=DOWN;
				path[1]=this.Pacman.getX()-fireBalls.getX();
			}
		}
		else if (Math.abs(fireBalls.getX()-this.Pacman.getX()) < Math.abs(fireBalls.getY()-this.Pacman.getY())){
			if (fireBalls.getX()>this.Pacman.getX()) {
				path[0]=UP;
				path[1]=fireBalls.getX()-this.Pacman.getX();
			}
			else {
				path[0]=DOWN;
				path[1]=this.Pacman.getX()-fireBalls.getX();
			}
		}
		else {
			if (fireBalls.getY()>this.Pacman.getY()) {
				path[0]=LEFT;
				path[1]=fireBalls.getY()-this.Pacman.getY();
			}
			else {
				path[0]=RIGHT;
				path[1]=this.Pacman.getY()-fireBalls.getY();
			}
		}
		return path;
	}


	/**
	 * This function finds a path for waterSplash.
	 * 
	 * @param waterSplash
	 * @return an array- in index=0- which direction waterSplash needs to go,
	 * in index 1- how many steps it needs to make. 
	 */
	public int[] getWaterSplashPath(WaterSplash waterSplash) {
		int UP=0,DOWN=1,LEFT=2,RIGHT=3;
		Random rand = new Random();
		int[] path=new int[2];
		if (waterSplash.getX()==this.Pacman.getX()) {
			if (waterSplash.getY()>this.Pacman.getY()) 
				path[0]=LEFT;
			else 
				path[0]=RIGHT;
		}
		else if (waterSplash.getY()==this.Pacman.getY()) {
			if (waterSplash.getX()>this.Pacman.getX()) 
				path[0]=UP;
			else 
				path[0]=DOWN;
		}
		else {
			int n=rand.nextInt(4);
			path[0]=n;
		}
		path[1]=findWall(path[0], waterSplash.getX(), waterSplash.getY());
		return path;
	}


	/**
	 * This function finds the closest wall to the given indexes from the given side,
	 * and returns how many step need to be done in order to get to it.
	 * 
	 * @param side
	 * @param indexX
	 * @param indexY
	 * @return - how many step need to be done in order to get to the closest wall from the given indexes.
	 */
	private int findWall(int side, int indexX, int indexY) {
		int UP=0,DOWN=1,LEFT=2,RIGHT=3;
		int foundWall=0;
		if (side==RIGHT) {
			for (int i=indexY; i<this.BoardGame.length; i++)
				if (canMove(indexX, i)) 
					foundWall++;
		}
		else if (side==LEFT) {
			for (int i=indexY; i>=0; i--)
				if (canMove(indexX, i))
					foundWall++;
		}
		else if (side==DOWN) {
			for (int i=indexX; i<this.BoardGame.length; i++)
				if (canMove(i, indexY))
					foundWall++;
		}
		else { // up
			for (int i=indexX; i>=0; i--)
				if (canMove(i, indexY))
					foundWall++;
		}
		return foundWall-1;
	}



	/**
	 * Getters & setters.
	 */


	@Override
	public int getSpeed() {
		return 1;
	}

	public int getPoints() {
		return Pacman.getPoints();
	}

	public int getSec() {
		return this.Sec;
	}

	public void resetSec() {
		this.Sec=0;
		StringTime="00:00:00";
		
	}

	public boolean PacmanXBigger(Ghost ghost) {
		if (this.Pacman.getX()>ghost.getX())
			return true;
		return false;
	}

	public boolean PacmanYBigger(Ghost ghost) {
		if (this.Pacman.getY()>ghost.getY())
			return true;
		return false;
	}
}

