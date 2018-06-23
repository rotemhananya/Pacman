package Pacman;

import javax.swing.ImageIcon;

import VisitInterface.Visitor;

public class Pacman3 extends Pacman{
	private ImageIcon imLevel3Left = new ImageIcon("redLeft.gif");
	private ImageIcon imLevel3Right = new ImageIcon("redRight.gif");
	private ImageIcon imLevel3Up = new ImageIcon("redUp.gif");
	private ImageIcon imLevel3Down = new ImageIcon("redDown.gif");

	/**
	 * Pacman3's constructor.
	 * 
	 * @param lives - the amount of lives pacman had when he finished the previous level.
	 * @param points - the amount of points pacman had when he finished the previous level.
	 * @param fruits - the amount of fruits pacman had when he finished the previous level.
	 * @param secTime - the amount of seconds that had passed since the beginning of the game.
	 */
	public Pacman3(int lives, int points, int fruits, int secTime) {
		super();
		this.Lives=lives;
		this.Points=points;
		this.Fruits=fruits;
		this.SecTime=secTime;
		this.Level=3;
	}

	
	@Override
	public void accept(Visitor visitor) {
			visitor.visit(this);
	}
	
	/**
	 * This function checks pacman's way in order to return 
	 * the image of pacman that is looking to the direction of its way.
	 * 
	 * @return - the image of pacman.
	 */
	public ImageIcon getImage() {
		if (Way==UP)
			return this.imLevel3Up;
		else if (Way==DOWN)	
			return this.imLevel3Down;
		else if (Way==RIGHT)
			return this.imLevel3Right;
		else
			return this.imLevel3Left;
	}

}
