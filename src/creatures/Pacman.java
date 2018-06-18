package creatures;

import javax.swing.ImageIcon;

import visitInterface.Visited;
import visitInterface.Visitor;

/**
 * 
 * This class represents the pacman character.
 *
 */
public class Pacman extends Creature implements Visited{
	private ImageIcon imLevel1Left = new ImageIcon("yellowLeft.gif");
	private ImageIcon imLevel1Right = new ImageIcon("yellowRight.gif");
	private ImageIcon imLevel1Up = new ImageIcon("yellowUp.gif");
	private ImageIcon imLevel1Down = new ImageIcon("yellowDown.gif");

	private ImageIcon imLevel2Left = new ImageIcon("blueLeft.gif");
	private ImageIcon imLevel2Right = new ImageIcon("blueRight.gif");
	private ImageIcon imLevel2Up = new ImageIcon("blueUp.gif");
	private ImageIcon imLevel2Down = new ImageIcon("blueDown.gif");

	private ImageIcon imLevel3Left = new ImageIcon("redLeft.gif");
	private ImageIcon imLevel3Right = new ImageIcon("redRight.gif");
	private ImageIcon imLevel3Up = new ImageIcon("redUp.gif");
	private ImageIcon imLevel3Down = new ImageIcon("redDown.gif");

	private final static int UP=0,DOWN=1,LEFT=2,RIGHT=3;
	private int way=RIGHT; // where the pacman is going
	private int level=1; 
	private int lives=3; // pacman as 3 lives at the beginning 
	private int points=0; // pacman doesn't have any points at the beginning
	private int fruits=0; // pacman didn't eat any fruit at the beginning
	private double speed = 5;
	private int x; // where the pacman is 
	private int y;
	private boolean startMoving=false; // 
	private int freezeCounter=0; // while this counter is zero, pacman can move
	private int secTime; // the time that passed since starting the game
	//	private int radius;

	/**
	 * Constructor of Pacman with a given position
	 * @param x  value of the pacman position
	 * @param y  value of the pacman position
	 * @param radius the shape size of the pacman
	 */
	/*	public Pacman(int x, int y, int radius) {
		this.x=x;
		this.y=y;
		this.radius=radius;
	}*/

	/**
	 * pacman's constructor.
	 * 
	 * @param x - pacman's position.
	 * @param y - pacman's position.
	 */
	public Pacman(int x, int y) {
		this.x=x;
		this.y=y;
	}
	/*
	public boolean inPosition(int x, int y) { 
		boolean ans=false;
		if (this.x>x) { // if the pacman x is greater then the given x
			ans= this.x-radius<=x; // check if the given x is inside the pacman position
			if (ans==false) return false;
		}
		else {
			ans=this.x+radius>=x;  // check if the given x is inside the pacman position
			if (ans==false) return false;
		}
		if (this.y>y) {  // if the pacman y is greater then the given y
			ans=this.y-radius<=y;  // check if the given y is inside the pacman position
			if (ans==false) return false;
		}
		else {
			ans=this.y+radius>=y;  // check if the given y is inside the pacman position
			if (ans==false) return false;	
		}
		return ans;
	}
	 */


	/**
	 * @Override
	 * This function accepts a visitor.
	 */
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	/**
	 * @Override
	 * This function checks pacman's way in order to return 
	 * the image of pacman that is looking to the direction of its way.
	 * 
	 * @return - the image of pacman.
	 */
	public ImageIcon getImage() {
		if (level==1) {
			if (way==UP)
				return this.imLevel1Up;
			else if (way==DOWN)	
				return this.imLevel1Down;
			else if (way==RIGHT)
				return this.imLevel1Right;
			else
				return this.imLevel1Left;
		}
		else if (level==2){
			if (way==UP)
				return this.imLevel2Up;
			else if (way==DOWN)	
				return this.imLevel2Down;
			else if (way==RIGHT)
				return this.imLevel2Right;
			else
				return this.imLevel2Left;
		}
		else{
			if (way==UP)
				return this.imLevel3Up;
			else if (way==DOWN)	
				return this.imLevel3Down;
			else if (way==RIGHT)
				return this.imLevel3Right;
			else
				return this.imLevel3Left;
		}
	}

	
	/**
	 * Getters & setters.
	 */
	public void setX(int x) {
		if (x<this.x) // changing where pacman is going
			this.way=UP;
		else
			this.way=DOWN;
		this.x=x;
	}

	public int getX() {
		return this.x;
	}

	public void setY(int y) {
		if (y<this.y) // changing where pacman is going
			this.way=LEFT;
		else
			this.way=RIGHT;
		this.y=y;
	}
	
	public int getY() {
		return this.y;
	}

	 @Override
	public double getSpeed() {
		return this.speed;
	}

	public void setLives(int lives) {
		this.lives=lives;
	}

	public int getLives() {
		return this.lives;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level=level;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points=points;
	}
	
	public int getFruits() {
		return this.fruits;
	}

	public void setFruits(int fruits) {
		this.fruits=fruits;
	}
	
	public void setFreezeCounter (int time) {
		this.freezeCounter=time;
	}

	public int getFreezeCounter () {
		return this.freezeCounter;
	}

	public void setSecTime (int sec) {
		this.secTime=sec;
	}

	public int getSecTime () {
		return this.secTime;
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

	public void setWay(int way) {
		this.way=way;		
	}

	public int getWay() {
		return this.way;
	}
}
