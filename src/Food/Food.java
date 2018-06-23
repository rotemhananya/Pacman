package Food;

import java.util.Random;

import javax.swing.ImageIcon;

import GameBoard.GamePanel;

/**
 * This class represents the food in the game
 */
public abstract class Food {
	protected int x;
	protected int y;
	protected GamePanel GamePanel;
	protected boolean Eaten=false;
	protected boolean Shown=false;
	protected Random rand= new Random();

	public Food(int x, int y, GamePanel gamePanel) {
		this.x=x;
		this.y=y;
		this.GamePanel=gamePanel;
	}
	
	public Food(GamePanel gamePanel) {
		this.GamePanel=gamePanel;
	}
	
	
	/**
	 * This function finds a random place (that is not a wall) for food
	 * & sets it to shown.
	 */
	public void setFoodShown() {
			int i=rand.nextInt(40);
			int j=rand.nextInt(40);
			while (!GamePanel.canMove(i,j)) {
				i=rand.nextInt(40);
				j=rand.nextInt(40);
			}	
			this.x=i;
			this.y=j;
			this.Shown=true;
		}

	public abstract void Eated();
	

	/**
	 * Getters & setters
	 */
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public boolean getEaten() {
		return this.Eaten;
	}

	public void setEaten(boolean eaten) {
		this.Eaten=eaten;
	}

	public boolean getShown() {
		return this.Shown;
	}

	public void setShown(boolean shown) {
		this.Shown=shown;
	}

public abstract ImageIcon getImage(int i) ;
}
