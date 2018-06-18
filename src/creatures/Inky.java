package creatures;

import java.util.Random;
import javax.swing.ImageIcon;
import timer.MyTimer;
import timer.TimerListener;
import visitInterface.Visitor;

/**
 * This class represents the gust Blinky.
 * Blinky has a weapon - waterSplash.
 *
 */
public class Inky extends Creature implements TimerListener, Visitor{
	private ImageIcon im = new ImageIcon("INKY.png");
	private double speed = 1;
	private int x; // inky's position
	private int y;
	private WaterSplash waterSplash; // Inky's weapon
	private int freezeCounter=0;

	private int[][] boardGame;
	private final static int WALL=3;
	private final static int UP=0,DOWN=1,LEFT=2,RIGHT=3;
	private boolean startMoving=false; // inky can't move until startMoving is true
	private int out=2; // the amount of moves that need to be done in order to leave the cage
	private boolean chase=false; // starting to chase after reaching the corner
	private int lastMove;
	//private int radius;

	/**
	 * Inky's constructor.
	 * 
	 * @param x1 - Inky's position.
	 * @param y1 - Inky's position.
	 * @param board - the board of the game.
	 */
	public Inky(int x1, int y1, int [][]board) {
		MyTimer.getInstance((int) speed).add(this);

		//Timer t=new Timer((int) (1000/4), this);
		//t.start();

		this.boardGame=board;
		this.x=x1;
		this.y=y1;
		waterSplash= new WaterSplash(this, this.x, this.y);
	}
	
	/**
	 * This function makes sure that the gust moves.
	 */
	@Override
	public void action() {
		if (this.y==38 && this.x==1) // if Inky reached the right corner
			this.chase=true;
		if (this.startMoving==true) // if inky can move
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
				this.y+=1;
			else 
				this.x-=1;
			this.out--;
			this.lastMove=UP;
		}

		else if (this.chase==false)  // going to the right corner
			if (canMove(this.x, this.y+1)) //right
				this.y+=1;
			else if (canMove(this.x-1, this.y)) // up
				this.x-=1;
			else if (canMove(this.x, this.y-1)) // left
				this.y-=1;
			else  // down
				this.x+=1; 
		
		// making sure that the gust isn't frozen
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
	 * Inky visits pacman
	 * @Override
	 */
	public void visit(Pacman pacman) {
		if (this.chase==true)
			if (pacman.getLevel()==2) {
				pacman.setFreezeCounter(pacman.getSecTime()); // pacman can't move for 5 seconds
				pacman.setPoints(pacman.getPoints()-10);
			}
			else if (pacman.getLevel()==3) // level==3
				this.freezeCounter=pacman.getSecTime(); //inky freezes for 5 seconds
	}

	/**
	 * Getters & setters
	 */
	public WaterSplash getWaterSplash() {
		return this.waterSplash;
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

	public void setFreezeCounter (int time) {
		this.freezeCounter=time;
	}

	public int getFreezeCounter () {
		return this.freezeCounter;
	}

	public void setStartMoving (boolean start) {
		this.startMoving=start;
	}

	public boolean getStartMoving () {
		return this.startMoving;
	}

	@Override
	public void setSpeed(double speed) {
		this.speed=speed;
	}

	/*public void setTimersDelay(int n) {
		MyTimer.getInstance().setTimersDelay((int) this.speed /n);
	}*/
}
