package creatures;

import java.util.Random;
import javax.swing.ImageIcon;
import timer.MyTimer;
import timer.TimerListener;
import visitInterface.Visitor;

/**
 * This class represents the gust Blinky.
 * Blinky has a weapon - fireballs.
 *
 */
public class Blinky extends Creature implements TimerListener, Visitor {
	private ImageIcon im = new ImageIcon("BLINKY.png");
	private double speed = 1;
	private int x; // blinky's position
	private int y;
	private FireBalls fireballs; // blinky's weapon
	private int PacmanX;
	private int PacmanY;	

	private int[][] boardGame; 
	private final static int WALL=3;
	private final static int UP=0,DOWN=1,LEFT=2,RIGHT=3;
	private boolean startMoving=false; // blinky can't move until startMoving is true
	private int out=2; // the amount of moves that need to be done in order to leave the cage
	private boolean chase=false; // starting to chase after reaching the corner
	private int lastMove; // the last move blinky made
	private boolean changeX=false;
	private Random rand= new Random();
	private int stuck;

	/**
	 * Blinky's constructor.
	 * 
	 * @param x1 - blinky's position.
	 * @param y1 - blinky's position.
	 * @param board - the board of the game.
	 */
	public Blinky(int x1, int y1, int [][]board) {
		MyTimer.getInstance((int) this.speed).add(this); // adding a timer to blinky
		this.boardGame=board;
		this.x=x1;
		this.y=y1;
		this.fireballs=new FireBalls(this, this.x, this.y); // initiating blinky's weapon 
	}

	/**
	 * This function makes sure that the gust moves.
	 */
	@Override
	public void action() {
		if (this.y==38 && this.x==1) // if Blinky reached the right corner
			this.chase=true;
		if (this.startMoving==true)
			move();
	}

	/**
	 * This function moves the gust.
	 * This function first makes sure that the gust is out of the cage, 
	 * then makes sure that it reaches the right corner,
	 * and then moves it randomly.
	 */
	public void move() {
		if (this.chase==false && this.out!=0) {
			if (this.out==2) 
				this.y-=1;
			else 
				this.x-=1;
			this.out--;
			this.lastMove=UP;
		}
		/*else if (this.chase==false) // going to the right corner
			if (canMove(this.x, this.y+1)) //right
				this.y+=1;
			else if (canMove(this.x-1, this.y)) // up
				this.x-=1;
			else if (canMove(this.x, this.y-1)) // left
				this.y-=1;
			else  // down
				this.x+=1; 
		 */
		else {
			if (this.changeX==true) {
				if (this.x>this.PacmanX && canMove(this.x-1, this.y)) {
					this.x-=1;
				}
				else if (this.x<this.PacmanX && canMove(this.x+1, this.y)) {
					this.x+=1;
				}
				else if (canMove(this.x, this.y-1)) {
					this.y-=1;
					this.changeX=false;
				}
				else if ( canMove(this.x, this.y+1)) {
					this.y+=1;
					this.changeX=false;
				}
				else {
					System.out.println("1");
				}
			}
			else {
				if (this.y>this.PacmanY && canMove(this.x, this.y-1)) {
					this.y-=1;
				}
				else if (this.y<this.PacmanY && canMove(this.x, this.y+1)) {
					this.y+=1;
				}
				else if (canMove(this.x-1, this.y)) {
					this.x-=1;
					this.changeX=true;
				}
				else if (canMove(this.x+1, this.y)) {
					this.x+=1;
					this.changeX=true;
				}
				else {
					this.changeX=true;
					//System.out.println(this.boardGame[this.x][this.y-1]+ " , "+this.boardGame[this.x][this.y+1]+" , "+ WALL);
					//System.out.println(this.boardGame[this.x-1][this.y]+ " , "+this.boardGame[this.x+1][this.y]+" , "+ WALL);
					System.out.println(this.x+","+this.y+" ; "+this.PacmanX+","+this.PacmanY);
				}
			}
		}
	}
	/*
	 * if (moved==false) {
				if (this.stuck==RIGHT) //y+1
					if (this.x<this.PacmanX) {
						if (canMove(this.x+1, this.y))
							this.x+=1;
					}
					else if (this.x>this.PacmanX) {
						if (canMove(this.x-1, this.y))
							this.x-=1;
					}
					else {
						if (canMove(this.x, this.y-1))
							this.y-=1;
					}
				else if (this.stuck==LEFT) { //y-1
					if (canMove(this.x+1, this.y) && this.lastMove!=UP) {
						this.x+=1;
						this.lastMove=DOWN;
					}
					else if (canMove(this.x-1, this.y) && this.lastMove!=DOWN) {
						this.x-=1;
						this.lastMove=UP;
					}
					else if (canMove(this.x, this.y+1) && this.lastMove!=LEFT) {
						this.y+=1;
						this.lastMove=RIGHT;
					}
				}
				else if (this.stuck==DOWN) //x+1
					if (this.y<this.PacmanY) {
						if (canMove(this.x, this.y+1))
							this.y+=1;
					}
					else if (this.y>this.PacmanY) {
						if (canMove(this.x, this.y-1))
							this.y-=1;
					}
					else {
						if (canMove(this.x-1, this.y))
							this.x-=1;
					}
				else 
					if (this.y<this.PacmanY) {
						if (canMove(this.x, this.y+1))
							this.y+=1;
					}
					else if (this.y>this.PacmanY) {
						if (canMove(this.x, this.y-1))
							this.y-=1;
					}
					else {
						if (canMove(this.x+1, this.y))
							this.x+=1;
					}

	/*	else { // goes in a strait line until it reaches a wall, then moves to a random direction
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
		}*/


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
	 * Blinky visits pacman
	 * @Override
	 */
	public void visit(Pacman pacman) {
		if (pacman.getLevel()==3)
			pacman.setLives(pacman.getLives()-1);
	}

	/**
	 * Getters & setters.
	 */

	public void setPacmanX(int pacmanX) {
		this.PacmanX=pacmanX;
	}

	public void setPacmanY(int pacmanY) {
		this.PacmanY=pacmanY;
	}

	public FireBalls getFireBalls() {
		return this.fireballs;
	}

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

	public void setStartMoving (boolean start) {
		this.startMoving=start;
	}

	public boolean getStartMoving () {
		return this.startMoving;
	}

	@Override
	public void setSpeed(double speed) {
		// TODO Auto-generated method stub

	}/*
	public void setTimersDelay(int n) {
		MyTimer.getInstance().setTimersDelay((int) this.speed /n);
	}*/
}

// chasing pacman
/*	boolean moved=false;
			if (this.x<this.PacmanX) {
				if (canMove(this.x+1, this.y)) {
					this.x+=1;
					moved=true;
					this.lastMove=DOWN;
				}

			if (this.x>this.PacmanX && moved==false) {
				if (canMove(this.x-1, this.y)) {
					this.x-=1;
					moved=true;
					this.lastMove=UP;
				}
				//	else 
				//	this.stuck=UP;
			}
			if (this.y<this.PacmanY && moved==false) {
				if (canMove(this.x, this.y+1)) {
					this.y+=1;
					moved=true;
					this.lastMove=RIGHT;
				}
				//	else 
				//			this.stuck=RIGHT;
			}
			if (this.y>this.PacmanY && moved==false) {
				if (canMove(this.x, this.y-1)) {
					this.y-=1;
					moved=true;
					this.lastMove=LEFT;
				}
				//	else 
				//	this.stuck=LEFT;
			}
			if (this.x==this.PacmanX && this.y==this.PacmanY)
				moved=true;

			if (moved==false) {
				if (this.lastMove==RIGHT) {
					if (this.y<this.PacmanY) {
						if (canMove(this.x, this.y+1))
							this.y+=1;
					}
					else {
						if (canMove(this.x, this.y-1))
							this.y-=1;
					}
					if (canMove(this.x+1, this.y))
						this.x+=1;
				}
				else if (this.lastMove==LEFT) {
					if (this.y<this.PacmanY) {
						if (canMove(this.x, this.y+1))
							this.y+=1;
					}
					else {
						if (canMove(this.x, this.y-1))
							this.y-=1;
					}
					if (canMove(this.x-1, this.y))
						this.x-=1;
				}
				else if (this.lastMove==UP) {
					if (this.x<this.PacmanX) {
						if (canMove(this.x+1, this.y))
							this.x+=1;
					}
					else {
						if (canMove(this.x-1, this.y))
							this.x-=1;
					}
					if (canMove(this.x, this.y+1))
						this.y+=1;
				}
				else if (this.lastMove==DOWN) {
					if (this.x<this.PacmanX) {
						if (canMove(this.x+1, this.y))
							this.x+=1;
					}
					else {
						if (canMove(this.x-1, this.y))
							this.x-=1;
					}
					if (canMove(this.x, this.y-1))
						this.y-=1;
				}
 */
