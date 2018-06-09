package hw4;

import javax.swing.ImageIcon;

/**
 * 
 * This class represents the pacman character.
 *
 */
public class Pacman extends Creature implements Visited{
	private ImageIcon imLevel1 = new ImageIcon("***.png");
	private ImageIcon imLevel2 = new ImageIcon("***.png");
	private ImageIcon imLevel3 = new ImageIcon("***.png");
	private int level=1;
	private int life=3;
	private int points=0;
	private double speed = 5;
	private int x;
	private int y;
	private int radius;

	/**
	 * Constructor of Pacman with a given position
	 * @param x  value of the pacman position
	 * @param y  value of the pacman position
	 * @param radius the shape size of the pacman
	 */
	public Pacman(int x, int y, int radius) {
		this.x=x;
		this.y=y;
		this.radius=radius;
	}

	public Pacman(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
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
	/**
	 * This method moves the pacman in the x axis
	 * @param x the x value
	 */
	public void moveX(int x) {
		this.x=x;
	}

	/**
	 * This method returns the y value of the paman's position
	 * @return y location
	 */
	public int getX() {
		return this.x;
	}
	/**
	 * This method moves the pacman in the y axis
	 * @param y the y value
	 */
	public void moveY(int y) {
		this.y=y;
	}
	/**
	 * This method returns the y value of the paman's position
	 * @return y location
	 */
	public int getY() {
		return this.y;
	}

	@Override
	public ImageIcon getImage() {
		if (level==1)
			return this.imLevel1;
		else if (level==2)
			return this.imLevel2;
		else
			return this.imLevel3;
	}

	@Override
	public double getSpeed() {
		return this.speed;
	}

	public void visit(Ginkey ginkey) {
		if (level==1)
			this.life-=1;
		//else if (level==2)
			//ginky disappears for 5 seconds
		//	else
				//ginky dies

	}

	@Override
	public void visit(Inky inky) {
		if (level==1)
			return;
		else if (level==2) {
			// pacman can't move for 5 seconds
			this.points-=10;
		}
	//	else
			//inky freezes for 5 seconds
	}

	@Override
	public void visit(Blinky blinky) {
		if (level==3)
			this.life-=1;

	}

	@Override
	public void visit(FireBalls firaBalls) {
		if (level==3)
			this.life-=1;
	}

	@Override
	public void visit(WaterSplash waterSplash) {
		if (level==1)
			return;
		else if (level==2) {
			//pacman disappears for 3 seconds
			this.points-=10;
		}
		//else
			//inky freezes for 5 seconds

	}


	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Pacman pacman) {
		// TODO Auto-generated method stub
		
	}

}
