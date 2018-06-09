package hw4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class BoardGame extends JFrame implements KeyListener, TimerListener {

	private Boards boards;
	private Pictures pics ;

	private Image gameImage;
	private Pacman pacman = new Pacman(17, 19);
	private Creature [] enemys= new Creature[3];
	private Ginkey ginky;
	private Inky inky;
	private Blinky blinky=new Blinky(19,20,this.boardGame); 
	private int[][] boardGame;
	private int boardSize = 800;
	private int PixeleSize = 20;
	private int life;
	private int level;
	private int points=0;
	private int Sec=0; // the time that passed.
	private int numOfFood=0;
	private int wall=3;
	private int path=5;
	private int food=1;

	public BoardGame (Boards boards, Pictures pics,int [][] boardGame, int life) {
		super ("Pacman");
		MyTimer.getInstance().add(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.life=life;
		setSize(boardSize,boardSize);
		setMinimumSize(new Dimension(boardSize, boardSize));
		setMaximumSize(new Dimension(boardSize, boardSize));
		this.boards=boards;
		this.pics=pics;
		this.boardGame = boardGame;
		this.blinky.setBoards(boardGame);
		setVisible(true);
		setResizable(false);
		addKeyListener(this);
		setFocusable(true);
		//this.enemys[0]=new Ginkey();
		//this.enemys[1]=new Inky();

	}

	/**
	 * This method paints the components of the game
	 * @param n - the index of the component
	 */

	public void paint(Graphics g) {
		Image offIm = createImage(boardSize, boardSize);
		Graphics g2 = offIm.getGraphics();
		numOfFood=0;
		for(int i=0; i<this.boardGame.length; i++) 
			for(int j=0; j<this.boardGame.length; j++) {
				if (i==this.pacman.getX() && j==this.pacman.getY()) { // pacman
					g2.setColor(Color.YELLOW);
					g2.fillOval(j*PixeleSize, i*PixeleSize, PixeleSize, PixeleSize);
				}
				else if (this.boardGame[i][j]==wall) { // wall
					g2.setColor(Color.GRAY);
					g2.fillRect(j*PixeleSize, i*PixeleSize, PixeleSize, PixeleSize);
				}
				else if (this.boardGame[i][j]==path) { // path
					g2.setColor(Color.WHITE);
					g2.fillRect(j*PixeleSize, i*PixeleSize, PixeleSize, PixeleSize);
				}
				else if (this.boardGame[i][j]==food) { // food
					numOfFood++;
					g2.setColor(Color.LIGHT_GRAY);
					g2.fillOval(j*PixeleSize, i*PixeleSize, PixeleSize, PixeleSize);
				}
				if (i==this.blinky.getX() && j==this.blinky.getY()) { // blinky
					g2.setColor(Color.RED);
					g2.fillOval(j*PixeleSize, i*PixeleSize, PixeleSize, PixeleSize);
				} 
			}
		gameImage=offIm;
		g.drawImage(offIm, 0, 0, this);


	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			if (this.boardGame[pacman.getX()][pacman.getY()-1]==food) {
				this.boardGame[pacman.getX()][pacman.getY()-1]=path;
				pacman.moveY(pacman.getY()-1);
				this.points+=10;
				this.numOfFood-=1;
			}
			else if(this.boardGame[pacman.getX()][pacman.getY()-1]==path) 
				pacman.moveY(pacman.getY()-1);

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			if (this.boardGame[pacman.getX()][pacman.getY()+1]==food) {
				this.boardGame[pacman.getX()][pacman.getY()+1]=path;
				pacman.moveY(pacman.getY()+1);
				this.points+=10;
				this.numOfFood-=1;
			}	
			else if (this.boardGame[pacman.getX()][pacman.getY()+1]==path)
				pacman.moveY(pacman.getY()+1);

		if (e.getKeyCode() == KeyEvent.VK_UP)
			if (this.boardGame[pacman.getX()-1][pacman.getY()]==food) {
				this.boardGame[pacman.getX()-1][pacman.getY()]=path;
				pacman.moveX(pacman.getX()-1);
				this.points+=10;
				this.numOfFood-=1;
			}
			else if (this.boardGame[pacman.getX()-1][pacman.getY()]==path)
				pacman.moveX(pacman.getX()-1);

		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			if (this.boardGame[pacman.getX()+1][pacman.getY()]==food) {
				this.boardGame[pacman.getX()+1][pacman.getY()]=path;
				pacman.moveX(pacman.getX()+1);
				this.points+=10;
				this.numOfFood-=1;
			}
			else if (this.boardGame[pacman.getX()+1][pacman.getY()]==path)
				pacman.moveX(pacman.getX()+1);

		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyTyped(KeyEvent e) {

	}



	/**
	 * This method checks if the pacman stands behind a monster
	 * @return if the position is valid 
	 */
	private boolean checkPosition() {
		if (boardGame[pacman.getX()][pacman.getY()]==boardGame[blinky.getX()][blinky.getY()]) {
			return false;
		}
		else if(boardGame[pacman.getX()][pacman.getY()]==boardGame[ginky.getX()][ginky.getY()]) {
			return false;
		}
		else if (boardGame[pacman.getX()][pacman.getY()]==boardGame[inky.getX()][inky.getY()]) {
			return false;
		}
		else return true;
	}


	private boolean checkPosition(int x, int y, int way) {

		return false;
	}


	private void gameOver() {
		String time="kill me already"; 
		Pictures pics = new Pictures();
		if (isNextLevel()) {
			if (isWinner())
				new GameOver(points, time, true);
			else
				paintNextLevel();
		}
		else if (isLooser())
			new GameOver(points, time, false);
	}

	private boolean isNextLevel() {
		if (numOfFood==0) {
			return true;
		}
		return false;
	}

	private void paintNextLevel(){

	}

	private boolean isWinner() {
		if (level==3) {
			return true;
		}
		return false;
	}


	private boolean isLooser() {
		if (life==0)
			return true;
		return false;
	}

	/**
	 * This method is active every second.
	 * paints the current position of the game and checks if the user finished the level. 
	 */
	@Override
	public void action() {
		Sec++;
		repaint();
		if (checkPosition()) {
			life--;
			if (isLooser()) {
				
			}
		}
		else if (isNextLevel()) { // if the user finished the current level
			if (isWinner()) // if the user is a winner
				new GameOver(points, time, true);
			else { // if there is another level to play
				paintNextLevel();
				dispose();
			}
		}
	}


}

