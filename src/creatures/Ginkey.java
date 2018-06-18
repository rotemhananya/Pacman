package creatures;

import java.util.Random;
import javax.swing.ImageIcon;
import timer.MyTimer;
import timer.TimerListener;
import visitInterface.Visitor;

/**
 * This class represents the gust Ginkey.
 *
 */
public class Ginkey extends Creature implements TimerListener, Visitor {
	private ImageIcon im = new ImageIcon("GINKEY.png");
	private double speed = 5;
	private int x;
	private int y;

	private int[][] boardGame;
	private final static int WALL=3;
	private final static int UP=0,DOWN=1,LEFT=2,RIGHT=3;
	private boolean Startmoving=false;
	private int out=1; // the amount of moves that need to be done in order to leave the cage
	private boolean chase=false; // starting to chase after reaching the corner
	private int lastMove;
	private int freezeCounter=0;
	//private int radius;

	/**
	 * Ginkey's constructor.
	 * 
	 * @param x1 - Ginkey's position.
	 * @param y1 - Ginkey's position.
	 * @param board - the board of the game.
	 */
	public Ginkey (int x1, int y1, int [][]board) {
		MyTimer.getInstance((int) this.speed).add(this);
		this.boardGame=board;
		this.x=x1;
		this.y=y1;
	}

	/**
	 * This function makes sure that the gust moves.
	 */
	@Override
	public void action() {
		if (this.y==38 && this.x==1) // if Ginky reached the right corner
			this.chase=true;
		if (this.Startmoving==true)
			move(this.chase);
	}

	/**
	 * This function moves the gust.
	 * This function first makes sure that the gust is out of the cage, 
	 * then makes sure that it reaches the right corner,
	 * and then moves it randomly.
	 */
	public void move(boolean chase) {
		if (chase==false && this.out!=0) {
			if (this.out==1) 
				this.x-=1;
			this.out--;
			this.lastMove=UP;
		}
		else if (chase==false) // going to the right corner
			if (canMove(this.x, this.y+1)) //right
				this.y+=1;
			else if (canMove(this.x-1, this.y)) // up
				this.x-=1;
			else if (canMove(this.x, this.y-1)) // left
				this.y-=1;
			else  // down
				this.x+=1;  

		else if (this.freezeCounter==0) { // goes in a strait line until it reaches a wall, then moves to a random direction
			if (this.lastMove==UP && canMove(this.x-1, this.y)) {
				this.x-=1;
				this.lastMove=UP;
			}
			else if (this.lastMove==DOWN && canMove(this.x+1, this.y)) {
				this.x+=1;
				this.lastMove=DOWN;
			}
			else if (this.lastMove==RIGHT && canMove(this.x, this.y+1)) {
				this.y+=1;
				this.lastMove=RIGHT;
			}
			else if (this.lastMove==LEFT && canMove(this.x, this.y-1)) {
				this.y-=1;
				this.lastMove=LEFT;
			}
			else {
				Random rand = new Random();
				int n=rand.nextInt(4);
				if (n%4==0) {
					if (canMove(this.x+1, this.y)) {
						this.x+=1;
						this.lastMove=DOWN;
					}
					else if (canMove(this.x-1, this.y)) {
						this.x-=1;
						this.lastMove=UP;
					}
					else if (canMove(this.x, this.y+1)) {
						this.y+=1;
						this.lastMove=RIGHT;
					}
					else {
						this.y-=1;
						this.lastMove=LEFT;
					}
				}
				else if (n%4==1){
					if (canMove(this.x-1, this.y)) {
						this.x-=1;
						this.lastMove=UP;
					}
					else if (canMove(this.x, this.y+1)) {
						this.y+=1;
						this.lastMove=RIGHT;
					}
					else if (canMove(this.x, this.y-1)) {
						this.y-=1;
						this.lastMove=LEFT;
					}
					else {
						this.x+=1;
						this.lastMove=DOWN;
					}
				}
				else if (n%4==2){
					if (canMove(this.x, this.y+1)) {
						this.y+=1;
						this.lastMove=RIGHT;
					}
					else if (canMove(this.x, this.y-1)) {
						this.y-=1;
						this.lastMove=LEFT;
					}
					else if (canMove(this.x+1, this.y)) {
						this.x+=1;
						this.lastMove=DOWN;
					}
					else {
						this.x-=1;
						this.lastMove=UP;
					}
				}
				else {
					if (canMove(this.x, this.y-1)) {
						this.y-=1;
						this.lastMove=LEFT;
					}
					else if (canMove(this.x+1, this.y)) {
						this.x+=1;
						this.lastMove=DOWN;
					}
					else if (canMove(this.x-1, this.y)) {
						this.x-=1;
						this.lastMove=UP;
					}
					else { 
						this.y+=1;
						this.lastMove=RIGHT;
					}
				}
			}
		}
	}

	/**
	 * This function checks if the gust can move to the given position.
	 * 
	 * @param i - the position that is being checked.
	 * @param j - the position that is being checked.
	 * @return - whether the gust can move to the given positoin.
	 */
	private boolean canMove(int i, int j) {
		if (this.boardGame[i][j]!=WALL)
			return true;
		return false;
	}

	/**
	 * Ginkey visits pacman
	 * @Override
	 */
	public void visit(Pacman pacman) {
		if (this.chase==true)
			if (pacman.getLevel()==2) // level 1
				pacman.setLives(pacman.getLives()-1);
			else if (pacman.getLevel()==2 && this.freezeCounter==0) {
				this.freezeCounter=pacman.getSecTime(); //ginky disappears for 5 seconds
				this.im=null;
			}
			else { // level==3
				this.Startmoving=false;	//ginky dies
				this.x=0;
				this.y=0;
				this.im=null;
			}
	}

	/**
	 * Getters & setters.
	 */
	@Override
	public ImageIcon getImage() {
		return this.im;
	}

	@Override
	public double getSpeed() {
		return this.speed;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	public void setBoards(int [][]b) {
		this.boardGame=b;
	}

	public void setFreezeCounter (int time) {
		this.freezeCounter=time;
	}

	public int getFreezeCounter () {
		return this.freezeCounter;
	}

	public void setStartMoving (boolean start) {
		this.Startmoving=start;
	}

	public boolean getStartMoving () {
		return this.Startmoving;
	}

	@Override
	public void setSpeed(double speed) {
		this.speed=speed;		
	}
	/*
	public void setTimersDelay(int n) {
		MyTimer.getInstance().setTimersDelay((int) this.speed /n);
	}*/
}