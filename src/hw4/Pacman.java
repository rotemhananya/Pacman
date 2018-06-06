package hw4;

/**
 * 
 * This class represents the pacman character.
 *
 */
public class Pacman extends Creature {
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
}
