package Pacman;
import javax.swing.ImageIcon;
import VisitInterface.Visited;
import VisitInterface.Visitor;

/**
 * 
 * This class represents the pacman character.
 *
 */
public abstract class Pacman implements Visited{
	protected final static int UP=0,DOWN=1,LEFT=2,RIGHT=3;
	protected int Way=RIGHT; // where the pacman is going
	protected int Lives=3; // pacman has 3 lives at the beginning 
	protected int Points=0; // pacman doesn't have any points at the beginning
	protected int Fruits=0; // pacman didn't eat any fruit at the beginning
	protected int x; // where the pacman is 
	protected int y;
	protected boolean StartMoving=false; // 
	protected int FreezeCounter=0; // while this counter is zero, pacman can move
	protected int SecTime; // the time that passed since starting the game
	protected int Level;
	

	/**
	 * pacman's constructor.
	 * 
	 */
	public Pacman() {
		this.x=17;
		this.y=19;
	}

	/**
	 * @Override
	 * This function accepts a visitor.
	 */
	public abstract void accept(Visitor visitor) ;
	

	/**
	 * Getters & setters.
	 */
	public void setX(int x) {
		if (x<this.x) // changing where pacman is going
			this.Way=UP;
		else
			this.Way=DOWN;
		this.x=x;
	}

	public int getX() {
		return this.x;
	}

	public void setY(int y) {
		if (y<this.y) // changing where pacman is going
			this.Way=LEFT;
		else
			this.Way=RIGHT;
		this.y=y;
	}

	public int getY() {
		return this.y;
	}

	public void setLives(int lives) {
		if (lives<4)
			this.Lives=lives;
		else 
			this.Lives=3;
	}

	public int getLives() {
		return this.Lives;
	}

	public int getPoints() {
		return this.Points;
	}

	public void setPoints(int points) {
		if (points>0)
			this.Points=points;
		else 
			this.Points=0;
	}

	public int getFruits() {
		return this.Fruits;
	}

	public void setFruits(int fruits) {
		this.Fruits=fruits;
	}

	public void setFreezeCounter (int time) {
		this.FreezeCounter=time;
	}

	public int getFreezeCounter () {
		return this.FreezeCounter;
	}

	public void setSecTime (int sec) {
		this.SecTime=sec;
	}

	public int getSecTime () {
		return this.SecTime;
	}

	public void setStartMoving (boolean start) {
		this.StartMoving=start;
	}

	public boolean getStartMoving () {
		return this.StartMoving;
	}

	public void setWay(int way) {
		this.Way=way;		
	}

	public int getWay() {
		return this.Way;
	}

	public ImageIcon getImage() {
		return null;
	}
	
	public int getLevel() {
		return this.Level;
	}
}
