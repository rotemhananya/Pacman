package Ghosts;

import java.util.Random;
import javax.swing.ImageIcon;
import Timer.TimerListener;
import VisitInterface.Visitor;
import GameBoard.GamePanel;


/**
 * This class is an abstract class that represents a ghost.
 */
public abstract class Ghost implements TimerListener, Visitor {
	protected ImageIcon Im;
	protected int Speed;
	protected int Sec=0;
	protected int x; // ghost's position
	protected int y;
	protected int LastX = -1;
	protected int LastY = -1;
	protected GamePanel GamePanel; 
	protected int[] Out; // the amount of moves that need to be done in order to leave the cage
	protected int OutCounter=0;
	protected boolean Chase=false;
	protected int FreezeCounter=0;
	protected boolean StartMoving=false;  // the ghost can't move until startMoving is true
	protected final static int UP=0,DOWN=1,LEFT=2,RIGHT=3;
	protected Random Rand= new Random();
	protected int CountRandom=0;

	protected void outOfCage() { 
		if (this.Out[this.OutCounter]==UP)
			this.x-=1;
		else if (this.Out[this.OutCounter]==DOWN)
			this.x+=1;
		else if (this.Out[this.OutCounter]==LEFT)
			this.y-=1;
		else // RIGHT
			this.y+=1;
		this.OutCounter++;
	}
/**
 * This method checks if the ghosts reached the corner
 */
	protected void reachCorner() {
		if (this.GamePanel.canMove(this.x, this.y+1)) //right
			this.y+=1;
		else if (this.GamePanel.canMove(this.x-1, this.y)) // up
			this.x-=1;
		else if (this.GamePanel.canMove(this.x, this.y-1)) // left
			this.y-=1;
		else  // down
			this.x+=1;
	}

/**
 * This method chases after the pacman
 */
	protected void chasePacman() {
		boolean moved=false; 
		boolean PacmanXBigger=this.GamePanel.PacmanXBigger(this);
		boolean PacmanYBigger=this.GamePanel.PacmanYBigger(this);
		boolean moveX=false;
		boolean moveY=false;

		if (PacmanXBigger && this.GamePanel.canMove(this.x+1, this.y)) { // if the pacman stands below the ghost
			if (moveX==false && LastX!=this.x+1) { // if the move is not repeated
				LastX=this.x; // saving the last position
				LastY=this.y;
				this.x+=1;
				moved=true;
			}
			moveX=!moveX; 
		}
		if (!PacmanXBigger && moved==false && this.GamePanel.canMove(this.x-1, this.y)) { // if the pacman stands above the ghost
			if (moveX==false &&LastX!=this.x-1) { // if the move is not repeated
				LastX=this.x; // saving the last position
				LastY=this.y;
				this.x-=1;
				moved=true;
			}
			moveX=!moveX;
		}
		if (PacmanYBigger && moved==false && this.GamePanel.canMove(this.x, this.y+1)) { // if the pacman stands int the right of the ghost
			if (moveX==false &&LastY!=this.y+1) { // if the move is not repeated
				LastX=this.x; // saving the last position
				LastY=this.y;
				this.y+=1;
				moved=true;
			}
			moveY=!moveY;
		}
		if (!PacmanYBigger && moved==false && this.GamePanel.canMove(this.x, this.y-1)) { // if the pacman stands in the left of the ghost
			if (moveX==false &&LastY!=this.y-1) { // if the move is not repeated
				LastX=this.x; // saving the last position
				LastY=this.y;
				this.y-=1;
				moved=true;
			}
			moveY=!moveY;
		}

		if (moved==false || (moveX==false && moveY==false)) {
			this.CountRandom=5;
		}
	}


	/**
	 * This method randoms the ghost's next move
	 */
	protected void randomMove() {
		Random r = new Random();
		String [] randMoves = new String[4];
		int moves=0;
		if (this.GamePanel.canMove(x, y+1)) { // if the ghost can move right
			randMoves[moves]="RIGHT";
			moves++;
		}
		if (this.GamePanel.canMove(x, y-1)) {// if the ghost can move left
			randMoves[moves]="LEFT";
			moves++;
		}
		if (this.GamePanel.canMove(x+1, y)) {// if the ghost can move down
			randMoves[moves]="DOWN";
			moves++;
		}
		if (this.GamePanel.canMove(x-1, y)) {//// if the ghost can move up
			randMoves[moves]="UP";
			moves++;
		}
		
		int ans=r.nextInt(moves); // create a valid moves array of the ghost 
		String move= randMoves[ans];
		
		if (move=="RIGHT")
			y++;
		else if (move=="LEFT")
			y--;
		else if(move=="DOWN")
			x++;
		else
			x--;
		this.CountRandom--; // update the random counter
	}

	
	
	
	/**
	 * This method sets new speed to the ghost
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.Speed=speed;
	}


	public ImageIcon getImage() {
		return this.Im;
	}

	public int getSpeed() {
		return this.Speed;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public boolean getChase() {
		return Chase;
	}


	public void setStartMoving (boolean start) {
		this.StartMoving=start;
	}

	public boolean getStartMoving () {
		return this.StartMoving;
	}

	public void setFreezeCounter (int time) {
		this.FreezeCounter=time;
	}

	public int getFreezeCounter () {
		return this.FreezeCounter;
	}

	protected abstract void setStartMoving();

}
