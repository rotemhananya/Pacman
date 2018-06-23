package GhostsWeapons;

import GameBoard.GamePanel;
import Timer.TimerListener;
import VisitInterface.Visitor;

/**
 * This class is an abstracts class that represents a weapon.
 *
 */

public abstract class Weapons implements TimerListener, Visitor {
	
	protected int speed=1;
	protected int x;
	protected int y;
	protected GamePanel GamePanel;	
	protected final static int UP=0,LEFT=2,RIGHT=3; // DOWN=1
	protected int[] Moves=new int [2];
	protected int MovesDone=0;
	protected boolean StartMoving=false;
	
	/**
	 * gets and sets
	 */
	public int getSpeed() {
		return this.speed;
	}


	public void setSpeed(int speed) {
		this.speed=speed;
	}
	

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x=x;
	}


	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y=y;
	}


	
	public void setStartMoving(Boolean startMoving) {
		this.StartMoving=startMoving;		
	}

	
	public boolean getStartMoving() {
		return this.StartMoving;
	}

}
